package com.doublew2w.chatbot.api.domain.zsxq.model.vo;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: DoubleW2w
 * @description: 知识星球所属信息
 * @date: 2024/3/30 1:52
 * @project: chatbot-api
 */
@Setter
@Getter
public class Group {
  @JsonAlias("group_id")
  private String groupId;

  private String name;
  private String type;

  @JsonAlias("background_url")
  private String backgroundUrl;
}
