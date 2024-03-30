package com.doublew2w.chatbot.api.domain.zsxq.service;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson2.JSON;
import com.doublew2w.chatbot.api.domain.zsxq.IZsxqApi;
import com.doublew2w.chatbot.api.domain.zsxq.model.aggregates.QueryTopicsAggregates;
import com.doublew2w.chatbot.api.domain.zsxq.model.req.CommentReq;
import com.doublew2w.chatbot.api.domain.zsxq.model.req.TopicsReq;
import java.io.IOException;

import com.doublew2w.chatbot.api.domain.zsxq.model.res.CommentRes;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpHeaders;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author: DoubleW2w
 * @description:
 * @date: 2024/3/30 2:39
 * @project: chatbot-api
 */
@Service
public class ZsxqApi implements IZsxqApi {

  private final Logger logger = LoggerFactory.getLogger(ZsxqApi.class);

  @Override
  public QueryTopicsAggregates queryTopicsAggregates(TopicsReq req)
      throws IOException, ParseException {
    // 请求客户端
    CloseableHttpClient httpClient = HttpClientBuilder.create().build();
    // 请求
    String getUrl =
        StrUtil.format(
            "https://api.zsxq.com/v2/groups/{}/topics?scope={}&count={}",
            req.getGroupId(),
            req.getScope(),
            req.getCount());
    logger.info("requestUrl:{}", getUrl);
    HttpGet get = new HttpGet(getUrl);
    // 请求头
    get.addHeader(HttpHeaders.COOKIE, req.getCookie());
    get.addHeader(
        HttpHeaders.USER_AGENT,
        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36");
    // 响应
    CloseableHttpResponse response = httpClient.execute(get);
    // 响应头
    response.setHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString());
    if (response.getCode() == HttpStatus.SC_OK) {
      String jsonStr = EntityUtils.toString(response.getEntity());
      logger.info("拉取提问数据。groupId：{} jsonStr：{}", req.getGroupId(), jsonStr);
      return JSON.parseObject(jsonStr, QueryTopicsAggregates.class);
    } else {
      throw new RuntimeException(
          "queryUnAnsweredQuestionsTopicId Err Code is " + response.getCode());
    }
  }

  @Override
  public CommentRes commentTopic(CommentReq req) throws IOException, ParseException {
    CloseableHttpClient httpClient = HttpClientBuilder.create().build();
    // post 请求
    String postUrl = StrUtil.format("https://api.zsxq.com/v2/topics/{}/comments", req.getTopicId());
    HttpPost post = new HttpPost(postUrl);
    logger.info("postUrl:{}", postUrl);
    post.setHeader(HttpHeaders.COOKIE, req.getCookie());
    post.setHeader(
        HttpHeaders.USER_AGENT,
        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36");
    String postEntityStr = JSON.toJSONString(req);
    logger.info("postEntityStr:{}", postEntityStr);
    StringEntity entity = new StringEntity(postEntityStr, ContentType.APPLICATION_JSON);
    post.setEntity(entity);
    // 响应
    CloseableHttpResponse response = httpClient.execute(post);
    response.setHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString());
    if (response.getCode() == HttpStatus.SC_OK) {
      String jsonStr = EntityUtils.toString(response.getEntity());
      logger.info("回答问题结果。topicId：{}  jsonStr：{}", req.getTopicId(), jsonStr);
      return JSON.parseObject(jsonStr, CommentRes.class);
    } else {
      throw new RuntimeException("answer Err Code is " + response.getCode());
    }
  }
}
