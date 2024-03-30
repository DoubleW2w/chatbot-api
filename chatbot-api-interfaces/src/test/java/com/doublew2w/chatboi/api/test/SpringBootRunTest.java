package com.doublew2w.chatboi.api.test;

import com.alibaba.fastjson2.JSON;
import com.doublew2w.chatbot.api.ApiApplication;
import com.doublew2w.chatbot.api.domain.zsxq.IZsxqApi;
import com.doublew2w.chatbot.api.domain.zsxq.model.aggregates.QueryTopicsAggregates;
import com.doublew2w.chatbot.api.domain.zsxq.model.req.CommentReq;
import com.doublew2w.chatbot.api.domain.zsxq.model.req.CommentReqData;
import com.doublew2w.chatbot.api.domain.zsxq.model.req.TopicsReq;
import com.doublew2w.chatbot.api.domain.zsxq.model.res.CommentRes;
import com.doublew2w.chatbot.api.domain.zsxq.model.res.TopicsResData;
import com.doublew2w.chatbot.api.domain.zsxq.model.vo.Owner;
import com.doublew2w.chatbot.api.domain.zsxq.model.vo.Talk;
import com.doublew2w.chatbot.api.domain.zsxq.model.vo.Topics;
import org.apache.hc.core5.http.ParseException;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: DoubleW2w
 * @description:
 * @date: 2024/3/30 14:11
 * @project: chatbot-api
 */
@SpringBootTest(classes = ApiApplication.class)
public class SpringBootRunTest {

  private final Logger logger = LoggerFactory.getLogger(SpringBootRunTest.class);

  @Value("${chatbot-api.groupId}")
  private String groupId;

  @Value("${chatbot-api.cookie}")
  private String cookie;

  @Value("${chatbot-api.userId}")
  private String userId;

  @Resource private IZsxqApi iZsxqApi;

  @Test
  public void test_zsxqApi() throws IOException, ParseException {
    TopicsReq topicsReq = new TopicsReq();
    topicsReq.setCookie(cookie);
    topicsReq.setScope("all");
    topicsReq.setGroupId(groupId);
    topicsReq.setCount(20);
    QueryTopicsAggregates queryTopicsAggregates = iZsxqApi.queryTopicsAggregates(topicsReq);
    if (!queryTopicsAggregates.getSucceeded()) {
      logger.warn("查询主题数据失败");
      logger.info("测试结果：{}", JSON.toJSONString(queryTopicsAggregates));
    }
    TopicsResData topicsResData = queryTopicsAggregates.getTopicsResData();
    if (topicsResData == null) {
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
      if (owner == null) {
        continue;
      }
      if (!owner.getUserId().equals(userId)) {
        continue;
      }
      logger.info("topicId：{} text：{},owner:{}", topicId, text, JSON.toJSONString(owner));

      CommentReq commentReq = new CommentReq();
      commentReq.setCookie(cookie);
      commentReq.setTopicId(topicId);
      CommentReqData commentReqData = new CommentReqData();
      commentReqData.setText("你好，这是测试回答评论");
      commentReqData.setImageIds(new ArrayList<>());
      commentReqData.setMentionedUserIds(new ArrayList<>());
      commentReq.setCommentReqData(commentReqData);
      CommentRes answerRes = iZsxqApi.commentTopic(commentReq);

      if (answerRes.isSucceeded()) {
        logger.info("测试评论回答成功");
        logger.info("评论回答响应:{}", JSON.toJSONString(answerRes.getCommentResData()));
      } else {
        logger.error("测试评论回答结果失败");
      }
    }
  }
}
