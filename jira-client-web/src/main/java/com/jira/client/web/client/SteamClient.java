package com.jira.client.web.client;

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

import java.util.Map;
import java.util.Objects;

/**
 * @author XIAXINYU3
 * @date 2020/11/27
 */
@Component
public class SteamClient {
    @Autowired
    RestTemplate restTemplate;

    public String getSteamToken() {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("client_id", "devops");
        params.add("client_secret", "choerodon");
        params.add("grant_type", "password");
        params.add("username", "admin");
        params.add("password", "NGpaQCNlSF5DRzJuc0pCQQ==");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);
        String url = "http://xxxxxx/oauth/oauth/token";

        ResponseEntity<SteamTokenDTO> response = restTemplate.postForEntity(url, request, SteamTokenDTO.class);
        if (Objects.nonNull(response) && response.getStatusCode().is2xxSuccessful()) {
            return response.getBody().getAccessToken();
        }
        return null;
    }

    public void set() {
        /*RestTemplate restTemplate = new RestTemplate();
        String url = "http://47.xxx.xxx.96/register/checkEmail";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("email", "844072586@qq.com");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        System.out.println(response.getBody());*/
    }
}
