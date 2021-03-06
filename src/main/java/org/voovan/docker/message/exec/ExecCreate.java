package org.voovan.docker.message.exec;

import org.voovan.tools.TObject;
import org.voovan.tools.json.JSON;
import org.voovan.tools.log.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author helyho
 * <p>
 * DockerFly Framework.
 * WebSite: https://git.oschina.net/helyho/JDocker
 * Licence: Apache v2 License
 */
public class ExecCreate {
    private Boolean attachStdin;
    private Boolean attachStdout;
    private Boolean attachStderr;
    private String detachKeys;
    private Boolean tty;
    private Boolean privileged;
    private List<String> cmd;

    //v1.25
    private List<String> env;

    public ExecCreate() {
        attachStdin = false;
        attachStdout = true;
        attachStderr = true;
        detachKeys = "ctrl-p,ctrl-q";
        tty = true;
        cmd = new ArrayList<String>();
        env = new ArrayList<String>();
    }

    public Boolean isAttachStdin() {
        return attachStdin;
    }

    public void setAttachStdin(Boolean attachStdin) {
        this.attachStdin = attachStdin;
    }

    public Boolean isAttachStdout() {
        return attachStdout;
    }

    public void setAttachStdout(Boolean attachStdout) {
        this.attachStdout = attachStdout;
    }

    public Boolean isAttachStderr() {
        return attachStderr;
    }

    public void setAttachStderr(Boolean attachStderr) {
        this.attachStderr = attachStderr;
    }

    public String getDetachKeys() {
        return detachKeys;
    }

    public void setDetachKeys(String detachKeys) {
        this.detachKeys = detachKeys;
    }

    public Boolean isTty() {
        return tty;
    }

    public void setTty(Boolean tty) {
        this.tty = tty;
    }

    public Boolean isPrivileged() {
        return privileged;
    }

    public void setPrivileged(Boolean privileged) {
        this.privileged = privileged;
    }

    public List<String> getCmd() {
        return cmd;
    }

    public void setCmd(List<String> cmd) {
        this.cmd = cmd;
    }

    public List<String> getEnv() {
        return env;
    }

    public void setEnv(List<String> env) {
        this.env = env;
    }

    public static void main(String[] args) {
        ExecCreate execCreate = new ExecCreate();

        execCreate.getCmd().addAll(TObject.asList("ls", "-lh"));

        Logger.simple(JSON.formatJson(JSON.toJSON(execCreate)));
    }
}
