package com.doublew2w.chatbot.api.domain.zsxq.model.vo;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.Date;
import java.util.List;

/**
 * @author: DoubleW2w
 * @description:
 * @date: 2024/3/30 1:53
 * @project: chatbot-api
 */
public class Topics {
  @JsonAlias("topic_id")
  private String topicId;

  private Group group;
  private String type;
  private Talk talk;

  @JsonAlias("likes_count")
  private int likesCount;

  @JsonAlias("rewards_count")
  private int rewardsCount;

  @JsonAlias("comments_count")
  private int commentsCount;

  @JsonAlias("reading_count")
  private int readingCount;

  @JsonAlias("readers_count")
  private int readersCount;

  private boolean digested;
  private boolean sticky;

  @JsonAlias("create_time")
  private Date createTime;

  @JsonAlias("user_specific")
  private UserSpecific userSpecific;

  public void setTopicId(String topicId) {
    this.topicId = topicId;
  }

  public String getTopicId() {
    return topicId;
  }

  public void setGroup(Group group) {
    this.group = group;
  }

  public Group getGroup() {
    return group;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }

  public void setTalk(Talk talk) {
    this.talk = talk;
  }

  public Talk getTalk() {
    return talk;
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

  public void setCommentsCount(int commentsCount) {
    this.commentsCount = commentsCount;
  }

  public int getCommentsCount() {
    return commentsCount;
  }

  public void setReadingCount(int readingCount) {
    this.readingCount = readingCount;
  }

  public int getReadingCount() {
    return readingCount;
  }

  public void setReadersCount(int readersCount) {
    this.readersCount = readersCount;
  }

  public int getReadersCount() {
    return readersCount;
  }

  public void setDigested(boolean digested) {
    this.digested = digested;
  }

  public boolean getDigested() {
    return digested;
  }

  public void setSticky(boolean sticky) {
    this.sticky = sticky;
  }

  public boolean getSticky() {
    return sticky;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setUserSpecific(UserSpecific userSpecific) {
    this.userSpecific = userSpecific;
  }

  public UserSpecific getUserSpecific() {
    return userSpecific;
  }
}
