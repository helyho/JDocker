package org.voovan.docker.message.service.atom;

/**
 *
 * @author helyho
 * <p>
 * DockerFly Framework.
 * WebSite: https://git.oschina.net/helyho/JDocker
 * Licence: Apache v2 License
 */
public class UpdateConfig {
    private int parallelism;

    private long delay;

    private String failureAction; // continue/pause

    public UpdateConfig() {
        parallelism = 2;
        failureAction = "pause";
        delay = 0;
    }

    public void setParallelism(int parallelism) {
        this.parallelism = parallelism;
    }

    public int getParallelism() {
        return this.parallelism;
    }

    public void setDelay(long delay) {
        this.delay = delay;
    }

    public long getDelay() {
        return this.delay;
    }

    public void setFailureAction(String failureAction) {
        this.failureAction = failureAction;
    }

    public String getFailureAction() {
        return this.failureAction;
    }
}
