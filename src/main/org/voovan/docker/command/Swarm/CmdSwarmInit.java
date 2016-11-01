package org.voovan.docker.command.Swarm;

import org.voovan.docker.command.Cmd;
import org.voovan.docker.message.swarm.SwarmInit;
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
public class CmdSwarmInit extends Cmd {

    private SwarmInit swarmInit;

    public CmdSwarmInit() {
        swarmInit = new SwarmInit();
    }

    public CmdSwarmInit listenAddr(String listenAddr){
        swarmInit.setListenAddr(listenAddr);
        return this;
    }

    public CmdSwarmInit advertiseAddr(String advertiseAddr){
        swarmInit.setAdvertiseAddr(advertiseAddr);
        return this;
    }

    public CmdSwarmInit forceNewCluster(boolean forceNewCluster){
        swarmInit.setForceNewCluster(forceNewCluster);
        return this;
    }

    public CmdSwarmInit name(String name){
        swarmInit.getSpec().setName(name);
        return this;
    }

    public CmdSwarmInit taskHistoryRetentionLimit(int taskHistoryRetentionLimit){
        swarmInit.getSpec().getOrchestration().setTaskHistoryRetentionLimit(taskHistoryRetentionLimit);
        return this;
    }

    public CmdSwarmInit heartbeatPeriod(int heartbeatPeriod){
        swarmInit.getSpec().getDispatcher().setHeartbeatPeriod(heartbeatPeriod*1000000000L);
        return this;
    }

    public CmdSwarmInit nodeCertExpiry(int nodeCertExpiry){
        swarmInit.getSpec().getCaConfig().setNodeCertExpiry(nodeCertExpiry*1000000000L);
        return this;
    }

    public CmdSwarmInit externalCA(String protocol,String url,Map<String,String> options){
        swarmInit.getSpec().getCaConfig().setExternalCA(new ExternalCA(protocol,url,options));
        return this;
    }

    public CmdSwarmInit raft(int snapshotIntegererval, int logEntriesForSlowFollowers, int heartbeatTick, int electionTick){
        swarmInit.getSpec().setRaft(new Raft(snapshotIntegererval,logEntriesForSlowFollowers,heartbeatTick,electionTick));
        return this;
    }

    public static CmdSwarmInit newInstance(){
        return new CmdSwarmInit();
    }

    @Override
    public Result send() throws Exception {
        Result result = getDockerHttpClient().post("/swarm/init",getParameters(),swarmInit);
        if(result.getStatus()>=300){
            throw new DockerClientException(result);
        }else{
            return result;
        }

    }

}
