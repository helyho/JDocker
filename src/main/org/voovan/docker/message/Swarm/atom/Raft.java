package org.voovan.docker.message.Swarm.atom;

/**
 *
 * @author helyho
 * <p>
 * DockerFly Framework.
 * WebSite: https://git.oschina.net/helyho/JDocker
 * Licence: Apache v2 License
 */
public class Raft {
    private Integer snapshotIntegererval;
    private Integer logEntriesForSlowFollowers;
    private Integer heartbeatTick;
    private Integer electionTick;

    public Raft() {
        snapshotIntegererval = 10000;
        logEntriesForSlowFollowers = 500;
        heartbeatTick = 1;
        electionTick = 10;
    }

    public Raft(Integer snapshotIntegererval, Integer logEntriesForSlowFollowers, Integer heartbeatTick, Integer electionTick) {
        this.snapshotIntegererval = snapshotIntegererval;
        this.logEntriesForSlowFollowers = logEntriesForSlowFollowers;
        this.heartbeatTick = heartbeatTick;
        this.electionTick = electionTick;
    }

    public Integer getSnapshotIntegererval() {
        return snapshotIntegererval;
    }

    public void setSnapshotIntegererval(Integer snapshotIntegererval) {
        this.snapshotIntegererval = snapshotIntegererval;
    }

    public Integer getLogEntriesForSlowFollowers() {
        return logEntriesForSlowFollowers;
    }

    public void setLogEntriesForSlowFollowers(Integer logEntriesForSlowFollowers) {
        this.logEntriesForSlowFollowers = logEntriesForSlowFollowers;
    }

    public Integer getHeartbeatTick() {
        return heartbeatTick;
    }

    public void setHeartbeatTick(Integer heartbeatTick) {
        this.heartbeatTick = heartbeatTick;
    }

    public Integer getElectionTick() {
        return electionTick;
    }

    public void setElectionTick(Integer electionTick) {
        this.electionTick = electionTick;
    }
}
