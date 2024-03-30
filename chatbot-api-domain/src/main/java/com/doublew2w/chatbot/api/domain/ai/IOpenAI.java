package com.doublew2w.chatbot.api.domain.ai;

import org.apache.hc.core5.http.ParseException;

import java.io.IOException;

/**
 * @author: DoubleW2w
 * @description: chatGpr OpenAI
 * @date: 2024/3/30 20:05
 * @project: chatbot-api
 */
public interface IOpenAI {
  /**
   * 请求chatGPT
   *
   * @param openAiKey apiKey
   * @param question 问题
   * @return 返回结果
   * @throws IOException
   */
  String doChatGPT(String openAiKey, String question) throws IOException, ParseException;
}
