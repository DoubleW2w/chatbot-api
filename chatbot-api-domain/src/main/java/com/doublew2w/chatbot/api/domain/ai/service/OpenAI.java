package com.doublew2w.chatbot.api.domain.ai.service;

import com.alibaba.fastjson2.JSON;
import com.doublew2w.chatbot.api.domain.ai.IOpenAI;
import com.doublew2w.chatbot.api.domain.ai.model.OpenAIReq;
import com.doublew2w.chatbot.api.domain.ai.model.aggregates.AIAnswer;
import com.doublew2w.chatbot.api.domain.ai.model.vo.Choices;
import com.doublew2w.chatbot.api.domain.ai.model.vo.Message;
import java.io.IOException;
import java.util.List;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpHeaders;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author: DoubleW2w
 * @description:
 * @date: 2024/3/30 20:54
 * @project: chatbot-api
 */
@Service
public class OpenAI implements IOpenAI {
  private Logger logger = LoggerFactory.getLogger(OpenAI.class);

  @Override
  public String doChatGPT(String openAiKey, String question) throws IOException, ParseException {
    // 创建客户端
    CloseableHttpClient client = HttpClientBuilder.create().build();
    // 创建post请求
    HttpPost post = new HttpPost("https://api.chatanywhere.com.cn/v1/chat/completions");
    // 设置post请求头
    post.setHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType());
    post.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + openAiKey);
    post.setHeader(
        HttpHeaders.USER_AGENT,
        "Mozilla/5.0 (Windows NT 10.0; Win64; x64)AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36");
    // 设置post请求体
    OpenAIReq openAIReq = new OpenAIReq();
    openAIReq.setMaxTokens(1024L);
    Message message = new Message();
    message.setRole("assistant");
    message.setContent(question);
    openAIReq.setMessages(List.of(message));
    openAIReq.setModel("gpt-3.5-turbo");
    openAIReq.setTemperature(0L);
    String paramJson = JSON.toJSONString(openAIReq);
    logger.info("paramJson:{}", paramJson);
    post.setEntity(new StringEntity(paramJson, ContentType.APPLICATION_JSON, "UTF8", false));

    // 发起请求
    CloseableHttpResponse response = client.execute(post);
    response.setHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString());
    if (response.getCode() == HttpStatus.SC_OK) {
      String jsonStr = EntityUtils.toString(response.getEntity());
      AIAnswer aiAnswer = JSON.parseObject(jsonStr, AIAnswer.class);
      StringBuilder answers = new StringBuilder();
      List<Choices> choices = aiAnswer.getChoices();
      for (Choices choice : choices) {
        answers.append(choice.getMessage().getContent());
      }
      return answers.toString();
    } else {
      throw new RuntimeException("api.openai.com Err Code is " + response.getCode());
    }
  }
}
