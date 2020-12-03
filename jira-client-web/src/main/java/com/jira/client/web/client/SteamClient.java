package com.jira.client.web.client;

import com.alibaba.fastjson.JSONObject;
import com.jira.client.web.config.SteamProperties;
import com.jira.client.web.model.properties.IamProperties;
import com.jira.client.web.model.properties.OAuthProperties;
import com.jira.client.web.model.steam.IamProjectVO;
import com.jira.client.web.model.steam.IamUserVO;
import com.jira.client.web.model.steam.SteamResponseEntity;
import com.jira.client.web.model.steam.SteamTokenDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
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
@Slf4j
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
        log.info("获取token：url={}", url);

        ResponseEntity<SteamTokenDTO> response = restTemplate.postForEntity(url, request, SteamTokenDTO.class);
        if (Objects.nonNull(response) && response.getStatusCode().is2xxSuccessful()) {
            return response.getBody().getAccessToken();
        }
        return null;
    }

    public IamProjectVO getSteamProject(Long projectId) {
        IamProperties iam = steamProperties.getIam();

        String url = steamProperties.getHost() + iam.getProjectUri().replaceAll("\\{project_id\\}", String.valueOf(projectId));
        String token = getSteamToken();
        log.info("获取项目信息：url={}", url);

        HttpHeaders headers = new HttpHeaders();
        headers.set("authorization", "bearer " + token);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(null, headers);

        // 使用ParameterizedTypeReference进行包装
        ParameterizedTypeReference<SteamResponseEntity<IamProjectVO>> reference = new ParameterizedTypeReference<SteamResponseEntity<IamProjectVO>>() {
        };
        ResponseEntity<SteamResponseEntity<IamProjectVO>> response = restTemplate.exchange(url, HttpMethod.GET, request, reference);

        if (Objects.nonNull(response)
                && response.getStatusCode().is2xxSuccessful()) {
            SteamResponseEntity<IamProjectVO> steamResponse = response.getBody();
            if (Objects.nonNull(steamResponse)
                    && Objects.equals(SteamResponseEntity.SUCCESS, steamResponse.getCode())) {
                return steamResponse.getData();
            } else {
                throw new RuntimeException(steamResponse.getMessage());
            }
        }
        return null;
    }

    public IamUserVO getUser(String loginName) {
        return IamUserVO.builder().build();
    }

    public Boolean createStory() {
        return null;
    }

    public Boolean createDefect() {
        return null;
    }
}
