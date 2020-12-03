package com.jira.client.web.model.webhook;

import com.alibaba.fastjson.annotation.JSONField;
import com.jira.client.web.model.webhook.isuue.IssueDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("问题Webhook报文")
public class JiraWebhookDTO {
    @ApiModelProperty("创建时间")
    private Long timestamp;

    @ApiModelProperty("问题类型")
    @JSONField(name = "issue_event_type_name")
    private String issue_event_type_name;

    @ApiModelProperty("问题主题")
    private IssueDTO issue;
}
