package com.jira.client.web.controller;

import com.jira.client.web.model.webhook.JiraWebhookDTO;
import com.jira.client.web.service.jira.JiraWebhookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author XIAXINYU3
 * @date 2020/11/27
 */
@RestController
@Api("JIRA中webhook事件接受Controller")
public class JiraWebhookController {
    @Autowired
    JiraWebhookService jiraWebhookService;

    public void parse(HttpServletRequest request) {
        BufferedReader reader = null;
        try {
            reader = request.getReader();
            StringBuffer result = new StringBuffer();
            String line = "";
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            System.out.println("原始报文： " + result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @ApiOperation(value = "故事、缺陷新增接口", response = ResponseEntity.class)
    @PostMapping("/jira/webhooks/issue")
    public ResponseEntity addIssues(
            @ApiParam(name = "问题id", value = "1", required = true)
            @RequestParam(name = "issueId") Long issueId,
            @ApiParam(name = "项目key", value = "1", required = true)
            @RequestParam(name = "projectKey") String projectKey,
            @ApiParam(name = "Jira问题webhook请求报文", required = true)
            @RequestBody @Valid JiraWebhookDTO jiraWebhookDTO) {
        jiraWebhookService.addJiraIssue(issueId, projectKey, jiraWebhookDTO);
        return ResponseEntity.ok("success");
    }
}
