package org.voovan.docker.message.node;

import org.voovan.docker.message.node.atom.*;
import org.voovan.tools.json.JSONPath;

import java.text.ParseException;
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
public class NodeInfo {

    private String id;
    private Version version;
    private String createdAt;
    private String updatedAt;
    private Spec spec;
    private Description description;
    private Status status;
    private ManagerStatus managerStatus;

    public NodeInfo() {
        version = new Version();
        spec = new Spec();
        description = new Description();
        status = new Status();
        managerStatus = new ManagerStatus();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Spec getSpec() {
        return spec;
    }

    public void setSpec(Spec spec) {
        this.spec = spec;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public ManagerStatus getManagerStatus() {
        return managerStatus;
    }

    public void setManagerStatus(ManagerStatus managerStatus) {
        this.managerStatus = managerStatus;
    }

    public static List<NodeInfo> load(String jsonStr) throws ParseException, ReflectiveOperationException {

        if(!jsonStr.trim().startsWith("[")){
            jsonStr = "["+jsonStr+"]";
        }

        JSONPath jsonPath = JSONPath.newInstance(jsonStr);
        List<NodeInfo> nodeInfos = jsonPath.value("/",List.class,new ArrayList<NodeInfo>());
        return nodeInfos;
    }
}
