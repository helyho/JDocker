package org.voovan.docker.message.exec;

import org.voovan.docker.message.container.atom.Process;
import org.voovan.docker.message.exec.atom.ProcessConfig;
import org.voovan.tools.json.JSONPath;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

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
    private boolean running;
    private int exitCode;
    private boolean openStdin;
    private boolean openStderr;
    private boolean openStdout;
    private boolean canRemove;
    private String containerID;
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

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public int getExitCode() {
        return exitCode;
    }

    public void setExitCode(int exitCode) {
        this.exitCode = exitCode;
    }

    public boolean isOpenStdin() {
        return openStdin;
    }

    public void setOpenStdin(boolean openStdin) {
        this.openStdin = openStdin;
    }

    public boolean isOpenStderr() {
        return openStderr;
    }

    public void setOpenStderr(boolean openStderr) {
        this.openStderr = openStderr;
    }

    public boolean isOpenStdout() {
        return openStdout;
    }

    public void setOpenStdout(boolean openStdout) {
        this.openStdout = openStdout;
    }

    public boolean isCanRemove() {
        return canRemove;
    }

    public void setCanRemove(boolean canRemove) {
        this.canRemove = canRemove;
    }

    public String getContainerID() {
        return containerID;
    }

    public void setContainerID(String containerID) {
        this.containerID = containerID;
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
        ExecInfo execInfo = new ExecInfo();
        execInfo.setId(jsonPath.value("/ID",String.class,""));
        execInfo.setRunning(jsonPath.value("/Running",Boolean.class,false));
        execInfo.setExitCode(jsonPath.value("/ExitCode",Integer.class,-1));
        execInfo.setOpenStdin(jsonPath.value("/OpenStdin",Boolean.class,false));
        execInfo.setOpenStderr(jsonPath.value("/OpenStderr",Boolean.class,false));
        execInfo.setOpenStdout(jsonPath.value("/OpenStdout",Boolean.class,false));
        execInfo.setCanRemove(jsonPath.value("/CanRemove",Boolean.class,false));
        execInfo.setContainerID(jsonPath.value("/ContainerID",String.class,""));
        execInfo.setDetachKeys(jsonPath.value("/DetachKeys",String.class,""));


        ProcessConfig processConfig = execInfo.getProcessConfig();
        processConfig.setEntrypoint(jsonPath.value("/ProcessConfig/entrypoint",String.class,""));
        processConfig.setTty(jsonPath.value("/ProcessConfig/tty",Boolean.class,false));
        processConfig.setPrivileged(jsonPath.value("/ProcessConfig/privileged",Boolean.class,false));
        processConfig.getArguments().addAll(jsonPath.value("/ProcessConfig/arguments",
                                                            List.class,new ArrayList<String>()));

        return execInfo;
    }
}
