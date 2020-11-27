package com.jira.client.web.model.webhook.meta;

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
public class CreatorDTO {
    private String name;
    private String key;
    private String displayName;
    private Boolean active;
}
