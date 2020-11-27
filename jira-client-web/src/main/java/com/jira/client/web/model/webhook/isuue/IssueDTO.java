package com.jira.client.web.model.webhook.isuue;

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
public class IssueDTO {
    private Long id;
    private FieldDTO fields;
}
