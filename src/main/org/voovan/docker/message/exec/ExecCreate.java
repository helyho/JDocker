package org.voovan.docker.message.exec;

import org.voovan.tools.TObject;
import org.voovan.tools.json.JSON;
import org.voovan.tools.log.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类文字命名
 *
 * @author helyho
 *         <p>
 *         DockerFly Framework.
 *         WebSite: https://github.com/helyho/DockerFly
 *         Licence: Apache v2 License
 */
public class ExecCreate {
    private boolean attachStdin;
    private boolean attachStdout;
    private boolean attachStderr;
    private String detachKeys;
    private boolean tty;
    private List<String> cmd;

    public ExecCreate() {
        attachStdin = false;
        attachStdout = true;
        attachStderr = true;
        detachKeys = "ctrl-p,ctrl-q";
        tty = true;
        cmd = new ArrayList<String>();
    }

    public boolean isAttachStdin() {
        return attachStdin;
    }

    public void setAttachStdin(boolean attachStdin) {
        this.attachStdin = attachStdin;
    }

    public boolean isAttachStdout() {
        return attachStdout;
    }

    public void setAttachStdout(boolean attachStdout) {
        this.attachStdout = attachStdout;
    }

    public boolean isAttachStderr() {
        return attachStderr;
    }

    public void setAttachStderr(boolean attachStderr) {
        this.attachStderr = attachStderr;
    }

    public String getDetachKeys() {
        return detachKeys;
    }

    public void setDetachKeys(String detachKeys) {
        this.detachKeys = detachKeys;
    }

    public boolean isTty() {
        return tty;
    }

    public void setTty(boolean tty) {
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

        execCreate.getCmd().addAll(TObject.newList("ls","-lh"));

        Logger.simple(JSON.formatJson(JSON.toJSON(execCreate)));
    }
}
