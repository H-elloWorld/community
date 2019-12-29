package com.pi.community.provider;

import com.alibaba.fastjson.JSON;
import com.pi.community.dto.AccessTokenDTO;
import com.pi.community.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;


/**
 * @author Mendax
 * @date 2019/12/29
 **/
@Component
public class GithubProvider {

    public String getAccessToken(AccessTokenDTO accessTokenDTO) {
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON.toJSONString(accessTokenDTO),mediaType);
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token?"
                        +"client_id="+accessTokenDTO.getClientId()
                        +"&client_secret="+accessTokenDTO.getClientSecret()
                        +"&code="+accessTokenDTO.getCode()
                        +"&redirect_uri="+accessTokenDTO.getRedirectUri()
                        +"&state="+accessTokenDTO.getState())
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            String token = string.split("&")[0];
            String accessToken = token.split("=")[1];
            return accessToken;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public GithubUser getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
              .url("https://api.github.com/user?access_token=" + accessToken)
              .build();
        try {
            Response response = client.newCall(request).execute();
            String str = response.body().string();
            GithubUser githubUser = JSON.parseObject(str, GithubUser.class);
            return githubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }
}
