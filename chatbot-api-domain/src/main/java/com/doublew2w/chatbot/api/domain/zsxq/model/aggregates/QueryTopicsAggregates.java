package com.doublew2w.chatbot.api.domain.zsxq.model.aggregates;

import com.doublew2w.chatbot.api.domain.zsxq.model.res.TopicsResData;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: DoubleW2w
 * @description: 查询主题响应聚合信息
 * @date: 2024/3/30 2:32
 * @project: chatbot-api
 */
@Setter
@Getter
public class QueryTopicsAggregates {
  @JsonAlias("succeeded")
  private boolean succeeded;

  @JsonAlias("resp_data")
  private TopicsResData topicsResData;
}
