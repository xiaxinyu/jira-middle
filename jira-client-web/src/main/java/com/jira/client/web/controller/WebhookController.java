package com.jira.client.web.controller;

import com.jira.client.web.model.webhook.IssueReq;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author XIAXINYU3
 * @date 2020/11/27
 */
@RestController
public class WebhookController {

    /*@PostMapping("/jira/webhooks/issue")
    public ResponseEntity projectRoles(@RequestParam(name = "issueId") Long issueId,
                                       @RequestParam(name = "issueKey") String issueKey,
                                       HttpServletRequest request) throws IOException {
        System.out.println("===============================");

        BufferedReader reader = null;
        try {
            reader = request.getReader();
            StringBuffer result = new StringBuffer();
            String line = "";
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            System.out.println(result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            reader.close();
        }
        return ResponseEntity.ok("success");
    }*/


    @PostMapping("/jira/webhooks/issue")
    public ResponseEntity projectRoles(@RequestParam(name = "issueId") Long issueId,
                                       @RequestParam(name = "projectId") Long projectId,
                                       @RequestBody IssueReq issue,
                                       HttpServletRequest request) {
        System.out.println("===============================");
        System.out.println(issue);
        System.out.println("===============================");
        return ResponseEntity.ok("success");
    }
}
