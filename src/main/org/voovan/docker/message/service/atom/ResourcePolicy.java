package org.voovan.docker.message.service.atom;

/**
 * 类文字命名
 *
 * @author helyho
 *         <p>
 *         DockerFly Framework.
 *         WebSite: https://github.com/helyho/DockerFly
 *         Licence: Apache v2 License
 */
public class ResourcePolicy {
    private int nanoCPUs;

    private long memoryBytes;

    public ResourcePolicy(){
        nanoCPUs = 0;
        memoryBytes = 0;//134217728;
    }

    public void setNanoCPUs(int nanoCPUs){
        this.nanoCPUs = nanoCPUs;
    }
    public int getNanoCPUs(){
        return this.nanoCPUs;
    }
    public void setMemoryBytes(long memoryBytes){
        this.memoryBytes = memoryBytes;
    }
    public long getMemoryBytes(){
        return this.memoryBytes;
    }
}
