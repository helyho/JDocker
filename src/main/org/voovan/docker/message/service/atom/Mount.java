package org.voovan.docker.message.service.atom;

/**
 *
 * @author helyho
 * <p>
 * DockerFly Framework.
 * WebSite: https://git.oschina.net/helyho/JDocker
 * Licence: Apache v2 License
 */
public class Mount {

    private Boolean readOnly;

    private String source;

    private String target;

    private String type; // bind/volume

    public Mount() {
        readOnly = true;
        type = "volume";
    }

    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    public Boolean getReadOnly() {
        return this.readOnly;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSource() {
        return this.source;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getTarget() {
        return this.target;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}
