package org.voovan.docker.message.swarm.atom;

/**
 *
 * @author helyho
 * <p>
 * DockerFly Framework.
 * WebSite: https://git.oschina.net/helyho/JDocker
 * Licence: Apache v2 License
 */
public class Spec {
    private String name;
    private Orchestration orchestration;
    private Raft raft;
    private Dispatcher dispatcher;
    private CAConfig caConfig;

    public Spec() {
        name = "SwarmManager";
        orchestration = new Orchestration();
        raft = new Raft();
        dispatcher = new Dispatcher();
        caConfig = new CAConfig();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Orchestration getOrchestration() {
        return orchestration;
    }

    public void setOrchestration(Orchestration orchestration) {
        this.orchestration = orchestration;
    }

    public Raft getRaft() {
        return raft;
    }

    public void setRaft(Raft raft) {
        this.raft = raft;
    }

    public Dispatcher getDispatcher() {
        return dispatcher;
    }

    public void setDispatcher(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public CAConfig getCaConfig() {
        return caConfig;
    }

    public void setCaConfig(CAConfig caConfig) {
        this.caConfig = caConfig;
    }
}
