package org.voovan.docker.message.service.atom;

import org.voovan.docker.message.service.atom.*;

/**
 * 类文字命名
 *
 * @author helyho
 *         <p>
 *         DockerFly Framework.
 *         WebSite: https://github.com/helyho/DockerFly
 *         Licence: Apache v2 License
 */
public class TaskTemplate {
    private Container containerSpec;
    private Resource resources;
    private RestartPolicy restartPolicy;


    public TaskTemplate() {
        containerSpec = new Container();
        resources = new Resource();
        restartPolicy = new RestartPolicy();
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

    public void setRestartPolicy(RestartPolicy restartPolicy) {
        this.restartPolicy = restartPolicy;
    }
}
