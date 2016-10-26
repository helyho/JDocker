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
public class Raft {
    private int snapshotInterval;
    private int logEntriesForSlowFollowers;
    private int heartbeatTick;
    private int electionTick;

    public Raft() {
        snapshotInterval = 10000;
        logEntriesForSlowFollowers = 500;
        heartbeatTick = 1;
        electionTick = 3;
    }

    public int getSnapshotInterval() {
        return snapshotInterval;
    }

    public void setSnapshotInterval(int snapshotInterval) {
        this.snapshotInterval = snapshotInterval;
    }

    public int getLogEntriesForSlowFollowers() {
        return logEntriesForSlowFollowers;
    }

    public void setLogEntriesForSlowFollowers(int logEntriesForSlowFollowers) {
        this.logEntriesForSlowFollowers = logEntriesForSlowFollowers;
    }

    public int getHeartbeatTick() {
        return heartbeatTick;
    }

    public void setHeartbeatTick(int heartbeatTick) {
        this.heartbeatTick = heartbeatTick;
    }

    public int getElectionTick() {
        return electionTick;
    }

    public void setElectionTick(int electionTick) {
        this.electionTick = electionTick;
    }
}
