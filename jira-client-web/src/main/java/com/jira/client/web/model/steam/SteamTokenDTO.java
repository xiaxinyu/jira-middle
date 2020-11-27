package com.jira.client.web.model.steam;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.*;

/**
 * @author XIAXINYU3
 * @date 2020/11/27
 */
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SteamTokenDTO {
    @JSONField(name = "access_token")
    private String accessToken;

    @JSONField(name = "token_type")
    private String tokenType;

    @JSONField(name = "refresh_token")
    private String refreshToken;
}
