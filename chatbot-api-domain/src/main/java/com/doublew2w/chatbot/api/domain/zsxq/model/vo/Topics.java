package com.doublew2w.chatbot.api.domain.zsxq.model.vo;

import com.fasterxml.jackson.annotation.JsonAlias;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: DoubleW2w
 * @description: 主题数据
 * @date: 2024/3/30 1:53
 * @project: chatbot-api
 */
@Setter
@Getter
public class Topics {
  /**
   * 评论id
   */
  @JsonAlias("topic_id")
  private String topicId;

  private Group group;
  private String type;
  private Talk talk;

  @JsonAlias("likes_count")
  private int likesCount;

  @JsonAlias("rewards_count")
  private int rewardsCount;

  @JsonAlias("comments_count")
  private int commentsCount;

  @JsonAlias("reading_count")
  private int readingCount;

  @JsonAlias("readers_count")
  private int readersCount;

  private boolean digested;
  private boolean sticky;

  @JsonAlias("create_time")
  private Date createTime;

  @JsonAlias("user_specific")
  private UserSpecific userSpecific;

}
