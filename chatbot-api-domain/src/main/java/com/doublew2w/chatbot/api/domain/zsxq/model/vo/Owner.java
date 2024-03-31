package com.doublew2w.chatbot.api.domain.zsxq.model.vo;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: DoubleW2w
 * @description:
 * @date: 2024/3/30 1:52
 * @project: chatbot-api
 */
@Setter
@Getter
public class Owner {
  /** 用户id */
  @JsonAlias({"user_id", "userId"})
  private String userId;

  /** 用户名称 */
  private String name;

  /** 用户头像url */
  @JsonAlias({"avatar_url", "avatarUrl"})
  private String avatarUrl;

  /** 用户地理位置 */
  private String location;
}
