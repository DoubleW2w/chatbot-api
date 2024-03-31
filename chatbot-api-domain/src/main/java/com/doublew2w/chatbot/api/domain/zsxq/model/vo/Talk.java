package com.doublew2w.chatbot.api.domain.zsxq.model.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: DoubleW2w
 * @description:
 * @date: 2024/3/30 1:53
 * @project: chatbot-api
 */
@Setter
@Getter
public class Talk {
  /** 发布评论的用户信息 */
  private Owner owner;

  /** 评论内容 */
  private String text;
}
