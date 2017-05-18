package org.voovan.docker.message.volume;

import org.voovan.tools.json.JSONPath;

import java.text.ParseException;
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
public class VolumeInfo {
    private String name;
    private String driver;
    private Map<String, Object> driverOpts;
    private String mountpoint;
    private Map<String, String> labels;
    private String scope;

    public VolumeInfo() {
        labels = new HashMap<String, String>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public Map<String, Object> getDriverOpts() {
        return driverOpts;
    }

    public void setDriverOpts(Map<String, Object> driverOpts) {
        this.driverOpts = driverOpts;
    }

    public String getMountpoint() {
        return mountpoint;
    }

    public void setMountpoint(String mountpoint) {
        this.mountpoint = mountpoint;
    }

    public Map<String, String> getLabels() {
        return labels;
    }

    public void setLabels(Map<String, String> labels) {
        this.labels = labels;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public static List<VolumeInfo> load(String jsonStr) throws ParseException, ReflectiveOperationException {

        JSONPath jsonPath = JSONPath.newInstance(jsonStr);
        List<VolumeInfo> volumes = jsonPath.listObject("/Volumes", VolumeInfo.class, new ArrayList<VolumeInfo>());

        return volumes;
    }


}
