package com.jira.client.web.service.jira.impl;

import com.jira.client.web.client.SteamClient;
import com.jira.client.web.common.enums.IssueEventType;
import com.jira.client.web.model.steam.IamProjectVO;
import com.jira.client.web.model.steam.IamUserVO;
import com.jira.client.web.model.webhook.JiraWebhookDTO;
import com.jira.client.web.model.webhook.meta.CreatorDTO;
import com.jira.client.web.service.jira.JiraWebhookService;
import com.jira.client.web.service.steam.SteamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author XIAXINYU3
 * @date 2020/12/3
 */
@Service
@Slf4j
public class JiraWebhookServiceImpl implements JiraWebhookService {
    @Autowired
    SteamService steamService;

    @Override
    public void addJiraIssue(Long issueId, String projectKey, JiraWebhookDTO jiraWebhookDTO) {
        log.info("接受到Jira的Webhook请求报文：issueId={}, projectKey={}, {}", issueId, projectKey, jiraWebhookDTO);

        String issueEventTypeName = jiraWebhookDTO.getIssue_event_type_name();
        IssueEventType issueEventType = IssueEventType.of(issueEventTypeName);
        if (IssueEventType.ISSUE_CREATED != issueEventType) {
            log.warn("暂时不处理不是[{}]类型的事件: issueEventTypeName={}", IssueEventType.ISSUE_CREATED.getCode(), issueEventTypeName);
            return;
        }

        IamProjectVO project = steamService.checkProject(projectKey);

        CreatorDTO creatorDTO = jiraWebhookDTO.getIssue().getFields().getCreator();
        IamUserVO user = steamService.getUser(creatorDTO.getName());
    }
}
