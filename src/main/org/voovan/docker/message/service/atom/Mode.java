package org.voovan.docker.message.service.atom;

/**
 *
 * @author helyho
 * <p>
 * DockerFly Framework.
 * WebSite: https://git.oschina.net/helyho/JDocker
 * Licence: Apache v2 License
 */
public class Mode {
    private Replicated replicated;

    public Mode() {
        replicated = new Replicated();
    }

    public Replicated getReplicated() {
        return replicated;
    }

    public void setReplicated(Replicated replicated) {
        this.replicated = replicated;
    }

}
