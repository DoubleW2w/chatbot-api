package com.doublew2w.chatbot.api.domain.zsxq.model.req;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: DoubleW2w
 * @description: 评论请求类
 * @date: 2024/3/30 2:10
 * @project: chatbot-api
 */
@Setter
@Getter
public class CommentReq {
  @JsonIgnore private String cookie;
  @JsonIgnore private String topicId;

  @JsonAlias("req_data")
  @JsonProperty("req_data")
  private CommentReqData commentReqData;
}
