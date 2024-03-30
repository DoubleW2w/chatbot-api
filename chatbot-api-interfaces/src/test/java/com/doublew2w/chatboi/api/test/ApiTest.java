package com.doublew2w.chatboi.api.test;

import java.io.IOException;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.*;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.message.BasicHeader;
import org.junit.jupiter.api.Test;

/**
 * @author: DoubleW2w
 * @description: 知识星球尝试请求
 * @date: 2024/3/30 0:12
 * @project: chatbot-api
 */
public class ApiTest {

  @Test
  public void query_unanswered_questions() throws IOException, ParseException {
    // 请求客户端
    CloseableHttpClient httpClient = HttpClientBuilder.create().build();
    // 请求
    HttpGet get =
        new HttpGet("https://api.zsxq.com/v2/groups/28885518425541/topics?scope=all&count=1");
    // 请求头
    get.addHeader(
        HttpHeaders.COOKIE,
        "zsxq_access_token=CED499E6-8AC6-CB62-4965-1F35BDF95C02_0E12B3D505223D91; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22815515128582112%22%2C%22first_id%22%3A%22188ca6ebcd61f0d-0d11e8d2b3183b-26031d51-2073600-188ca6ebcd71cad%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg4Y2E2ZWJjZDYxZjBkLTBkMTFlOGQyYjMxODNiLTI2MDMxZDUxLTIwNzM2MDAtMTg4Y2E2ZWJjZDcxY2FkIiwiJGlkZW50aXR5X2xvZ2luX2lkIjoiODE1NTE1MTI4NTgyMTEyIn0%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22815515128582112%22%7D%2C%22%24device_id%22%3A%22188ca6ebcd61f0d-0d11e8d2b3183b-26031d51-2073600-188ca6ebcd71cad%22%7D; abtest_env=product; zsxqsessionid=9bfcd3e38bfe05da0aa165b6a75e25e9");
    get.addHeader(
        HttpHeaders.USER_AGENT,
        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36");

    // 响应
    CloseableHttpResponse response = httpClient.execute(get);
    // 响应头
    response.setHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString());
    if (response.getCode() == HttpStatus.SC_OK) {
      String res = EntityUtils.toString(response.getEntity());
      System.out.println(res);
    } else {
      System.out.println(response.getCode());
    }
  }

  @Test
  public void comment() throws IOException, ParseException {
    CloseableHttpClient httpClient = HttpClientBuilder.create().build();

    HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/2855812585421281/comments");
    post.setHeader(
        HttpHeaders.COOKIE,
        "zsxq_access_token=CED499E6-8AC6-CB62-4965-1F35BDF95C02_0E12B3D505223D91; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22815515128582112%22%2C%22first_id%22%3A%22188ca6ebcd61f0d-0d11e8d2b3183b-26031d51-2073600-188ca6ebcd71cad%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg4Y2E2ZWJjZDYxZjBkLTBkMTFlOGQyYjMxODNiLTI2MDMxZDUxLTIwNzM2MDAtMTg4Y2E2ZWJjZDcxY2FkIiwiJGlkZW50aXR5X2xvZ2luX2lkIjoiODE1NTE1MTI4NTgyMTEyIn0%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22815515128582112%22%7D%2C%22%24device_id%22%3A%22188ca6ebcd61f0d-0d11e8d2b3183b-26031d51-2073600-188ca6ebcd71cad%22%7D; zsxqsessionid=47155d21bfe565f78ef23f21dd606879; abtest_env=product");
    HttpEntity entity =
        new StringEntity(
            "{\"req_data\":{\"text\":\"测试评论-等于回答\\n\",\"image_ids\":[],\"mentioned_user_ids\":[]}}",
            ContentType.APPLICATION_JSON);
    post.setEntity(entity);
    CloseableHttpResponse response = httpClient.execute(post);
    response.setHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString());
    if (response.getCode() == HttpStatus.SC_OK) {
      String res = EntityUtils.toString(response.getEntity());
      System.out.println(res);
    } else {
      System.out.println(response.getCode());
    }
  }

  @Test
  public void test_chatGPT() throws IOException, ParseException {
    // 创建客户端
    CloseableHttpClient client = HttpClientBuilder.create().build();
    // 创建post请求
    String url = "https://api.chatanywhere.com.cn/v1/chat/completions";
    HttpPost post = new HttpPost(url);
    // 设置post请求头
    post.setHeaders(
        new BasicHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType()),
        new BasicHeader(
            HttpHeaders.AUTHORIZATION,
            "Bearer {{APIKEY}}"));
    String entityStr =
        "{\n"
            + "     \"model\": \"gpt-3.5-turbo\",\n"
            + "     \"messages\": [{\"role\": \"user\", \"content\": \"请帮我写一个java快速排序\"}],\n"
            + "     \"temperature\": 0.7\n"
            + "   }";
    post.setEntity(new StringEntity(entityStr, ContentType.APPLICATION_JSON, "uft8", false));

    CloseableHttpResponse response = client.execute(post);
    response.setHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString());
    if (response.getCode() == HttpStatus.SC_OK) {
      System.out.println(EntityUtils.toString(response.getEntity()));
    } else {
      System.out.println("请求失败");
    }
  }

  @Test
  public void test_chatGPT_completion() throws IOException, ParseException {
    // 创建客户端
    CloseableHttpClient client = HttpClientBuilder.create().build();
    // 创建post请求
    String url = "https://api.chatanywhere.com.cn/v1/chat/completions";
    HttpPost post = new HttpPost(url);
    // 设置post请求头
    post.setHeaders(
        new BasicHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType()),
        new BasicHeader(
            HttpHeaders.AUTHORIZATION,
            "Bearer {{APIKEY}}"));
    String entityStr =
        "{\n"
            + "  \"model\": \"gpt-3.5-turbo\","
            + "  \"temperature\": \"0.7\","
            + "  \"max_tokens\": \"1024\","
            + "  \"messages\": [\n"
            + "    {\n"
            + "      \"role\": \"user\",\n"
            + "      \"content\": \"帮我写一个java冒泡排序\""
            + "    },"
            + "  ]"
            + "}";
    post.setEntity(new StringEntity(entityStr, ContentType.APPLICATION_JSON, "UTF8", false));

    CloseableHttpResponse response = client.execute(post);
    response.setHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString());
    if (response.getCode() == HttpStatus.SC_OK) {
      System.out.println(EntityUtils.toString(response.getEntity()));
    } else {
      System.out.println("请求失败");
    }
  }
}
