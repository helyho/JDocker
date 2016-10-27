package org.voovan.docker.message.Swarm.atom;

/**
 *
 * @author helyho
 * <p>
 * DockerFly Framework.
 * WebSite: https://git.oschina.net/helyho/JDocker
 * Licence: Apache v2 License
 */
public class Orchestration {
    private int taskHistoryRetentionLimit;

    public Orchestration() {
        taskHistoryRetentionLimit = 5;
    }

    public int getTaskHistoryRetentionLimit() {
        return taskHistoryRetentionLimit;
    }

    public void setTaskHistoryRetentionLimit(int taskHistoryRetentionLimit) {
        this.taskHistoryRetentionLimit = taskHistoryRetentionLimit;
    }
}
