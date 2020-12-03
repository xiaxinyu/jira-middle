package com.jira.client.web.common.enums;

import lombok.Getter;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * @author XIAXINYU3
 * @date 2020/12/3
 */
@Getter
public enum IssueEventType {
    ISSUE_CREATED("issue_created");

    IssueEventType(String code) {
        this.code = code;
    }

    private String code;

    public static IssueEventType of(String code) {
        if (StringUtils.isEmpty(code)) {
            return null;
        }
        for (IssueEventType type : IssueEventType.values()) {
            if (Objects.equals(type.code, code)) {
                return type;
            }
        }
        throw new RuntimeException(String.format("不能识别JIRA事件类型：%s", code));
    }
}
