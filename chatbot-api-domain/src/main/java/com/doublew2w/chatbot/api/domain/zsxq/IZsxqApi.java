package com.doublew2w.chatbot.api.domain.zsxq;

import com.doublew2w.chatbot.api.domain.zsxq.model.aggregates.QueryTopicsAggregates;
import com.doublew2w.chatbot.api.domain.zsxq.model.req.CommentReq;
import com.doublew2w.chatbot.api.domain.zsxq.model.req.TopicsReq;
import com.doublew2w.chatbot.api.domain.zsxq.model.res.CommentRes;
import org.apache.hc.core5.http.ParseException;

import java.io.IOException;

/**
 * @author: DoubleW2w
 * @description: 知识星球 API 接口
 * @date: 2024/3/30 2:29
 * @project: chatbot-api
 */
public interface IZsxqApi {
  /**
   * 查询主题列表
   *
   * @param req 请求体
   * @return 结果
   * @throws IOException 异常
   * @throws ParseException 异常
   */
  QueryTopicsAggregates queryTopicsAggregates(TopicsReq req) throws IOException, ParseException;

  /**
   * 评论主题接口
   *
   * @param req 请求
   * @return true——评论成功
   *     <p>false 评论失败
   * @throws IOException 异常
   * @throws ParseException 异常
   */
  CommentRes commentTopic(CommentReq req) throws IOException, ParseException;
}
