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
public class PriorityDTO {
    private String name;
    private Long id;
}
