package org.voovan.docker.message.service.atom;

/**
 * 类文字命名
 *
 * @author helyho
 *         <p>
 *         DockerFly Framework.
 *         WebSite: https://github.com/helyho/DockerFly
 *         Licence: Apache v2 License
 */
public class Mode {
    private Replicated replicated;

    public Mode(){
        replicated = new Replicated();
    }

    public Replicated getReplicated() {
        return replicated;
    }

    public void setReplicated(Replicated replicated) {
        this.replicated = replicated;
    }

}
