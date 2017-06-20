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

    private Long monitor;

    private Float maxFailureRatio;

    public UpdateConfig() {
        parallelism = 1;
        delay = null;
        failureAction = "pause";

        //v1.25
        monitor = null;

        //v1.25
        maxFailureRatio = 0F;
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

    //v1.25
    public Long getMonitor() {
        return monitor;
    }

    //v1.25
    public void setMonitor(Long monitor) {
        this.monitor = monitor;
    }

    //v1.25
    public Float getMaxFailureRatio() {
        return maxFailureRatio;
    }

    //v1.25
    public void setMaxFailureRatio(Float maxFailureRatio) {
        this.maxFailureRatio = maxFailureRatio;
    }
}
