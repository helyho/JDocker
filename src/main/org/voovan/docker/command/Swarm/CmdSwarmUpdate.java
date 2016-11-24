package org.voovan.docker.command.Swarm;

import org.voovan.docker.command.Cmd;
import org.voovan.docker.message.swarm.SwarmUpdate;
import org.voovan.docker.message.swarm.atom.ExternalCA;
import org.voovan.docker.message.swarm.atom.Raft;
import org.voovan.docker.network.DockerClientException;
import org.voovan.docker.network.Result;

import java.util.Map;

/**
 * 类文字命名
 *
 * @author helyho
 *         <p>
 *         JDocker Framework.
 *         WebSite: https://github.com/helyho/JDocker
 *         Licence: Apache v2 License
 */
public class CmdSwarmUpdate extends Cmd {

    private SwarmUpdate swarmUpdate;

    public CmdSwarmUpdate() {
        swarmUpdate = new SwarmUpdate();
    }

    public CmdSwarmUpdate rotateWorkerToken(boolean rotateWorkerToken){
        addParameter("rotateWorkerToken",rotateWorkerToken);
        return this;
    }

    public CmdSwarmUpdate rotateManagerToken(boolean rotateManagerToken){
        addParameter("rotateManagerToken",rotateManagerToken);
        return this;
    }

    public CmdSwarmUpdate name(String name){
        swarmUpdate.setName(name);
        return this;
    }

    public CmdSwarmUpdate version(int version){
        addParameter("version",version);
        return this;
    }

    public CmdSwarmUpdate taskHistoryRetentionLimit(int taskHistoryRetentionLimit){
        swarmUpdate.getOrchestration().setTaskHistoryRetentionLimit(taskHistoryRetentionLimit);
        return this;
    }

    public CmdSwarmUpdate heartbeatPeriod(int heartbeatPeriod){
        swarmUpdate.getDispatcher().setHeartbeatPeriod(heartbeatPeriod*1000000000L);
        return this;
    }

    public CmdSwarmUpdate nodeCertExpiry(int nodeCertExpiry){
        swarmUpdate.getCaConfig().setNodeCertExpiry(nodeCertExpiry*1000000000L);
        return this;
    }

    public CmdSwarmUpdate externalCA(String protocol, String url, Map<String,String> options){
        swarmUpdate.getCaConfig().setExternalCA(new ExternalCA(protocol,url,options));
        return this;
    }

    public CmdSwarmUpdate raft(int snapshotIntegererval, int logEntriesForSlowFollowers, int heartbeatTick, int electionTick){
        swarmUpdate.setRaft(new Raft(snapshotIntegererval,logEntriesForSlowFollowers,heartbeatTick,electionTick));
        return this;
    }


    public SwarmUpdate getEntity(){
        return swarmUpdate;
    }

    public static CmdSwarmUpdate newInstance(){
        return new CmdSwarmUpdate();
    }

    @Override
    public Result send() throws Exception {
        Result result = getDockerHttpClient().post("/swarm/update",getParameters(),swarmUpdate);
        if(result.getStatus()>=300){
            throw new DockerClientException(result);
        }else{
            return result;
        }

    }

}
