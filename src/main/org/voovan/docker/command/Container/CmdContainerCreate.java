package org.voovan.docker.command.Container;

import org.voovan.docker.command.Cmd;
import org.voovan.docker.network.DockerClientException;
import org.voovan.docker.network.Result;
import org.voovan.docker.message.container.ContainerCreate;
import org.voovan.docker.message.container.atom.Device;

import java.util.Arrays;

/**
 * 类文字命名
 *
 * @author helyho
 *         <p>
 *         JDocker Framework.
 *         WebSite: https://github.com/helyho/JDocker
 *         Licence: Apache v2 License
 */
public class CmdContainerCreate extends Cmd{
    private ContainerCreate containerCreate;
    private String name;

    public CmdContainerCreate(String name) {
        super();
        addParameter("name",name);
        containerCreate = new ContainerCreate();
    }

    public CmdContainerCreate hostName(String hostName){
        containerCreate.setHostName(hostName);
        return this;
    }

    public CmdContainerCreate domainName(String domainName){
        containerCreate.setDomainName(domainName);
        return this;
    }

    public CmdContainerCreate publishAllPorts(boolean publishAllPorts){
        containerCreate.getHostConfig().setPublishAllPorts(publishAllPorts);
        return this;
    }

    public CmdContainerCreate privileged(boolean privileged){
        containerCreate.getHostConfig().setPrivileged(privileged);
        return this;
    }

    public CmdContainerCreate user(String user){
        containerCreate.setUser(user);
        return this;
    }

    public CmdContainerCreate image(String image){
        containerCreate.setImage(image);
        return this;
    }


    public CmdContainerCreate cmd(String ... cmds){
        containerCreate.getCmd().addAll(Arrays.asList(cmds));
        return this;
    }


    public CmdContainerCreate env(String ... envs){
        containerCreate.getEnv().addAll(Arrays.asList(envs));
        return this;
    }

    public CmdContainerCreate cpuQuota(int cpuQuota){
        containerCreate.getHostConfig().setCpuQuota(cpuQuota);
        return this;
    }

    public CmdContainerCreate cpuPeriod(int cpuPeriod){
        containerCreate.getHostConfig().setCpuPeriod(cpuPeriod);
        return this;
    }

    public CmdContainerCreate memory(int memory){
        containerCreate.getHostConfig().setMemory(memory*1024L*1024L);
        return this;
    }

    public CmdContainerCreate network(String network){
        containerCreate.getHostConfig().setNetworkMode(network);
        return this;
    }

    public CmdContainerCreate label(String key, Object value) {
        containerCreate.getLabels().put(key, value);
        return this;
    }

    public CmdContainerCreate dns(String dnses){
        containerCreate.getHostConfig().getDns().addAll(Arrays.asList(dnses));
        return this;
    }

    public CmdContainerCreate device(String pathOnHost,String pathInContainer,String cgroupPermissions){
        containerCreate.getHostConfig().getDevices().add(new Device(pathOnHost,pathInContainer,cgroupPermissions));
        return this;
    }

    public CmdContainerCreate volume(String ... bind){
        containerCreate.getHostConfig().getBinds().addAll(Arrays.asList(bind));
        return this;
    }

    public CmdContainerCreate volumeFrom(String ... volumeFroms){
        containerCreate.getHostConfig().getVolumesFrom().addAll(Arrays.asList(volumeFroms));
        return this;
    }

    public CmdContainerCreate link(String ... link){
        containerCreate.getHostConfig().getLinks().addAll(Arrays.asList(link));
        return this;
    }

    public CmdContainerCreate exposePort(int containerPort, String protocol, String... hostPortStrs){
        containerCreate.addPortBind(containerPort,protocol,hostPortStrs);
        return this;
    }

    public static CmdContainerCreate newInstance(String name){
        return new CmdContainerCreate(name);
    }

    @Override
    public Result send() throws Exception {
        Result result = getDockerHttpClient().post("/containers/create", getParameters(), containerCreate);
        if(result.getStatus()>=300){
            throw new DockerClientException(result);
        }else{
            return result;
        }
    }

}
