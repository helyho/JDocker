package org.voovan.docker.message.service;

import org.voovan.docker.message.service.atom.*;
import org.voovan.tools.TObject;
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
public class ServiceInfo {
    private String id;
    private ServiceSpec spec;
    private String createdAt;
    private String updatedAt;

    private Endpoint endpoint;
    private Version version;
    private UpdateStatus updateStatus;

    public ServiceInfo() {
        spec = new ServiceSpec();
        endpoint = new Endpoint();
        version = new Version();
        updateStatus = new UpdateStatus();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ServiceSpec getSpec() {
        return spec;
    }

    public void setSpec(ServiceSpec spec) {
        this.spec = spec;
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

    public Endpoint getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(Endpoint endpoint) {
        this.endpoint = endpoint;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    public UpdateStatus getUpdateStatus() {
        return updateStatus;
    }

    public void setUpdateStatus(UpdateStatus updateStatus) {
        this.updateStatus = updateStatus;
    }

    /**
     * 通过 Docker 的接口返回的结果 生成 ServiceInfo 对象
     *
     * @param jsonStr Docker 的接口返回的结果
     * @return 解析的 ServiceInfo 对象
     * @throws ParseException               解析异常
     * @throws ReflectiveOperationException 反射异常
     */
    public static List<ServiceInfo> load(String jsonStr) throws ParseException, ReflectiveOperationException {
        JSONPath jsonPath = JSONPath.newInstance(jsonStr);
        List<ServiceInfo> serviceInfos = new ArrayList<ServiceInfo>();
        for (int i = 0; i < jsonPath.value("/", List.class).size(); i++) {
            ServiceInfo info = new ServiceInfo();
            ServiceSpec spec = info.getSpec();
            Container container = spec.getTaskTemplate().getContainer();
            TaskTemplate taskTemplate = spec.getTaskTemplate();

            info.setId(jsonPath.value("/[" + i + "]/ID", String.class,""));
            info.setVersion(jsonPath.value("/[" + i + "]/Version", Version.class, new Version()));
            info.setCreatedAt(jsonPath.value("/[" + i + "]/CreatedAt", String.class, ""));
            info.setUpdatedAt(jsonPath.value("/[" + i + "]/UpdatedAt", String.class, ""));
            spec.setName(jsonPath.value("/[" + i + "]/Spec/Name", String.class, ""));

            container.setImage(jsonPath.value("/[" + i + "]/Spec/TaskTemplate/ContainerSpec/Image", String.class, ""));
            container.setArgs(jsonPath.value("/[" + i + "]/Spec/TaskTemplate/ContainerSpec/Args", List.class, new ArrayList<String>()));
            container.setCommand(jsonPath.value("/[" + i + "]/Spec/TaskTemplate/ContainerSpec/command", List.class, new ArrayList<String>()));
            container.setMounts(jsonPath.listObject("/[" + i + "]/Spec/TaskTemplate/ContainerSpec/Mounts", Mount.class, new ArrayList<Mount>()));
            container.setStopGracePeriod(new Long(jsonPath.value("/[" + i + "]/Spec/TaskTemplate/ContainerSpec/StopGracePeriod", "-1").toString()));
            taskTemplate.setResource(jsonPath.value("/[" + i + "]/Spec/TaskTemplate/Resources", Resource.class, new Resource()));
            taskTemplate.setRestartPolicy(jsonPath.value("/[" + i + "]/Spec/TaskTemplate/RestartPolicy", RestartPolicy.class, new RestartPolicy()));

            spec.setMode(jsonPath.value("/[" + i + "]/Spec/Mode", Mode.class, new Mode()));
            spec.setUpdateConfig(jsonPath.value("/[" + i + "]/Spec/UpdateConfig", UpdateConfig.class, new UpdateConfig()));

            spec.setNetworks(jsonPath.listObject("/[" + i + "]/Spec/Networks", Network.class, new ArrayList<Network>()));

            spec.getEndpoint().setMode(jsonPath.value("/[" + i + "]/Spec/EndpointSpec/Mode", String.class, ""));
            spec.getEndpoint().setPorts(jsonPath.listObject("/[" + i + "]/Spec/EndpointSpec/Ports", Port.class, new ArrayList<Port>()));

            info.setUpdateStatus(jsonPath.value("/[" + i + "]/UpdateStatus", UpdateStatus.class,new UpdateStatus()));

            info.getEndpoint().setMode(jsonPath.value("/[" + i + "]/Endpoint/Spec/Mode", String.class, ""));
            info.getEndpoint().setPorts(jsonPath.listObject("/[" + i + "]/Endpoint/Ports", Port.class,new ArrayList<Port>()));
            info.getEndpoint().setVirtualIPs(jsonPath.listObject("/[" + i + "]/Endpoint/VirtualIPs", VirtualIP.class, new ArrayList<VirtualIP>()));

            spec.setLabels((Map<String, Object>) jsonPath.value("/[" + i + "]/Spec/Labels", Map.class, new HashMap<String,Object>()));

            serviceInfos.add(info);
        }

        return serviceInfos;
    }
}
