package org.voovan.docker.message.service.atom;

/**
 *
 * @author helyho
 * <p>
 * DockerFly Framework.
 * WebSite: https://git.oschina.net/helyho/JDocker
 * Licence: Apache v2 License
 */
public class RestartPolicy {

    private String condition; // none/on-failure/any

    private Long delay;

    private Integer maxAttempts;

    public RestartPolicy() {
        condition = "on-failure";
        maxAttempts = 0;
        delay = 0L; //10s
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getCondition() {
        return this.condition;
    }

    public void setDelay(Long delay) {
        this.delay = delay * 1000000000L;
    }

    public Long getDelay() {
        return this.delay / 1000000000L;
    }

    public void setMaxAttempts(Integer maxAttempts) {
        this.maxAttempts = maxAttempts;
    }

    public Integer getMaxAttempts() {
        return this.maxAttempts;
    }
}
