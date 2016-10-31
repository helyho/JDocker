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
    private List<String> cmd;

    public ExecCreate() {
        attachStdin = false;
        attachStdout = true;
        attachStderr = true;
        detachKeys = "ctrl-p,ctrl-q";
        tty = true;
        cmd = new ArrayList<String>();
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

    public List<String> getCmd() {
        return cmd;
    }

    public void setCmd(List<String> cmd) {
        this.cmd = cmd;
    }

    public static void main(String[] args) {
        ExecCreate execCreate = new ExecCreate();

        execCreate.getCmd().addAll(TObject.newList("ls", "-lh"));

        Logger.simple(JSON.formatJson(JSON.toJSON(execCreate)));
    }
}
