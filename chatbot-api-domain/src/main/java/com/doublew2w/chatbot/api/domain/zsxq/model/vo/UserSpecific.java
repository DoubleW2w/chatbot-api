package com.doublew2w.chatbot.api.domain.zsxq.model.vo;

/**
 * @author: DoubleW2w
 * @description:
 * @date: 2024/3/30 1:54
 * @project: chatbot-api
 */
public class UserSpecific {
  private boolean liked;
  private boolean subscribed;

  public void setLiked(boolean liked) {
    this.liked = liked;
  }

  public boolean getLiked() {
    return liked;
  }

  public void setSubscribed(boolean subscribed) {
    this.subscribed = subscribed;
  }

  public boolean getSubscribed() {
    return subscribed;
  }
}
