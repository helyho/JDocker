package org.voovan.docker.command.Container;

import org.voovan.docker.command.Cmd;
import org.voovan.docker.message.container.ContainerCreate;
import org.voovan.docker.message.container.atom.BlockIORate;
import org.voovan.docker.message.container.atom.Device;
import org.voovan.docker.message.container.atom.ULimit;
import org.voovan.docker.message.service.atom.Mount;
import org.voovan.docker.network.DockerClientException;
import org.voovan.docker.network.Result;

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

    public CmdContainerCreate cpu(float cpuQuota){
        containerCreate.getHostConfig().setCpuQuota((int)(cpuQuota * containerCreate.getHostConfig().getCpuPeriod()));
        return this;
    }

    public CmdContainerCreate memory(int memory){
        containerCreate.getHostConfig().setMemory(memory*1024L*1024L);
        return this;
    }

    public CmdContainerCreate blkioWeight(int rate){
        containerCreate.getHostConfig().setBlkioWeight(rate);
        return this;
    }

    public CmdContainerCreate blkioWeightDevice(String path, int rate){
        containerCreate.getHostConfig().getBlkioWeightDevice().add(new BlockIORate(path,rate));
        return this;
    }

    public CmdContainerCreate blkioDeviceReadBps(String path, int rate){
        containerCreate.getHostConfig().getBlkioWeightDevice().add(new BlockIORate(path,rate));
        return this;
    }

    public CmdContainerCreate blkioDeviceWriteBps(String path, int rate){
        containerCreate.getHostConfig().getBlkioWeightDevice().add(new BlockIORate(path,rate));
        return this;
    }

    public CmdContainerCreate blkioDeviceReadIOps(String path, int rate){
        containerCreate.getHostConfig().getBlkioWeightDevice().add(new BlockIORate(path,rate));
        return this;
    }

    public CmdContainerCreate blkioDeviceWiiteIOps(String path, int rate){
        containerCreate.getHostConfig().getBlkioWeightDevice().add(new BlockIORate(path,rate));
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

    public CmdContainerCreate dns(String ...dnses){
        containerCreate.getHostConfig().getDns().addAll(Arrays.asList(dnses));
        return this;
    }

    public CmdContainerCreate device(String pathOnHost,String pathInContainer,String cgroupPermissions){
        containerCreate.getHostConfig().getDevices().add(new Device(pathOnHost,pathInContainer,cgroupPermissions));
        return this;
    }

    public CmdContainerCreate bind(String ... bind){
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

    public CmdContainerCreate exposePort(String protocol, int containerPort, String... hostPortStrs){
        containerCreate.addPortBind(containerPort,protocol,hostPortStrs);
        return this;
    }

    public CmdContainerCreate publishAllPorts(boolean publishAllPorts){
        containerCreate.getHostConfig().setPublishAllPorts(publishAllPorts);
        return this;
    }

    public CmdContainerCreate uLimit(String name, int soft, int hard){
        containerCreate.getHostConfig().getUlimits().add(new ULimit(name,soft,hard));
        return this;
    }

    //v1.25
    public CmdContainerCreate mountRead(String source, String target){
        containerCreate.getHostConfig().getMounts().add(new Mount(source,target,true));
        return this;
    }

    //v1.25
    public CmdContainerCreate mountReadWrite(String source, String target){
        containerCreate.getHostConfig().getMounts().add(new Mount(source,target,false));
        return this;
    }

    //v1.25
    public CmdContainerCreate mount(String type, String source, String target, boolean readOnly){
        containerCreate.getHostConfig().getMounts().add(new Mount(type, source,target,readOnly));
        return this;
    }

    //v1.25
    public CmdContainerCreate autoRemove(boolean autoRemove){
        containerCreate.getHostConfig().setAutoRemove(autoRemove);
        return this;
    }

    //v1.25
    public CmdContainerCreate nanoCpus(long nanoCpus){
        containerCreate.getHostConfig().setNanoCPUs(nanoCpus);
        return this;
    }

    //v1.25
    public CmdContainerCreate stopTimeout(int stopTimeout){
        containerCreate.setStopTimeout(stopTimeout);
        return this;
    }

    public ContainerCreate getEntity(){
        return containerCreate;
    }

    public static CmdContainerCreate newInstance(String name){
        return new CmdContainerCreate(name);
    }

    @Override
    public String send() throws Exception {
        Result result = getDockerHttpClient().post("/containers/create", getParameters(), containerCreate);
        if(result!=null && result.getStatus()>=300){
            throw new DockerClientException(result.getMessage());
        }else{
            return result.getMessage();
        }
    }

}
