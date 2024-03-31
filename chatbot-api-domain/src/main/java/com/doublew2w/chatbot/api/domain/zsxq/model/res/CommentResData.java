package com.doublew2w.chatbot.api.domain.zsxq.model.res;

import com.doublew2w.chatbot.api.domain.zsxq.model.vo.Comment;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: DoubleW2w
 * @description: 评论响应类信息
 * @date: 2024/3/30 2:14
 * @project: chatbot-api
 */
@Setter
@Getter
public class CommentResData {
  private Comment comment;
}
