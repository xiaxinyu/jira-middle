package com.jira.client.web.service.steam.impl;

import com.jira.client.web.client.SteamClient;
import com.jira.client.web.model.steam.IamProjectVO;
import com.jira.client.web.model.steam.IamUserVO;
import com.jira.client.web.service.steam.SteamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author XIAXINYU3
 * @date 2020/12/3
 */
@Service
@Slf4j
public class SteamServiceImpl implements SteamService {

    @Autowired
    SteamClient steamClient;

    @Override
    public IamProjectVO getProject(Long projectId) {
        IamProjectVO project = steamClient.getSteamProject(projectId);
        if (Objects.isNull(project)) {
            throw new RuntimeException("找不到项目");
        }
        return project;
    }

    @Override
    public IamUserVO getUser(String loginName) {
        IamUserVO iamUser = steamClient.getUser(loginName);
        if (Objects.isNull(iamUser)) {
            throw new RuntimeException("找不到用户");
        }
        return iamUser;
    }
}
