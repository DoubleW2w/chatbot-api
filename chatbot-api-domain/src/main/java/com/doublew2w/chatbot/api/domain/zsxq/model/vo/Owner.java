package com.doublew2w.chatbot.api.domain.zsxq.model.vo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author: DoubleW2w
 * @description:
 * @date: 2024/3/30 1:52
 * @project: chatbot-api
 */
public class Owner {
  @JsonAlias({"user_id", "userId"})
  private String userId;

  private String name;

  @JsonAlias({"avatar_url", "avatarUrl"})
  private String avatarUrl;

  private String location;

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getUserId() {
    return userId;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setAvatarUrl(String avatarUrl) {
    this.avatarUrl = avatarUrl;
  }

  public String getAvatarUrl() {
    return avatarUrl;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getLocation() {
    return location;
  }
}
