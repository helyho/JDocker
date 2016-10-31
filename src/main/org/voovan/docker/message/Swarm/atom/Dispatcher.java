package org.voovan.docker.message.Swarm.atom;

/**
 *
 * @author helyho
 * <p>
 * DockerFly Framework.
 * WebSite: https://git.oschina.net/helyho/JDocker
 * Licence: Apache v2 License
 */
public class Dispatcher {
    private Long heartbeatPeriod;

    public Dispatcher() {
        heartbeatPeriod = 5000000000L;
    }

    public Long getHeartbeatPeriod() {
        return heartbeatPeriod;
    }

    public void setHeartbeatPeriod(Long heartbeatPeriod) {
        this.heartbeatPeriod = heartbeatPeriod;
    }
}
