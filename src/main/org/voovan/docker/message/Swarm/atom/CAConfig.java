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
    private Long nodeCertExpiry;
    private ExternalCA externalCA;

    public CAConfig() {
        externalCA = new ExternalCA();
    }

    public Long getNodeCertExpiry() {
        return nodeCertExpiry;
    }

    public void setNodeCertExpiry(Long nodeCertExpiry) {
        this.nodeCertExpiry = nodeCertExpiry;
    }

    public ExternalCA getExternalCA() {
        return externalCA;
    }

    public void setExternalCA(ExternalCA externalCA) {
        this.externalCA = externalCA;
    }
}
