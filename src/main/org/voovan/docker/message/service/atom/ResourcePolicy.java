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
    private Integer nanoCPUs;

    private Long memoryBytes;

    public ResourcePolicy() {
        nanoCPUs = 0;
        memoryBytes = 0L;

    }

    public void setNanoCPUs(Integer nanoCPUs) {
        this.nanoCPUs = nanoCPUs;
    }

    public Integer getNanoCPUs() {
        return this.nanoCPUs;
    }

    public void setMemoryBytes(Long memoryBytes) {
        this.memoryBytes = memoryBytes;
    }

    public Long getMemoryBytes() {
        return this.memoryBytes;
    }
}
