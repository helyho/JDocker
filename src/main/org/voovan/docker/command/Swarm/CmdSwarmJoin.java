package org.voovan.docker.command.Swarm;

import org.voovan.docker.command.Cmd;
import org.voovan.docker.message.swarm.SwarmJoin;
import org.voovan.docker.network.DockerClientException;
import org.voovan.docker.network.Result;
import org.voovan.tools.TObject;

/**
 * 类文字命名
 *
 * @author helyho
 *         <p>
 *         JDocker Framework.
 *         WebSite: https://github.com/helyho/JDocker
 *         Licence: Apache v2 License
 */
public class CmdSwarmJoin extends Cmd {

    private SwarmJoin swarmJoin;

    public CmdSwarmJoin() {
        swarmJoin = new SwarmJoin();
    }

    public CmdSwarmJoin joinToken(String joinToken){
        swarmJoin.setJoinToken(joinToken);
        return this;
    }

    public CmdSwarmJoin advertiseAddr(String advertiseAddr){
        swarmJoin.setAdvertiseAddr(advertiseAddr);
        return this;
    }

    public CmdSwarmJoin listenAddr(String listenAddr){
        swarmJoin.setListenAddr(listenAddr);
        return this;
    }

    public CmdSwarmJoin remoteAddrs(String ... remoteAddrs){
        swarmJoin.getRemoteAddrs().addAll(TObject.newList(remoteAddrs));
        return this;
    }

    public SwarmJoin getEntity(){
        return swarmJoin;
    }

    public static CmdSwarmJoin newInstance(){
        return new CmdSwarmJoin();
    }

    @Override
    public String send() throws Exception {
        Result result = getDockerHttpClient().post("/swarm/join",getParameters(),swarmJoin);
        if(result!=null && result.getStatus()>=300){
            throw new DockerClientException(result.getMessage());
        }else{
            return result.getMessage();
        }

    }

}
