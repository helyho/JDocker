package org.voovan.docker.message.service.atom;

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
public class Container {
    private String image;
    private List<String> command;
    private List<String> args;
    private List<String> env;
    private List<Mount> mounts;
    private Long stopGracePeriod;


    public Container() {
        command = new ArrayList<String>();
        args = new ArrayList<String>();
        env = new ArrayList<String>();
        mounts = new ArrayList<Mount>();
        stopGracePeriod = 0L;

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

}


