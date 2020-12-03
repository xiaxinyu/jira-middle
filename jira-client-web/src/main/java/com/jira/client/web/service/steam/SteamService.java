package com.jira.client.web.service.steam;

import com.jira.client.web.model.steam.IamProjectVO;
import com.jira.client.web.model.steam.IamUserVO;

/**
 * @author XIAXINYU3
 * @date 2020/12/3
 */
public interface SteamService {

    /**
     * 获取项目
     *
     * @param projectKey jira项目key
     * @return 项目信息
     */
    IamProjectVO checkProject(String projectKey);

    /**
     * 获取用户
     *
     * @param loginName 登录名
     * @return 用户信息
     */
    IamUserVO getUser(String loginName);
}
