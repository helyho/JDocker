package org.voovan.docker.message.service.atom;

import java.util.ArrayList;
import java.util.List;

/**
 * 类文字命名
 *
 * @author helyho
 *         <p>
 *         DockerFly Framework.
 *         WebSite: https://github.com/helyho/DockerFly
 *         Licence: Apache v2 License
 */
public class Endpoint {
    private String mode;
    private List<Port> ports;
    private List<VirtualIP> virtualIPs;

    public Endpoint(){
        mode="vip";
        ports = new ArrayList<Port>();
        virtualIPs = new ArrayList<VirtualIP>();
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public List<Port> getPorts() {
        return ports;
    }

    public void setPorts(List<Port> ports) {
        this.ports = ports;
    }

    public List<VirtualIP> getVirtualIPs() {
        return virtualIPs;
    }

    public void setVirtualIPs(List<VirtualIP> virtualIPs) {
        this.virtualIPs = virtualIPs;
    }

}
