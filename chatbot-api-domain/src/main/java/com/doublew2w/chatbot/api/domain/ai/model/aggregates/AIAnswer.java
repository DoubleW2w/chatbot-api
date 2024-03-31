package com.doublew2w.chatbot.api.domain.ai.model.aggregates;

import com.doublew2w.chatbot.api.domain.ai.model.vo.Choices;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author: DoubleW2w
 * @description: AI回答响应类
 * @date: 2024/3/30 20:31
 * @project: chatbot-api
 */
@Setter
@Getter
public class AIAnswer {
  private String id;
  private String object;
  private int created;
  private String model;
  private List<Choices> choices;
}
