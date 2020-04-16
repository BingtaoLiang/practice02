package com.practice.provider;


import com.alibaba.fastjson.JSON;
import com.practice.dto.AccessTokenDTO;
import com.practice.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GithubProvider {
    public String getAccessToken(AccessTokenDTO accessTokenDTO){
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType,JSON.toJSONString(accessTokenDTO) );
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            String token = string.split("&")[0].split("=")[1];  //将返回的access_token——"access_token=0dd7dec55240910fc991830827ac6bab3e7ca410&scope=user&token_type=bearer"
            return token;                                                     // 先按"&"分割,再按"="分割，得到access_token字符串
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public GithubUser getUser(String accessToken){      //使用accessToken去访问github的"user"API
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token="+accessToken)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);     //把String的JSON对象转换为Java的类对象
            return githubUser;
        } catch (IOException e) {
        }
        return null;
    }
}
