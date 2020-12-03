package com.jira.client.web.config;

import com.jira.client.web.model.properties.AgileProperties;
import com.jira.client.web.model.properties.AutoTestProperties;
import com.jira.client.web.model.properties.IamProperties;
import com.jira.client.web.model.properties.OAuthProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author XIAXINYU3
 * @date 2020/12/3
 */
@Getter
@Setter
@Component
@ToString
@ConfigurationProperties(prefix = "steam")
public class SteamProperties {
    private OAuthProperties oauth;
    private AgileProperties agile;
    private IamProperties iam;
    private AutoTestProperties autoTest;
}
