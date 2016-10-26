package org.voovan.docker.message.exec;

/**
 * 类文字命名
 *
 * @author helyho
 *         <p>
 *         DockerFly Framework.
 *         WebSite: https://github.com/helyho/DockerFly
 *         Licence: Apache v2 License
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
