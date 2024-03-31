package com.doublew2w.chatbot.api.domain.zsxq.model.res;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: DoubleW2w
 * @description: 评论请求响应体
 * @date: 2024/3/30 2:11
 * @project: chatbot-api
 */
@Setter
@Getter
public class CommentRes {
  @JsonAlias("succeeded")
  private boolean succeeded;

  @JsonAlias("resp_data")
  private CommentResData commentResData;
}
