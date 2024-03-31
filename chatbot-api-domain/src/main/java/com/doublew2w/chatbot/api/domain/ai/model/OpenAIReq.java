package com.doublew2w.chatbot.api.domain.ai.model;

import com.doublew2w.chatbot.api.domain.ai.model.vo.Message;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author: DoubleW2w
 * @description:
 * @date: 2024/3/30 21:12
 * @project: chatbot-api
 */
@Setter
@Getter
public class OpenAIReq {

  private Long maxTokens;
  private List<Message> messages;
  private String model;
  private Long temperature;
}
