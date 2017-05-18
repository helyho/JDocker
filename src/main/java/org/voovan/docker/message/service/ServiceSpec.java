package org.voovan.docker.message.service;

import org.voovan.docker.message.service.atom.*;
import org.voovan.docker.message.service.atom.mode.Mode;
import org.voovan.tools.json.JSON;
import org.voovan.tools.log.Logger;

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
public class ServiceSpec {
    private String name;
    private TaskTemplate taskTemplate;
    private Mode mode;
    private UpdateConfig updateConfig;
    private List<Network> networks;
    private Endpoint endpointSpec;
    private Map<String, String> labels;

    public ServiceSpec() {
        taskTemplate = new TaskTemplate();
        mode = new Mode();
        updateConfig = new UpdateConfig();
        endpointSpec = new Endpoint();
        networks = new ArrayList<Network>();
        labels = new HashMap<String, String>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TaskTemplate getTaskTemplate() {
        return taskTemplate;
    }

    public void setTaskTemplate(TaskTemplate taskTemplate) {
        this.taskTemplate = taskTemplate;
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public UpdateConfig getUpdateConfig() {
        return updateConfig;
    }

    public void setUpdateConfig(UpdateConfig updateConfig) {
        this.updateConfig = updateConfig;
    }

    public Endpoint getEndpoint() {
        return endpointSpec;
    }

    public void setEndpoint(Endpoint endpoint) {
        this.endpointSpec = endpoint;
    }

    public List<Network> getNetworks() {
        return networks;
    }

    public void setNetworks(List<Network> networks) {
        this.networks = networks;
    }

    public Endpoint getEndpointSpec() {
        return endpointSpec;
    }

    public void setEndpointSpec(Endpoint endpointSpec) {
        this.endpointSpec = endpointSpec;
    }

    public Map<String, String> getLabels() {
        return labels;
    }

    public void setLabels(Map<String, String> labels) {
        this.labels = labels;
    }

    public static void main(String[] args) {
        ServiceSpec create = new ServiceSpec();
        //name
        create.setName("test_bv_prog");

        //Image
        create.getTaskTemplate().getContainer().setImage("alpine");

        //command
        create.getTaskTemplate().getContainer().getArgs().add("ping");
        create.getTaskTemplate().getContainer().getArgs().add("127.0.0.1");


        //resourxe
        create.getTaskTemplate().getResource().getLimits().setNanoCPUs(0L);
        create.getTaskTemplate().getResource().getLimits().setMemoryBytes(0L);

        create.getTaskTemplate().getResource().getReservations().setNanoCPUs(0L);
        create.getTaskTemplate().getResource().getReservations().setMemoryBytes(0L);

        //network
        Network network = new Network();
        network.setTarget("voovan");
        create.getNetworks().add(network);

        //volume
        Mount mount = new Mount();
        mount.setSource("v_t1");
        mount.setTarget("/v_t1");
        create.taskTemplate.getContainer().getMounts().add(mount);

        //port
        Port port = new Port();
        port.setPublishedPort(8080);
        port.setTargetPort(80);
        create.getEndpoint().getPorts().add(port);

        Logger.simple(JSON.formatJson(JSON.toJSON(create)));
    }
}


