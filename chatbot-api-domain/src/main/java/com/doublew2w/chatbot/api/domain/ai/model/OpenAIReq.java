package com.doublew2w.chatbot.api.domain.ai.model;

import com.doublew2w.chatbot.api.domain.ai.model.vo.Message;

import java.util.List;

/**
 * @author: DoubleW2w
 * @description:
 * @date: 2024/3/30 21:12
 * @project: chatbot-api
 */
public class OpenAIReq {

  private Long maxTokens;

  private List<Message> messages;
  private String model;
  private Long temperature;


  public Long getMaxTokens() {
    return maxTokens;
  }

  public void setMaxTokens(Long value) {
    this.maxTokens = value;
  }

  public List<Message> getMessages() {
    return messages;
  }

  public void setMessages(List<Message> value) {
    this.messages = value;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String value) {
    this.model = value;
  }


  public Long getTemperature() {
    return temperature;
  }

  public void setTemperature(Long value) {
    this.temperature = value;
  }

}
