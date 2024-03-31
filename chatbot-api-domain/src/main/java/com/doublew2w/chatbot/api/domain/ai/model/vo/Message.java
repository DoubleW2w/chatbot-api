package com.doublew2w.chatbot.api.domain.ai.model.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: DoubleW2w
 * @description:
 * @date: 2024/3/30 20:42
 * @project: chatbot-api
 */
@Setter
@Getter
public class Message {
  private String role;
  private String content;
}
