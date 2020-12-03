package com.jira.client.web.common.enums;

import lombok.Getter;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * @author XIAXINYU3
 * @date 2020/12/3
 */
@Getter
public enum IssueType {
    DEFECT("defect", "故障"),
    STORY("story", "故事");

    IssueType(String code, String name) {
        this.code = code;
        this.name = name;
    }

    private String code;
    private String name;

    public static IssueType of4Name(String name) {
        if (StringUtils.isEmpty(name)) {
            return null;
        }
        for (IssueType type : IssueType.values()) {
            if (Objects.equals(type.name, name)) {
                return type;
            }
        }
        throw new RuntimeException(String.format("不能识别JIRA问题类型：%s", name));
    }
}
