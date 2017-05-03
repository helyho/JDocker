package org.voovan.docker.message.exec;

import org.voovan.docker.message.exec.atom.ProcessConfig;
import org.voovan.tools.json.JSONPath;

import java.text.ParseException;

/**
 * 类文字命名
 *
 * @author helyho
 *         <p>
 *         JDocker Framework.
 *         WebSite: https://github.com/helyho/JDocker
 *         Licence: Apache v2 License
 */
public class ExecInfo {
    private String id;
    private Boolean running;
    private Integer exitCode;
    private Boolean openStdin;
    private Boolean openStderr;
    private Boolean openStdout;
    private Boolean canRemove;
    private String containerId;
    private String detachKeys;
    private ProcessConfig processConfig;

    public ExecInfo() {
        processConfig = new ProcessConfig();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean isRunning() {
        return running;
    }

    public void setRunning(Boolean running) {
        this.running = running;
    }

    public Integer getExitCode() {
        return exitCode;
    }

    public void setExitCode(Integer exitCode) {
        this.exitCode = exitCode;
    }

    public Boolean isOpenStdin() {
        return openStdin;
    }

    public void setOpenStdin(Boolean openStdin) {
        this.openStdin = openStdin;
    }

    public Boolean isOpenStderr() {
        return openStderr;
    }

    public void setOpenStderr(Boolean openStderr) {
        this.openStderr = openStderr;
    }

    public Boolean isOpenStdout() {
        return openStdout;
    }

    public void setOpenStdout(Boolean openStdout) {
        this.openStdout = openStdout;
    }

    public Boolean isCanRemove() {
        return canRemove;
    }

    public void setCanRemove(Boolean canRemove) {
        this.canRemove = canRemove;
    }

    public String getContainerId() {
        return containerId;
    }

    public void setContainerId(String containerId) {
        this.containerId = containerId;
    }

    public String getDetachKeys() {
        return detachKeys;
    }

    public void setDetachKeys(String detachKeys) {
        this.detachKeys = detachKeys;
    }

    public ProcessConfig getProcessConfig() {
        return processConfig;
    }

    public void setProcessConfig(ProcessConfig processConfig) {
        this.processConfig = processConfig;
    }

    public static ExecInfo load(String jsonStr) throws ParseException, ReflectiveOperationException {
        JSONPath jsonPath = new JSONPath(jsonStr);
        ExecInfo execInfo = jsonPath.value("/",ExecInfo.class);

        return execInfo;
    }
}
