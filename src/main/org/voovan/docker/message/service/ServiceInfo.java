package org.voovan.docker.message.service;

import org.voovan.docker.message.service.atom.Endpoint;
import org.voovan.docker.message.service.atom.UpdateStatus;
import org.voovan.docker.message.service.atom.Version;
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
        if(!jsonStr.trim().startsWith("[")){
            jsonStr = "["+jsonStr+"]";
        }

        JSONPath jsonPath = JSONPath.newInstance(jsonStr);
        List<ServiceInfo> serviceInfos = jsonPath.listObject("/", ServiceInfo.class, new ArrayList<ServiceInfo>());

        return serviceInfos;
    }
}
