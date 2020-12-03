package com.jira.client.web.client;

import com.jira.client.web.Application;
import com.jira.client.web.model.steam.IamProjectVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author XIAXINYU3
 * @date 2020/11/27
 */
@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@ActiveProfiles("dev")
@Slf4j
public class SteamClientTest {

    @Autowired
    SteamClient steamClient;

    @Test
    public void test_getSteamToken() throws Exception {
        String token = steamClient.getSteamToken();
        Assert.assertNotNull(token);
        System.out.println(token);
    }

    @Test
    public void test_getSteamProject() throws Exception {
        Long projectId = 1576L;
        IamProjectVO project = steamClient.getSteamProject(projectId);
        Assert.assertNotNull(project);
        System.out.println(project);
    }
}
