package com.doublew2w.chatbot.api.domain.zsxq.model.res;

/**
 * @author: DoubleW2w
 * @description: 查询请求响应体
 * @date: 2024/3/30 2:21
 * @project: chatbot-api
 */
public class TopicsRes {
  private boolean succeeded;
  private TopicsResData topicsResData;

  public void setSucceeded(boolean succeeded) {
    this.succeeded = succeeded;
  }

  public boolean getSucceeded() {
    return succeeded;
  }

  public void setTopicsResData(TopicsResData topicsResData) {
    this.topicsResData = topicsResData;
  }

  public TopicsResData getTopicsResData() {
    return topicsResData;
  }
}
