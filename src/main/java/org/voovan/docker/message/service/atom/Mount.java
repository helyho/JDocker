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

    private String type; // bind/volume/tmpfs

    public Mount() {
        readOnly = true;
        type = "volume";
    }


    public Mount( String type, String source, String target, boolean readOnly) {
        this.source = source;
        this.target = target;
        this.readOnly = readOnly;
        this.type = type;
    }

    public Mount(String source, String target, boolean readOnly) {
        this.source = source;
        this.target = target;
        this.readOnly = readOnly;
        this.type = "volume";
    }

    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    public Boolean isReadOnly() {
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
