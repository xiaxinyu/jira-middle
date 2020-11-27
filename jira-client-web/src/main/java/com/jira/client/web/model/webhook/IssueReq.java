package com.jira.client.web.model.webhook;

import com.jira.client.web.model.webhook.isuue.IssueDTO;
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
public class IssueReq {
    IssueDTO issue;
}
