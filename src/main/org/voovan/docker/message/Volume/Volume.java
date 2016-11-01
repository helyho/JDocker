package org.voovan.docker.message.Volume;

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
public class Volume {
    private String name;
    private String driver;
    private String mountpoint;
    private Map<String, Object> labels;
    private String scope;

    public Volume() {
        labels = new HashMap<String, Object>();
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

    public String getMountpoint() {
        return mountpoint;
    }

    public void setMountpoint(String mountpoint) {
        this.mountpoint = mountpoint;
    }

    public Map<String, Object> getLabels() {
        return labels;
    }

    public void setLabels(Map<String, Object> labels) {
        this.labels = labels;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public static List<Volume> load(String jsonStr) throws ParseException, ReflectiveOperationException {

        if(!jsonStr.trim().startsWith("[")){
            jsonStr = "["+jsonStr+"]";
        }

        JSONPath jsonPath = JSONPath.newInstance(jsonStr);
        List<Volume> volumes = new ArrayList<Volume>();
        for (int i = 0; i < jsonPath.value("/Volumes", List.class).size(); i++) {
            Volume volume = new Volume();
            volume.setName(jsonPath.value("/Volumes[" + i + "]/Name", String.class,""));
            volume.setDriver(jsonPath.value("/Volumes[" + i + "]/Driver", String.class,""));
            volume.setMountpoint(jsonPath.value("/Volumes[" + i + "]/Mountpoint", String.class,""));
            volume.setScope(jsonPath.value("/Volumes[" + i + "]/Scope", String.class,""));
            volume.getLabels().putAll(jsonPath.value("/Volumes[" + i + "]/Labels", Map.class, new HashMap<String,Object>()));
            volumes.add(volume);
        }

        return volumes;
    }


}
