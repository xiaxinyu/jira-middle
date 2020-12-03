package com.jira.client.web.client;

import com.jira.client.web.config.SteamProperties;
import com.jira.client.web.model.properties.OAuthProperties;
import com.jira.client.web.model.steam.IamProjectVO;
import com.jira.client.web.model.steam.IamUserVO;
import com.jira.client.web.model.steam.SteamTokenDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

/**
 * @author XIAXINYU3
 * @date 2020/11/27
 */
@Component
public class SteamClient {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    SteamProperties steamProperties;

    public String getSteamToken() {
        OAuthProperties oauth = steamProperties.getOauth();

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("client_id", oauth.getClientId());
        params.add("client_secret", oauth.getClientSecret());
        params.add("grant_type", "password");
        params.add("username", oauth.getUserName());
        params.add("password", oauth.getPassword());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);
        String url = oauth.getUrl();

        ResponseEntity<SteamTokenDTO> response = restTemplate.postForEntity(url, request, SteamTokenDTO.class);
        if (Objects.nonNull(response) && response.getStatusCode().is2xxSuccessful()) {
            return response.getBody().getAccessToken();
        }
        return null;
    }

    public IamProjectVO getSteamProject() {
        return IamProjectVO.builder().build();
    }

    public IamUserVO getUser(String loginName) {
        return IamUserVO.builder().build();
    }

    public IamUserVO createStory() {
        return null;
    }

    public IamUserVO createDefect() {
        return null;
    }
}
