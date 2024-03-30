package com.doublew2w.chatbot.api.domain.zsxq.model.req;

import com.fasterxml.jackson.annotation.*;

/**
 * @author: DoubleW2w
 * @description: 评论请求类
 * @date: 2024/3/30 2:10
 * @project: chatbot-api
 */
public class CommentReq {
  @JsonIgnore private String cookie;
  @JsonIgnore private String topicId;

  @JsonAlias("req_data")
  @JsonProperty("req_data")
  private CommentReqData commentReqData;

  public String getCookie() {
    return cookie;
  }

  public void setCookie(String cookie) {
    this.cookie = cookie;
  }

  public String getTopicId() {
    return topicId;
  }

  public void setTopicId(String topicId) {
    this.topicId = topicId;
  }

  public void setCommentReqData(CommentReqData commentReqData) {
    this.commentReqData = commentReqData;
  }

  public CommentReqData getCommentReqData() {
    return commentReqData;
  }
}
