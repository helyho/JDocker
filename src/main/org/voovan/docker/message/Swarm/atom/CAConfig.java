package org.voovan.docker.message.Swarm.atom;

/**
 *
 * @author helyho
 * <p>
 * DockerFly Framework.
 * WebSite: https://git.oschina.net/helyho/JDocker
 * Licence: Apache v2 License
 */
public class CAConfig {
    private long nodeCertExpiry;

    public long getNodeCertExpiry() {
        return nodeCertExpiry;
    }

    public void setNodeCertExpiry(long nodeCertExpiry) {
        this.nodeCertExpiry = nodeCertExpiry;
    }
}
