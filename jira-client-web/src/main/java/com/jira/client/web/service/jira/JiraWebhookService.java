package com.jira.client.web.service.jira;

import com.jira.client.web.model.webhook.JiraWebhookDTO;

/**
 * @author XIAXINYU3
 * @date 2020/12/3
 */
public interface JiraWebhookService {
    /**
     * 添加Jira的故事和缺陷
     *
     * @param issueId        问题id
     * @param projectKey     项目key
     * @param jiraWebhookDTO jira问题webhook请求报文
     */
    void addJiraIssue(Long issueId, String projectKey, JiraWebhookDTO jiraWebhookDTO);
}
