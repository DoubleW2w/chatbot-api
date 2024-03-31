package com.doublew2w.chatbot.api.domain.zsxq.model.req;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author: DoubleW2w
 * @description: 评论请求类信息
 * @date: 2024/3/30 2:02
 * @project: chatbot-api
 */
@Setter
@Getter
public class CommentReqData {
  private String text;

  @JsonAlias("image_ids")
  private List<String> imageIds;

  @JsonAlias("mentioned_user_ids")
  private List<String> mentionedUserIds;
}
