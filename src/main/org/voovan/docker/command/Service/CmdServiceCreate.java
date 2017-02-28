package org.voovan.docker.command.Service;

import org.voovan.docker.command.Cmd;
import org.voovan.docker.message.service.ServiceSpec;
import org.voovan.docker.message.service.atom.Mount;
import org.voovan.docker.message.service.atom.Network;
import org.voovan.docker.message.service.atom.Port;
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
public class CmdServiceCreate extends Cmd {

    private ServiceSpec serviceSpec;

    public CmdServiceCreate() {
        serviceSpec = new ServiceSpec();
    }



    public CmdServiceCreate name(String name){
        serviceSpec.setName(name);
        return this;
    }

    public CmdServiceCreate image(String image){
        serviceSpec.getTaskTemplate().getContainer().setImage(image);
        return this;
    }

    public CmdServiceCreate cmd(String ... cmd){
        serviceSpec.getTaskTemplate().getContainer().getArgs().addAll(TObject.newList(cmd));
        return this;
    }

    public CmdServiceCreate env(String ... env){
        serviceSpec.getTaskTemplate().getContainer().getEnv().addAll(TObject.newList(env));
        return this;
    }

    public CmdServiceCreate stopGracePeriod(long stopGracePeriod){
        serviceSpec.getTaskTemplate().getContainer().setStopGracePeriod(stopGracePeriod);
        return this;
    }


    public CmdServiceCreate cpuLimit(float nanoCpu){
        serviceSpec.getTaskTemplate().getResource().getLimits().setNanoCPUs((long)(nanoCpu*1000000000L));
        return this;
    }

    public CmdServiceCreate memoryLimit(long memoryByte){
        serviceSpec.getTaskTemplate().getResource().getLimits().setMemoryBytes(memoryByte*1024*1024);
        return this;
    }

    public CmdServiceCreate cpuReservation(float nanoCpu){
        serviceSpec.getTaskTemplate().getResource().getReservations().setNanoCPUs((long)(nanoCpu*1000000000L));
        return this;
    }

    public CmdServiceCreate memoryReservation(long memoryByte){
        serviceSpec.getTaskTemplate().getResource().getReservations().setMemoryBytes(memoryByte*1024*1024);
        return this;
    }


    public CmdServiceCreate network(String network){
        serviceSpec.getNetworks().add(new Network(network));
        return this;
    }

    public CmdServiceCreate  port(String protocol, int containerPort, int hostPort){
        serviceSpec.getEndpoint().getPorts().add(new Port(protocol,containerPort,hostPort));
        return this;
    }

    public CmdServiceCreate  portTcp(int containerPort, int hostPort){
        serviceSpec.getEndpoint().getPorts().add(new Port("tcp",containerPort,hostPort));
        return this;
    }

    public CmdServiceCreate  portUdp(int containerPort, int hostPort){
        serviceSpec.getEndpoint().getPorts().add(new Port("udp",containerPort,hostPort));
        return this;
    }


    public CmdServiceCreate mountRead(String source, String target){
        serviceSpec.getTaskTemplate().getContainer().getMounts().add(new Mount(source,target,true));
        return this;
    }

    public CmdServiceCreate mountReadWrite(String source, String target){
        serviceSpec.getTaskTemplate().getContainer().getMounts().add(new Mount(source,target,false));
        return this;
    }

    public CmdServiceCreate mount(String type, String source, String target, boolean readOnly){
        serviceSpec.getTaskTemplate().getContainer().getMounts().add(new Mount(type, source,target,readOnly));
        return this;
    }


    public CmdServiceCreate replicate(int replicas){
        serviceSpec.getMode().getReplicated().setReplicas(replicas);
        return this;
    }

    public CmdServiceCreate label(String key, Object value) {
        serviceSpec.getLabels().put(key, value);
        serviceSpec.getTaskTemplate().getContainer().getLabels().put(key, value);
        return this;
    }

    public CmdServiceCreate restartPolicy(long delay, String condition, int maxAttempts){
        serviceSpec.getTaskTemplate().getRestartPolicy().setDelay(delay);
        serviceSpec.getTaskTemplate().getRestartPolicy().setCondition(condition);
        serviceSpec.getTaskTemplate().getRestartPolicy().setMaxAttempts(maxAttempts);
        return this;
    }

    public CmdServiceCreate updateConfig(long delay, String failureAction, int parallelism){
        serviceSpec.getUpdateConfig().setDelay(delay);
        serviceSpec.getUpdateConfig().setFailureAction(failureAction);
        serviceSpec.getUpdateConfig().setParallelism(parallelism);
        return this;
    }

    //v1.25
    public CmdServiceCreate tty(boolean tty){
        serviceSpec.getTaskTemplate().getContainer().setTty(tty);
        return this;
    }

    //v1.25
    public CmdServiceCreate dnsNameservers(String  nameservers){
        serviceSpec.getTaskTemplate().getContainer().getDnsConfig()
                .getNameservers().addAll(TObject.newList(nameservers));
        return this;
    }

    //v1.25
    public CmdServiceCreate dnsSearch(String  Search){
        serviceSpec.getTaskTemplate().getContainer().getDnsConfig()
                .getNameservers().addAll(TObject.newList(Search));
        return this;
    }

    //v1.25
    public CmdServiceCreate dnsOptions(String  options){
        serviceSpec.getTaskTemplate().getContainer().getDnsConfig()
                .getNameservers().addAll(TObject.newList(options));
        return this;
    }


    public ServiceSpec getEntity(){
        return serviceSpec;
    }

    public static CmdServiceCreate newInstance(){
        return new CmdServiceCreate();
    }

    @Override
    public String send() throws Exception {
        Result result = getDockerHttpClient().run("POST","/services/create",getParameters(),serviceSpec);
        if(result!=null && result.getStatus()>=300){
            throw new DockerClientException(result.getMessage());
        }else{
            return result.getMessage();
        }

    }
}
