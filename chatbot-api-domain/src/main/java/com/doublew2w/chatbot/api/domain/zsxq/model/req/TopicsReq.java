package com.doublew2w.chatbot.api.domain.zsxq.model.req;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: DoubleW2w
 * @description: 查询主题请求类
 * @date: 2024/3/30 2:20
 * @project: chatbot-api
 */
@Setter
@Getter
public class TopicsReq {
  private String groupId;
  private String cookie;
  private String scope;
  private Integer count;
}
