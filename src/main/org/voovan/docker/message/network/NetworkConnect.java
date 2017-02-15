package org.voovan.docker.message.network;

import org.voovan.docker.message.network.atom.EndpointConfig;

/**
 *
 * @author helyho
 * <p>
 * DockerFly Framework.
 * WebSite: https://git.oschina.net/helyho/JDocker
 * Licence: Apache v2 License
 */
public class NetworkConnect {
    private String container;
    private EndpointConfig endpointConfig;

    public NetworkConnect() {
        super();
        endpointConfig = new EndpointConfig();
    }

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public EndpointConfig getEndpointConfig() {
        return endpointConfig;
    }

    public void setEndpointConfig(EndpointConfig endpointConfig) {
        this.endpointConfig = endpointConfig;
    }
}
