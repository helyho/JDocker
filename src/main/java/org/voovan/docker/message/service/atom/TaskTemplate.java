package org.voovan.docker.message.service.atom;

/**
 *
 * @author helyho
 * <p>
 * DockerFly Framework.
 * WebSite: https://git.oschina.net/helyho/JDocker
 * Licence: Apache v2 License
 */
public class TaskTemplate {
    private Container containerSpec;
    private Resource resources;
    private RestartPolicy restartPolicy;
    private Placement placement;


    //v1.25
    private Integer forceUpdate;


    public TaskTemplate() {
        containerSpec = new Container();
        resources = new Resource();
        restartPolicy = new RestartPolicy();
        placement = new Placement();
        forceUpdate = 0;
    }

    public Container getContainer() {
        return containerSpec;
    }

    public void setContainer(Container container) {
        this.containerSpec = container;
    }

    public Resource getResource() {
        return resources;
    }

    public void setResource(Resource resource) {
        this.resources = resource;
    }

    public RestartPolicy getRestartPolicy() {
        return restartPolicy;
    }

    //v1.25
    public Integer getForceUpdate() {
        return forceUpdate;
    }

    //v1.25
    public void setForceUpdate(Integer forceUpdate) {
        this.forceUpdate = forceUpdate;
    }

    public void setRestartPolicy(RestartPolicy restartPolicy) {
        this.restartPolicy = restartPolicy;
    }

    public Placement getPlacement() {
        return placement;
    }

    public void setPlacement(Placement placement) {
        this.placement = placement;
    }
}
