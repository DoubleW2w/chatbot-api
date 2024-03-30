package com.doublew2w.chatbot.api.domain.zsxq.model.req;

/**
 * @author: DoubleW2w
 * @description: 查询主题请求类
 * @date: 2024/3/30 2:20
 * @project: chatbot-api
 */
public class TopicsReq {
  private String groupId;
  private String cookie;
  private String scope;
  private Integer count;

  public String getCookie() {
    return cookie;
  }

  public void setCookie(String cookie) {
    this.cookie = cookie;
  }

  public String getScope() {
    return scope;
  }

  public void setScope(String scope) {
    this.scope = scope;
  }

  public String getGroupId() {
    return groupId;
  }

  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }

  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }
}
