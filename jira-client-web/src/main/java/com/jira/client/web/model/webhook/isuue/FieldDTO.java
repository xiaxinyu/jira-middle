package com.jira.client.web.model.webhook.isuue;

import com.jira.client.web.model.webhook.meta.CreatorDTO;
import com.jira.client.web.model.webhook.meta.PriorityDTO;
import com.jira.client.web.model.webhook.meta.StatusDTO;
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
public class FieldDTO {
    @ApiModelProperty("标题")
    private String summary;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("创建人")
    private CreatorDTO creator;

    @ApiModelProperty("创建时间")
    private String created;

    @ApiModelProperty("优先级")
    private PriorityDTO priority;

    @ApiModelProperty("状态")
    private StatusDTO status;
}
