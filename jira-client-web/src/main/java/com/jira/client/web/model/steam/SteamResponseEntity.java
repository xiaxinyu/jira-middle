package com.jira.client.web.model.steam;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author XIAXINYU3
 * @date 2020/12/3
 */
@Setter
@Getter
@ToString
public class SteamResponseEntity<T> {
    public static Integer SUCCESS = 20000;

    private T data;

    private Integer code;

    private String message;
}
