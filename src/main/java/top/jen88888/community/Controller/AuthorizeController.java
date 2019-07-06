package top.jen88888.community.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.jen88888.community.dto.AccessTokenDTO;
import top.jen88888.community.provider.GithubProvider;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("4d0ed0b849ecfb6c3a64");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://127.0.0.1:8080/callback");
        accessTokenDTO.setState(state);
        accessTokenDTO.setClient_secret("cd1173db98f224beb42d9f38fe5aa3e1dae32a49");
        githubProvider.getAccessToken(accessTokenDTO);
        return "index";
    }
}
