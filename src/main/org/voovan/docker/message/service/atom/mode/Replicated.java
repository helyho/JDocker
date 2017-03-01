package org.voovan.docker.message.service.atom.mode;

/**
 *
 * @author helyho
 * <p>
 * DockerFly Framework.
 * WebSite: https://git.oschina.net/helyho/JDocker
 * Licence: Apache v2 License
 */
public class Replicated extends Mode{
    private Integer replicas;

    public Replicated() {
        replicas = 1;
    }

    public Replicated(int replicas) {
        this.replicas = replicas;
    }

    public Integer getReplicas() {
        return replicas;
    }

    public void setReplicas(Integer replicas) {
        this.replicas = replicas;
    }
}
