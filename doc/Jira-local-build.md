# 获取Docker镜像 
docker pull atlassian/jira-software

# 运行docker
docker run -d -p 7081:8080 --name jira  atlassian/jira-software

#拷贝mysql-
docker cp mysql-connector-java-8.0.19.jar jira:/opt/atlassian/jira/lib/mysql-connector-java-8.0.19.jar
