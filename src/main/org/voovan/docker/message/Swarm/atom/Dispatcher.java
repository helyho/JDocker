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
public class Dispatcher {
    private long heartbeatPeriod;

    public Dispatcher(){
        heartbeatPeriod = 5000000000L;
    }

    public long getHeartbeatPeriod() {
        return heartbeatPeriod;
    }

    public void setHeartbeatPeriod(long heartbeatPeriod) {
        this.heartbeatPeriod = heartbeatPeriod;
    }
}
