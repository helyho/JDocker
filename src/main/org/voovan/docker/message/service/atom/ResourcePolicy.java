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
    private int nanoCPUs;

    private long memoryBytes;

    public ResourcePolicy() {
        nanoCPUs = 0;
        memoryBytes = 0;//134217728;
    }

    public void setNanoCPUs(int nanoCPUs) {
        this.nanoCPUs = nanoCPUs;
    }

    public int getNanoCPUs() {
        return this.nanoCPUs;
    }

    public void setMemoryBytes(long memoryBytes) {
        this.memoryBytes = memoryBytes;
    }

    public long getMemoryBytes() {
        return this.memoryBytes;
    }
}
