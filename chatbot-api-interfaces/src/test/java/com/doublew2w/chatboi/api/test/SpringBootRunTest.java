package com.doublew2w.chatboi.api.test;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson2.JSON;
import com.doublew2w.chatbot.api.ApiApplication;
import com.doublew2w.chatbot.api.domain.ai.service.OpenAI;
import com.doublew2w.chatbot.api.domain.zsxq.model.aggregates.QueryTopicsAggregates;
import com.doublew2w.chatbot.api.domain.zsxq.model.req.CommentReq;
import com.doublew2w.chatbot.api.domain.zsxq.model.req.CommentReqData;
import com.doublew2w.chatbot.api.domain.zsxq.model.req.TopicsReq;
import com.doublew2w.chatbot.api.domain.zsxq.model.res.CommentRes;
import com.doublew2w.chatbot.api.domain.zsxq.model.res.TopicsResData;
import com.doublew2w.chatbot.api.domain.zsxq.model.vo.Owner;
import com.doublew2w.chatbot.api.domain.zsxq.model.vo.Talk;
import com.doublew2w.chatbot.api.domain.zsxq.model.vo.Topics;
import com.doublew2w.chatbot.api.domain.zsxq.service.ZsxqApi;
import java.io.IOException;
import java.util.List;
import javax.annotation.Resource;
import org.apache.hc.core5.http.ParseException;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * @author: DoubleW2w
 * @description:
 * @date: 2024/3/30 14:11
 * @project: chatbot-api
 */
@SpringBootTest(classes = ApiApplication.class)
@ActiveProfiles("dev") // 指定dev配置文件
public class SpringBootRunTest {

  private final Logger logger = LoggerFactory.getLogger(SpringBootRunTest.class);

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

  @Test
  public void test_zsxqApi() throws IOException, ParseException {
    TopicsReq topicsReq = new TopicsReq();
    topicsReq.setCookie(cookie);
    topicsReq.setScope("all");
    topicsReq.setGroupId(groupId);
    topicsReq.setCount(20);
    QueryTopicsAggregates queryTopicsAggregates = zsxqApi.queryTopicsAggregates(topicsReq);
    if (!queryTopicsAggregates.isSucceeded()) {
      logger.info("测试结果：{}", JSON.toJSONString(queryTopicsAggregates));
    }
    TopicsResData topicsResData = queryTopicsAggregates.getTopicsResData();
    if (topicsResData == null) {
      logger.warn("不存在评论数据");
      return;
    }
    List<Topics> topics = topicsResData.getTopics();
    for (Topics topic : topics) {
      String topicId = topic.getTopicId();
      Talk talk = topic.getTalk();
      if (talk == null) {
        continue;
      }
      String text = talk.getText();
      Owner owner = talk.getOwner();
      // 发布人是当前用户才行
      if (owner == null || !owner.getUserId().equals(userId)) {
        continue;
      }
      // 当前评论艾特当前用户，最多回答两次
      if (StrUtil.isNotBlank(text)
          && text.contains("type=\"mention\" uid=\"815515128582112\"")
          && topic.getCommentsCount() < 2) {
        logger.info("topicId：{} text：{},owner:{}", topicId, text, JSON.toJSONString(owner));

        CommentReq commentReq = new CommentReq();
        commentReq.setCookie(cookie);
        commentReq.setTopicId(topicId);
        CommentReqData commentReqData = new CommentReqData();
        commentReqData.setText("你好，这是测试回答评论");
        commentReq.setCommentReqData(commentReqData);
        CommentRes answerRes = zsxqApi.commentTopic(commentReq);

        if (answerRes.isSucceeded()) {
          logger.info("评论回答响应:{}", JSON.toJSONString(answerRes.getCommentResData()));
        } else {
          logger.error("测试评论回答结果失败");
        }
      }
    }
  }

  @Test
  public void test_openAi() throws IOException, ParseException {
    String response = openAI.doChatGPT(openAiKey, "帮我写一个java冒泡排序");
    logger.info("测试结果：{}", response);
  }
}
