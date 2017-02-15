package org.voovan.docker.command.Network;

import org.voovan.docker.command.Cmd;
import org.voovan.docker.message.network.NetworkConnect;
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
public class CmdNetworkConnect extends Cmd {
    private String nameOrid;
    private NetworkConnect networkConnect;

    public CmdNetworkConnect(String nameOrid){
        this.nameOrid = nameOrid;
        networkConnect = new NetworkConnect();
    }

    public CmdNetworkConnect container(String container){
        this.networkConnect.setContainer(container);
        return this;
    }

    public CmdNetworkConnect ipv4Address(String address){
        this.networkConnect.getEndpointConfig().getIPAMConfig().setIpv4Address(address);
        return this;
    }

    public CmdNetworkConnect ipv6Address(String address){
        this.networkConnect.getEndpointConfig().getIPAMConfig().setIpv6Address(address);
        return this;
    }

    public NetworkConnect getEntity(){
        return networkConnect;
    }

    public static CmdNetworkConnect newInstance(String nameOrid){
        return new CmdNetworkConnect(nameOrid);
    }


    @Override
    public String send() throws Exception {
        Result result = getDockerHttpClient().post("/networks/"+nameOrid+"/connect",getParameters(),networkConnect);
        if(result!=null && result.getStatus()>=300){
            throw new DockerClientException(result.getMessage());
        }else{
            return result.getMessage();
        }
    }
}
