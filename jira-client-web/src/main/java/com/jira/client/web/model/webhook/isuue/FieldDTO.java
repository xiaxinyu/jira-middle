package com.jira.client.web.model.webhook.isuue;

import com.jira.client.web.model.webhook.meta.CreatorDTO;
import com.jira.client.web.model.webhook.meta.PriorityDTO;
import com.jira.client.web.model.webhook.meta.StatusDTO;
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
public class FieldDTO {
    private String summary;
    private CreatorDTO creator;
    private String created;
    private PriorityDTO priority;
    private StatusDTO status;
}
