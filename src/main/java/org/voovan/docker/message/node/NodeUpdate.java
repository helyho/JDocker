package org.voovan.docker.message.node;

import org.voovan.tools.json.JSON;
import org.voovan.tools.log.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author helyho
 * <p>
 * DockerFly Framework.
 * WebSite: https://git.oschina.net/helyho/JDocker
 * Licence: Apache v2 License
 */
public class NodeUpdate {
    private String availability;
    private String name;
    private String role;
    private Map<String, String> labels;

    public NodeUpdate() {
        labels = new HashMap<String, String>();
        availability = "active";
        role = "manager";
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Map<String, String> getLabels() {
        return labels;
    }

    public void setLabels(Map<String, String> labels) {
        this.labels = labels;
    }

    public static void main(String[] args) {
        NodeUpdate nodeUpdate = new NodeUpdate();
        nodeUpdate.setName("ModyNode");
        Logger.simple(JSON.formatJson(JSON.toJSON(nodeUpdate)));
    }
}
