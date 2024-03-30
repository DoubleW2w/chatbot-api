package com.doublew2w.chatbot.api.domain.zsxq.model.vo;

/**
 * @author: DoubleW2w
 * @description:
 * @date: 2024/3/30 1:53
 * @project: chatbot-api
 */
public class Talk {
  private Owner owner;
  private String text;

  public void setOwner(Owner owner) {
    this.owner = owner;
  }

  public Owner getOwner() {
    return owner;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getText() {
    return text;
  }
}
