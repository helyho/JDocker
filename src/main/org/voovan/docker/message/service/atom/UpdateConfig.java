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
    private Integer parallelism;

    private Long delay;

    private String failureAction; // continue/pause

    public UpdateConfig() {
        parallelism = 2;
        failureAction = "pause";
        delay = 0L;
    }

    public void setParallelism(Integer parallelism) {
        this.parallelism = parallelism;
    }

    public Integer getParallelism() {
        return this.parallelism;
    }

    public void setDelay(Long delay) {
        this.delay = delay;
    }

    public Long getDelay() {
        return this.delay;
    }

    public void setFailureAction(String failureAction) {
        this.failureAction = failureAction;
    }

    public String getFailureAction() {
        return this.failureAction;
    }
}
