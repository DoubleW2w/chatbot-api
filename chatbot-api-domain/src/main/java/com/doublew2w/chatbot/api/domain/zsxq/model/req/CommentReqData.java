package com.doublew2w.chatbot.api.domain.zsxq.model.req;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

/**
 * @author: DoubleW2w
 * @description: 评论请求类信息
 * @date: 2024/3/30 2:02
 * @project: chatbot-api
 */
public class CommentReqData {
  private String text;
  @JsonAlias("image_ids")
  private List<String> imageIds;
  @JsonAlias("mentioned_user_ids")
  private List<String> mentionedUserIds;

  public void setText(String text) {
    this.text = text;
  }

  public String getText() {
    return this.text;
  }

  public void setImageIds(List<String> imageIds) {
    this.imageIds = imageIds;
  }

  public List<String> getImageIds() {
    return this.imageIds;
  }

  public void setMentionedUserIds(List<String> mentionedUserIds) {
    this.mentionedUserIds = mentionedUserIds;
  }

  public List<String> getMentionedUserIds() {
    return this.mentionedUserIds;
  }
}
