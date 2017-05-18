package org.voovan.docker.message.service.atom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author helyho
 * <p>
 * DockerFly Framework.
 * WebSite: https://git.oschina.net/helyho/JDocker
 * Licence: Apache v2 License
 */
public class Container {
    private String image;
    private List<String> command;
    private List<String> args;
    private List<String> env;
    private String dir;
    private String user;
    private List<Mount> mounts;
    private Map<String, String> labels;
    private Long stopGracePeriod;

    //v1.25
    private Boolean tty;

    //v1.25
    private DNSConfig dnsConfig;


    public Container() {
        command = new ArrayList<String>();
        args = new ArrayList<String>();
        env = new ArrayList<String>();
        mounts = new ArrayList<Mount>();
        labels = new HashMap<String, String>();
        tty = true;

        dnsConfig = new DNSConfig();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getCommand() {
        return command;
    }

    public void setCommand(List<String> command) {
        this.command = command;
    }

    public List<String> getArgs() {
        return args;
    }

    public void setArgs(List<String> args) {
        this.args = args;
    }

    public List<String> getEnv() {
        return env;
    }

    public void setEnv(List<String> env) {
        this.env = env;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public List<Mount> getMounts() {
        return mounts;
    }

    public void setMounts(List<Mount> mounts) {
        this.mounts = mounts;
    }

    public Long getStopGracePeriod() {
        return stopGracePeriod;
    }

    public void setStopGracePeriod(Long stopGracePeriod) {
        this.stopGracePeriod = stopGracePeriod;
    }

    public Map<String, String> getLabels() {
        return labels;
    }

    public void setLabels(Map<String, String> labels) {
        this.labels = labels;
    }

    //v1.25
    public Boolean isTty() {
        return tty;
    }

    //v1.25
    public void setTty(Boolean tty) {
        this.tty = tty;
    }

    //v1.25
    public DNSConfig getDnsConfig() {
        return dnsConfig;
    }

    //v1.25
    public void setDnsConfig(DNSConfig dnsConfig) {
        this.dnsConfig = dnsConfig;
    }
}


