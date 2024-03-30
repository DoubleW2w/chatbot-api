package com.doublew2w.chatbot.api.domain.zsxq.model.vo;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.Date;

/**
 * @author: DoubleW2w
 * @description:
 * @date: 2024/3/30 2:16
 * @project: chatbot-api
 */
public class Comment {
  @JsonAlias("comment_id")
  private String commentId;

  @JsonAlias("create_time")
  private Date createTime;

  @JsonAlias("owner")
  private Owner owner;

  private String text;

  @JsonAlias("likes_count")
  private int likesCount;

  @JsonAlias("rewards_count")
  private int rewardsCount;

  private boolean sticky;

  public void setCommentId(String commentId) {
    this.commentId = commentId;
  }

  public String getCommentId() {
    return commentId;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getCreateTime() {
    return createTime;
  }

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

  public void setLikesCount(int likesCount) {
    this.likesCount = likesCount;
  }

  public int getLikesCount() {
    return likesCount;
  }

  public void setRewardsCount(int rewardsCount) {
    this.rewardsCount = rewardsCount;
  }

  public int getRewardsCount() {
    return rewardsCount;
  }

  public void setSticky(boolean sticky) {
    this.sticky = sticky;
  }

  public boolean getSticky() {
    return sticky;
  }
}
