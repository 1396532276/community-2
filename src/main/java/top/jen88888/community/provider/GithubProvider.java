package top.jen88888.community.provider;

import com.alibaba.fastjson.JSON;
import okhttp3.*;
import org.springframework.stereotype.Component;
import top.jen88888.community.dto.AccessTokenDTO;
import top.jen88888.community.dto.GithubUser;

import java.io.IOException;

@Component
public class GithubProvider {
    public String Git_POST_url = "https://github.com/login/oauth/access_token";

    public String getAccessToken(AccessTokenDTO accessTokenDTO) {
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                .url(Git_POST_url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            System.out.println(string);
            return string;
        } catch (IOException e) {
        }
        return null;
    }

    public GithubUser getUser(String accessTokn) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token=" + accessTokn)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();

        } catch (IOException e) {
        }
    }
}


}
