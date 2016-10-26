package org.voovan.docker.message.Swarm.atom;

/**
 * 类文字命名
 *
 * @author helyho
 *         <p>
 *         DockerFly Framework.
 *         WebSite: https://github.com/helyho/DockerFly
 *         Licence: Apache v2 License
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
