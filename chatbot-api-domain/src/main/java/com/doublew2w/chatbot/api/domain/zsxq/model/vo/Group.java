package com.doublew2w.chatbot.api.domain.zsxq.model.vo;

import com.fasterxml.jackson.annotation.JsonAlias;

/**
 * @author: DoubleW2w
 * @description:
 * @date: 2024/3/30 1:52
 * @project: chatbot-api
 */
public class Group {
  @JsonAlias("group_id")
  private String groupId;

  private String name;
  private String type;

  @JsonAlias("background_url")
  private String backgroundUrl;

  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }

  public String getGroupId() {
    return groupId;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }

  public void setBackgroundUrl(String backgroundUrl) {
    this.backgroundUrl = backgroundUrl;
  }

  public String getBackgroundUrl() {
    return backgroundUrl;
  }
}
