package com.doublew2w.chatbot.api.domain.ai.model.vo;

/**
 * @author: DoubleW2w
 * @description:
 * @date: 2024/3/30 20:42
 * @project: chatbot-api
 */
public class Message {
  private String role;

  private String content;

  public void setRole(String role) {
    this.role = role;
  }

  public String getRole() {
    return this.role;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getContent() {
    return this.content;
  }
}
