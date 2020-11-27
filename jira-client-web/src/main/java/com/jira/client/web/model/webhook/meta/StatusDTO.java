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
public class StatusDTO {
    private Long id;
    private String name;
    private StatusCategoryDTO statusCategory;

    @Getter
    @Setter
    @ToString
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class StatusCategoryDTO {
        private Long id;
        private String key;
        private String name;
    }
}
