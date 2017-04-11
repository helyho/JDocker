package org.voovan.docker.message.network.atom;

/**
 * 类文字命名
 *
 * @author helyho
 *         <p>
 *         JDocker Framework.
 *         WebSite: https://github.com/helyho/JDocker
 *         Licence: Apache v2 License
 */
public class EndpointConfig {
    private ConnectIPAMConfig ipamConfig;

    public EndpointConfig(){
        ipamConfig = new ConnectIPAMConfig();
    }

    public ConnectIPAMConfig getIPAMConfig() {
        return ipamConfig;
    }

    public void setIPAMConfig(ConnectIPAMConfig ipamConfig) {
        this.ipamConfig = ipamConfig;
    }
}
