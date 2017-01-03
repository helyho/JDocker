package org.voovan.docker.message.info.atom;

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
public class Plugins {

    private List<String> volume;
    private List<String> network;

    public Plugins(){
        volume = new ArrayList<String>();
        network = new ArrayList<String>();
    }

    public List<String> getVolume() {
        return volume;
    }

    public void setVolume(List<String> volume) {
        this.volume = volume;
    }

    public List<String> getNetwork() {
        return network;
    }

    public void setNetwork(List<String> network) {
        this.network = network;
    }
}
