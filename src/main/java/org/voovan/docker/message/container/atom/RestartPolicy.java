package org.voovan.docker.message.container.atom;

/**
 *
 * @author helyho
 * <p>
 * DockerFly Framework.
 * WebSite: https://git.oschina.net/helyho/JDocker
 * Licence: Apache v2 License
 */
public class RestartPolicy {

    private String name; // "always" "unless-stopped" "on-failure"

    private Integer maximumRetryCount;

    public RestartPolicy() {
        name = "on-failure";
        maximumRetryCount = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMaximumRetryCount() {
        return maximumRetryCount;
    }

    public void setMaximumRetryCount(Integer maximumRetryCount) {
        this.maximumRetryCount = maximumRetryCount;
    }
}
