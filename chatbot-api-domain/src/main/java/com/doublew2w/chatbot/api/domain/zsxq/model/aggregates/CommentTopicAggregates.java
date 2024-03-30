package com.doublew2w.chatbot.api.domain.zsxq.model.aggregates;

import com.doublew2w.chatbot.api.domain.zsxq.model.res.CommentResData;
import com.fasterxml.jackson.annotation.JsonAlias;

/**
 * @author: DoubleW2w
 * @description: 评论主题响应聚合信息
 * @date: 2024/3/30 2:33
 * @project: chatbot-api
 */
public class CommentTopicAggregates {
  @JsonAlias("succeeded")
  private boolean succeeded;
  @JsonAlias("resp_data")
  private CommentResData commentResData;

  public void setSucceeded(boolean succeeded) {
    this.succeeded = succeeded;
  }

  public boolean getSucceeded() {
    return succeeded;
  }

  public void setRespData(CommentResData commentResData) {
    this.commentResData = commentResData;
  }

  public CommentResData getRespData() {
    return commentResData;
  }
}
