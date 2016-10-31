package org.voovan.docker.message.container.atom;

/**
 *
 * @author helyho
 * <p>
 * DockerFly Framework.
 * WebSite: https://git.oschina.net/helyho/JDocker
 * Licence: Apache v2 License
 */
public class Mount {
    private String name;
    private String source;
    private String destination;
    private String driver;
    private String mode;
    private Boolean rw;
    private String propagation;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Boolean isRw() {
        return rw;
    }

    public void setRw(Boolean rw) {
        this.rw = rw;
    }

    public String getPropagation() {
        return propagation;
    }

    public void setPropagation(String propagation) {
        this.propagation = propagation;
    }
}
