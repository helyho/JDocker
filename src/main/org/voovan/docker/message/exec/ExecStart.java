package org.voovan.docker.message.exec;

/**
 *
 * @author helyho
 * <p>
 * DockerFly Framework.
 * WebSite: https://git.oschina.net/helyho/JDocker
 * Licence: Apache v2 License
 */
public class ExecStart {

    private boolean detach;
    private boolean tty;

    public ExecStart() {
        detach = false;
        tty = false;
    }

    public boolean isDetach() {
        return detach;
    }

    public void setDetach(boolean detach) {
        this.detach = detach;
    }

    public boolean isTty() {
        return tty;
    }

    public void setTty(boolean tty) {
        this.tty = tty;
    }
}
