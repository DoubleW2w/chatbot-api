package com.doublew2w.chatbot.api.application.job;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.fastjson2.JSON;
import com.doublew2w.chatbot.api.domain.ai.service.OpenAI;
import com.doublew2w.chatbot.api.domain.zsxq.model.aggregates.QueryTopicsAggregates;
import com.doublew2w.chatbot.api.domain.zsxq.model.req.CommentReq;
import com.doublew2w.chatbot.api.domain.zsxq.model.req.CommentReqData;
import com.doublew2w.chatbot.api.domain.zsxq.model.req.TopicsReq;
import com.doublew2w.chatbot.api.domain.zsxq.model.res.CommentRes;
import com.doublew2w.chatbot.api.domain.zsxq.model.vo.Topics;
import com.doublew2w.chatbot.api.domain.zsxq.service.ZsxqApi;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author: DoubleW2w
 * @description:
 * @date: 2024/3/31 0:38
 * @project: chatbot-api
 */
@EnableScheduling
@Configuration
public class ChatbotSchedule {
  private final Logger logger = LoggerFactory.getLogger(ChatbotSchedule.class);

  @Value("${chatbot-api.groupId}")
  private String groupId;

  @Value("${chatbot-api.cookie}")
  private String cookie;

  @Value("${chatbot-api.userId}")
  private String userId;

  @Value("${chatbot-api.openAiKey}")
  private String openAiKey;

  @Resource private ZsxqApi zsxqApi;
  @Resource private OpenAI openAI;

  /** 每隔三十秒扫描一次，回答一次问题 */
  @Scheduled(cron = "0/30 * * * * ?")
  public void run() {
    try {
      if (new Random().nextBoolean()) {
        logger.info("随机打烊中...");
        return;
      }

      GregorianCalendar calendar = new GregorianCalendar();
      int hour = calendar.get(Calendar.HOUR_OF_DAY);
      if (hour + 5 > 22 || hour + 5 < 7) {
        logger.info("打烊时间不工作，AI 下班了！");
        return;
      }
      // 检索评论数据
      TopicsReq topicsReq = new TopicsReq();
      topicsReq.setGroupId(groupId);
      topicsReq.setCookie(cookie);
      topicsReq.setScope("all");
      topicsReq.setCount(20);
      QueryTopicsAggregates queryTopicsAggregates = zsxqApi.queryTopicsAggregates(topicsReq);
      logger.info("检索结果：{}", JSON.toJSONString(queryTopicsAggregates));
      if (queryTopicsAggregates.getTopicsResData() == null) {
        logger.info("本次检索未查询到待会答问题");
        return;
      }
      List<Topics> topics = queryTopicsAggregates.getTopicsResData().getTopics();
      topics =
          topics.stream()
              .filter(x -> x.getTalk() != null)
              .filter(
                  x -> x.getTalk().getText().contains("type=\"mention\" uid=\"815515128582112\""))
              .filter(x -> x.getCommentsCount() < 1)
              .filter(x -> x.getTalk().getOwner() != null)
              .filter(x -> x.getTalk().getOwner().getUserId().equals(userId))
              .collect(Collectors.toList());
      if (CollUtil.isEmpty(topics)) {
        logger.info("本次检索未查询到待会答问题");
        return;
      }
      // AI回答问题
      // 2. AI 回答
      Topics topic = topics.get(0);
      String answer = openAI.doChatGPT(openAiKey, topic.getTalk().getText().trim());
      // 问题回复
      CommentReq commentReq = new CommentReq();
      commentReq.setCookie(cookie);
      commentReq.setTopicId(topic.getTopicId());
      CommentReqData commentReqData = new CommentReqData();
      commentReqData.setText(answer);
      commentReq.setCommentReqData(commentReqData);

      CommentRes commentRes = zsxqApi.commentTopic(commentReq);
      logger.info(
          "编号：{} 问题：{} 回答：{} 状态：{}",
          topic.getTopicId(),
          topic.getTalk().getText(),
          answer,
          commentRes.isSucceeded());
    } catch (Exception e) {
      logger.error("自动回答问题异常：{}", e.getMessage(), e);
    }
  }
}
