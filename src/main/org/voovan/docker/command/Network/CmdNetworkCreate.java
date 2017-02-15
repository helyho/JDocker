package org.voovan.docker.command.Network;

import org.voovan.docker.command.Cmd;
import org.voovan.docker.message.exec.ExecCreate;
import org.voovan.docker.message.network.NetworkCreate;
import org.voovan.docker.message.network.atom.IPAMConfig;
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
public class CmdNetworkCreate extends Cmd{

    private NetworkCreate networkCreate;

    public CmdNetworkCreate() {
        networkCreate = new NetworkCreate();
    }

    public CmdNetworkCreate name(String name){
        networkCreate.setName(name);
        return this;
    }

    public CmdNetworkCreate driver(String driver){
        networkCreate.setDriver(driver);
        return this;
    }

    public CmdNetworkCreate checkDuplicate(boolean checkDuplicate){
        networkCreate.setCheckDuplicate(checkDuplicate);
        return this;
    }

    public CmdNetworkCreate enableIPv6(boolean enableIPv6){
        networkCreate.setEnableIPv6(enableIPv6);
        return this;
    }

    public CmdNetworkCreate label(String key, Object value){
        networkCreate.getLabels().put(key,value);
        return this;
    }

    public CmdNetworkCreate ipamOptions(String key, Object value){
        networkCreate.getIpam().getOptions().put(key,value);
        return this;
    }

    public CmdNetworkCreate options(String key, Object value){
        networkCreate.getOptions().put(key,value);
        return this;
    }

    public CmdNetworkCreate internal(boolean internal  ){
        networkCreate.setInternal(internal);
        return this;
    }

    public CmdNetworkCreate ipamConfig(){
        networkCreate.getIpam().getConfig().add(new IPAMConfig());
        return this;
    }

    public CmdNetworkCreate IPAMConfig(String subnet, String ipRange, String gateway){
        networkCreate.getIpam().getConfig().add(new IPAMConfig(subnet, ipRange, gateway));
        return this;
    }

    public NetworkCreate getEntity(){
        return networkCreate;
    }

    public static CmdNetworkCreate newInstance(){
        return new CmdNetworkCreate();
    }

    @Override
    public String send() throws Exception {
        Result result = getDockerHttpClient().post("/networks/create",getParameters(),networkCreate);
        if(result!=null && result.getStatus()>=300){
            throw new DockerClientException(result.getMessage());
        }else{
            return result.getMessage();
        }

    }
}
