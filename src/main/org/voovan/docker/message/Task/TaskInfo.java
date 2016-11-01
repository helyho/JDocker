package org.voovan.docker.message.Task;

import org.voovan.docker.message.Task.atom.Status;
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
public class TaskInfo {
    private String id;
    private String createdAt;
    private String updatedAt;
    private String serviceID;
    private String slot;
    private String nodeID;
    private Status status;
    private String desiredState;

    public TaskInfo() {
        status = new Status();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public String getNodeID() {
        return nodeID;
    }

    public void setNodeID(String nodeID) {
        this.nodeID = nodeID;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDesiredState() {
        return desiredState;
    }

    public void setDesiredState(String desiredState) {
        this.desiredState = desiredState;
    }

    public static List<TaskInfo> load(String jsonStr) throws ParseException, ReflectiveOperationException {
        if(!jsonStr.trim().startsWith("[")){
            jsonStr = "["+jsonStr+"]";
        }

        List<TaskInfo> taskInfos = new ArrayList<TaskInfo>();
        JSONPath jsonPath = JSONPath.newInstance(jsonStr);
        for (int i = 0; i < jsonPath.value("/", List.class).size(); i++) {
            TaskInfo taskInfo = jsonPath.value("/[" + i + "]", TaskInfo.class, new TaskInfo());
            taskInfos.add(taskInfo);
        }
        return taskInfos;
    }

}
