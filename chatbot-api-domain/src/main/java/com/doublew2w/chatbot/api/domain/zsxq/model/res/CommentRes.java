package com.doublew2w.chatbot.api.domain.zsxq.model.res;

import com.fasterxml.jackson.annotation.JsonAlias;

/**
 * @author: DoubleW2w
 * @description: 评论请求响应体
 * @date: 2024/3/30 2:11
 * @project: chatbot-api
 */
public class CommentRes {
  @JsonAlias("succeeded")
  private boolean succeeded;

  @JsonAlias("resp_data")
  private CommentResData commentResData;

  public boolean isSucceeded() {
    return succeeded;
  }

  public void setSucceeded(boolean succeeded) {
    this.succeeded = succeeded;
  }

  public CommentResData getCommentResData() {
    return commentResData;
  }

  public void setCommentResData(CommentResData commentResData) {
    this.commentResData = commentResData;
  }
}
