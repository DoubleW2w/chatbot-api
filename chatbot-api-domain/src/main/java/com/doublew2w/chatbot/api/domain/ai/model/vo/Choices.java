package com.doublew2w.chatbot.api.domain.ai.model.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: DoubleW2w
 * @description:
 * @date: 2024/3/30 20:22
 * @project: chatbot-api
 */
@Setter
@Getter
public class Choices {
  private int index;
  private Message message;
  private String logprobs;
  private String finish_reason;
}
