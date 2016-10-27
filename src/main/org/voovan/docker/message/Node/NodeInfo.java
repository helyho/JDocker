package org.voovan.docker.message.Node;

import org.voovan.docker.message.Node.atom.*;
import org.voovan.tools.json.JSONPath;

import java.text.ParseException;
import java.util.ArrayList;
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
        List<NodeInfo> nodeInfos = new ArrayList<NodeInfo>();
        JSONPath jsonPath = JSONPath.newInstance(jsonStr);
        for (int i = 0; i < jsonPath.value("/", List.class).size(); i++) {
            NodeInfo nodeInfo = new NodeInfo();
            nodeInfo.setId(jsonPath.value("/[" + i + "]/ID", String.class));
            nodeInfo.setVersion(jsonPath.value("/[" + i + "]/Version", Version.class));
            nodeInfo.setCreatedAt(jsonPath.value("/[" + i + "]/CreatedAt", String.class));
            nodeInfo.setUpdatedAt(jsonPath.value("/[" + i + "]/UpdatedAt", String.class));

            Spec spec = nodeInfo.getSpec();

            spec.setName(jsonPath.value("/[" + i + "]/Spec/Name", String.class));
            spec.setRole(jsonPath.value("/[" + i + "]/Spec/Role", String.class));
            spec.setAvailability(jsonPath.value("/[" + i + "]/Spec/Availability", String.class));
            Map labels = jsonPath.value("/[" + i + "]/Spec/Labels", Map.class);
            if (labels != null) {
                spec.getLabels().putAll(labels);
            }

            Description description = nodeInfo.getDescription();
            description.setHostname(jsonPath.value("/[" + i + "]/Description/Hostname", String.class));
            description.setPlatform(jsonPath.value("/[" + i + "]/Description/Platform", Platform.class));
            description.setResources(jsonPath.value("/[" + i + "]/Description/Resources", Resources.class));

            Engine engine = description.getEngine();
            engine.setEngineVersion(jsonPath.value("/[" + i + "]/Description/Engine/EngineVersion", String.class));
            engine.getPlugins().addAll(jsonPath.listObject("/[" + i + "]/Description/Engine/Plugins", Plugin.class));

            nodeInfo.setStatus(jsonPath.value("/[" + i + "]/Status", Status.class));
            nodeInfo.setManagerStatus(jsonPath.value("/[" + i + "]/ManagerStatus", ManagerStatus.class));
            nodeInfos.add(nodeInfo);
        }
        return nodeInfos;
    }
}
