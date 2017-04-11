package org.voovan.docker.command.Network;

import org.voovan.docker.command.Cmd;
import org.voovan.docker.message.network.NetworkDisconnect;
import org.voovan.docker.network.DockerClientException;
import org.voovan.docker.network.Result;

/**
 * 类文字命名
 *
 * @author helyho
 *         <p>
 *         JDocker Framework.
 *         WebSite: https://github.com/helyho/JDocker
 *         Licence: Apache v2 License
 */
public class CmdNetworkDisConnect extends Cmd {
    private String  nameOrId;
    private NetworkDisconnect networkDisconnect;

    public CmdNetworkDisConnect(String  nameOrId){
        this.nameOrId = nameOrId;
        networkDisconnect = new NetworkDisconnect();
    }

    public CmdNetworkDisConnect container(String container){
        this.networkDisconnect.setContainer(container);
        return this;
    }

    public CmdNetworkDisConnect force(boolean force){
        this.networkDisconnect.setForce(force);
        return this;
    }

    public NetworkDisconnect getEntity(){
        return networkDisconnect;
    }

    public static CmdNetworkDisConnect newInstance(String nameOrid){
        return new CmdNetworkDisConnect(nameOrid);
    }

    @Override
    public String send() throws Exception {
        Result result = getDockerHttpClient().run("POST","/networks/"+nameOrId+"/disconnect",getParameters(),networkDisconnect);
        if(result!=null && result.getStatus()>=300){
            throw new DockerClientException(result.getMessage());
        }else{
            return result.getMessage();
        }
    }
}
