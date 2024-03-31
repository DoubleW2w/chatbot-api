package com.doublew2w.chatbot.api.domain.zsxq.model.vo;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author: DoubleW2w
 * @description:
 * @date: 2024/3/30 2:16
 * @project: chatbot-api
 */
@Setter
@Getter
public class Comment {
  @JsonAlias("comment_id")
  private String commentId;

  @JsonAlias("create_time")
  private Date createTime;

  @JsonAlias("owner")
  private Owner owner;

  private String text;

  @JsonAlias("likes_count")
  private int likesCount;

  @JsonAlias("rewards_count")
  private int rewardsCount;

  private boolean sticky;
}
