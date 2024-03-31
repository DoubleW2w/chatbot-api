package com.doublew2w.chatbot.api.domain.zsxq.model.res;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: DoubleW2w
 * @description: 查询请求响应体
 * @date: 2024/3/30 2:21
 * @project: chatbot-api
 */
@Setter
@Getter
public class TopicsRes {
  private boolean succeeded;
  private TopicsResData topicsResData;
}
