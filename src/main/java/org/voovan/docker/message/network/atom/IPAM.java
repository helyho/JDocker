package org.voovan.docker.message.network.atom;

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
public class IPAM {
    private String driver;
    private Map<String, Object> options;
    private List<IPAMConfig> config;

    public IPAM() {
        driver = "default";
        options = new HashMap<String, Object>();
        config = new ArrayList<IPAMConfig>();
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public Map<String, Object> getOptions() {
        return options;
    }

    public void setOptions(Map<String, Object> options) {
        this.options = options;
    }

    public List<IPAMConfig> getConfig() {
        return config;
    }

    public void setConfig(List<IPAMConfig> config) {
        this.config = config;
    }
}
