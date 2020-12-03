package com.jira.client.web.model.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author XIAXINYU3
 * @date 2020/12/3
 */
@Setter
@Getter
@ToString
public class OAuthProperties {
    private String url;
    private String clientId;
    private String clientSecret;
    private String userName;
    private String password;
}
