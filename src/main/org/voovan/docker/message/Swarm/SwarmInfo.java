package org.voovan.docker.message.Swarm;

import org.voovan.docker.message.Swarm.atom.JoinTokens;
import org.voovan.docker.message.Swarm.atom.Spec;
import org.voovan.docker.message.Swarm.atom.Version;
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
    private String CreatedAt;
    private String UpdatedAt;
    private Spec spec;
    private JoinTokens joinTokens;

    public SwarmInfo() {
        version = new Version();
        spec = new Spec();
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
        return CreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        CreatedAt = createdAt;
    }

    public String getUpdatedAt() {
        return UpdatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        UpdatedAt = updatedAt;
    }

    public Spec getSpec() {
        return spec;
    }

    public void setSpec(Spec spec) {
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
