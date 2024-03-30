package com.doublew2w.chatbot.api.domain.zsxq.model.res;

import com.doublew2w.chatbot.api.domain.zsxq.model.vo.Topics;
import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

/**
 * @author: DoubleW2w
 * @description: 查询主题响应体信息
 * @date: 2024/3/30 2:24
 * @project: chatbot-api
 */
public class TopicsResData {
  @JsonAlias("topics")
  private List<Topics> topics;

  public void setTopics(List<Topics> topics) {
    this.topics = topics;
  }

  public List<Topics> getTopics() {
    return topics;
  }
}
