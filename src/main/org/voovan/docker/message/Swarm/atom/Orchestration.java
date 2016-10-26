package org.voovan.docker.message.Swarm.atom;

/**
 * 类文字命名
 *
 * @author helyho
 *         <p>
 *         DockerFly Framework.
 *         WebSite: https://github.com/helyho/DockerFly
 *         Licence: Apache v2 License
 */
public class Orchestration {
    private int taskHistoryRetentionLimit;

    public Orchestration(){
        taskHistoryRetentionLimit = 5;
    }

    public int getTaskHistoryRetentionLimit() {
        return taskHistoryRetentionLimit;
    }

    public void setTaskHistoryRetentionLimit(int taskHistoryRetentionLimit) {
        this.taskHistoryRetentionLimit = taskHistoryRetentionLimit;
    }
}
