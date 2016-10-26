package org.voovan.docker.message.Node;

import org.voovan.tools.json.JSON;
import org.voovan.tools.log.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * 类文字命名
 *
 * @author helyho
 *         <p>
 *         DockerFly Framework.
 *         WebSite: https://github.com/helyho/DockerFly
 *         Licence: Apache v2 License
 */
public class NodeUpdate {
    private String availability;
    private String name;
    private String role;
    private Map<String,Object> labels;

    public NodeUpdate() {
        labels = new HashMap<String,Object>();
        availability= "active";
        role= "manager";
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

    public Map<String, Object> getLabels() {
        return labels;
    }

    public void setLabels(Map<String, Object> labels) {
        this.labels = labels;
    }

    public static void main(String[] args) {
        NodeUpdate nodeUpdate = new NodeUpdate();
        nodeUpdate.setName("ModyNode");
        Logger.simple(JSON.formatJson(JSON.toJSON(nodeUpdate)));
    }
}
