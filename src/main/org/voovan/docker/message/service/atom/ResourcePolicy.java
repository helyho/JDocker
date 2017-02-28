package org.voovan.docker.message.service.atom;

/**
 *
 * @author helyho
 * <p>
 * DockerFly Framework.
 * WebSite: https://git.oschina.net/helyho/JDocker
 * Licence: Apache v2 License
 */
public class ResourcePolicy {
    private Long nanoCPUs;

    private Long memoryBytes;

    public ResourcePolicy() {
        nanoCPUs = 0L;
        memoryBytes = 0L;

    }

    public void setNanoCPUs(Long nanoCPUs) {
        this.nanoCPUs = nanoCPUs;
    }

    public Long getNanoCPUs() {
        return this.nanoCPUs;
    }

    public void setMemoryBytes(Long memoryBytes) {
        this.memoryBytes = memoryBytes;
    }

    public Long getMemoryBytes() {
        return this.memoryBytes;
    }
}
