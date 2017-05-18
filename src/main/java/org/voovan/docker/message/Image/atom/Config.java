package org.voovan.docker.message.Image.atom;

import java.util.List;
import java.util.Map;

/**
 * 类文字命名
 *
 * @author: helyho
 * JDocker Framework.
 * WebSite: https://github.com/helyho/JDocker
 * Licence: Apache v2 License
 */
public class Config {
    private String hostname;
    private String domainname;
    private String user;
    private String image;
    private String workingDir;
    private Boolean attachStdin;
    private Boolean attachStdout;
    private Boolean attachStderr;
    private Boolean tty;
    private Boolean openStdin;
    private Boolean stdinOnce;
    private Boolean argsEscaped;
    private List<String> env;
    private List<String> cmd;
    private List<String> entrypoint;
    private List<String> onBuild;
    private Map<String, Map> exposedPorts;
    private Map<String, Map> volumes;
    private Map<String, String> labels;

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getDomainname() {
        return domainname;
    }

    public void setDomainname(String domainname) {
        this.domainname = domainname;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getWorkingDir() {
        return workingDir;
    }

    public void setWorkingDir(String workingDir) {
        this.workingDir = workingDir;
    }

    public Boolean getAttachStdin() {
        return attachStdin;
    }

    public void setAttachStdin(Boolean attachStdin) {
        this.attachStdin = attachStdin;
    }

    public Boolean getAttachStdout() {
        return attachStdout;
    }

    public void setAttachStdout(Boolean attachStdout) {
        this.attachStdout = attachStdout;
    }

    public Boolean getAttachStderr() {
        return attachStderr;
    }

    public void setAttachStderr(Boolean attachStderr) {
        this.attachStderr = attachStderr;
    }

    public Boolean getTty() {
        return tty;
    }

    public void setTty(Boolean tty) {
        this.tty = tty;
    }

    public Boolean getOpenStdin() {
        return openStdin;
    }

    public void setOpenStdin(Boolean openStdin) {
        this.openStdin = openStdin;
    }

    public Boolean getStdinOnce() {
        return stdinOnce;
    }

    public void setStdinOnce(Boolean stdinOnce) {
        this.stdinOnce = stdinOnce;
    }

    public Boolean getArgsEscaped() {
        return argsEscaped;
    }

    public void setArgsEscaped(Boolean argsEscaped) {
        this.argsEscaped = argsEscaped;
    }

    public List<String> getEnv() {
        return env;
    }

    public void setEnv(List<String> env) {
        this.env = env;
    }

    public List<String> getCmd() {
        return cmd;
    }

    public void setCmd(List<String> cmd) {
        this.cmd = cmd;
    }

    public List<String> getEntrypoint() {
        return entrypoint;
    }

    public void setEntrypoint(List<String> entrypoint) {
        this.entrypoint = entrypoint;
    }

    public List<String> getOnBuild() {
        return onBuild;
    }

    public void setOnBuild(List<String> onBuild) {
        this.onBuild = onBuild;
    }

    public Map<String, Map> getExposedPorts() {
        return exposedPorts;
    }

    public void setExposedPorts(Map<String, Map> exposedPorts) {
        this.exposedPorts = exposedPorts;
    }

    public Map<String, Map> getVolumes() {
        return volumes;
    }

    public void setVolumes(Map<String, Map> volumes) {
        this.volumes = volumes;
    }

    public Map<String, String> getLabels() {
        return labels;
    }

    public void setLabels(Map<String, String> labels) {
        this.labels = labels;
    }
}
