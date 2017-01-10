package org.voovan.docker.message.swarm;

import org.voovan.docker.message.swarm.atom.JoinTokens;
import org.voovan.docker.message.swarm.atom.SwarmSpec;
import org.voovan.docker.message.swarm.atom.Version;
import org.voovan.tools.json.JSONPath;

import java.text.ParseException;

/**
 *
 * @author helyho
 * <p>
 * DockerFly Framework.
 * WebSite: https://git.oschina.net/helyho/JDocker
 * Licence: Apache v2 License
 */
public class SwarmInfo {
    private String id;
    private Version version;
    private String createdAt;
    private String updatedAt;
    private SwarmSpec spec;
    private JoinTokens joinTokens;

    public SwarmInfo() {
        version = new Version();
        spec = new SwarmSpec();
        joinTokens = new JoinTokens();

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public SwarmSpec getSpec() {
        return spec;
    }

    public void setSpec(SwarmSpec spec) {
        this.spec = spec;
    }

    public JoinTokens getJoinTokens() {
        return joinTokens;
    }

    public void setJoinTokens(JoinTokens joinTokens) {
        this.joinTokens = joinTokens;
    }

    public static SwarmInfo load(String jsonStr) throws ParseException, ReflectiveOperationException {
        JSONPath jsonPath = JSONPath.newInstance(jsonStr);
        SwarmInfo swarmInfo = jsonPath.value("/", SwarmInfo.class, new SwarmInfo());
        return swarmInfo;
    }
}
