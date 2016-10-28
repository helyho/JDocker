package org.voovan.docker.client.Command.exec;

import org.voovan.docker.client.Command.Cmd;
import org.voovan.docker.client.network.DockerClientException;
import org.voovan.docker.client.network.Result;
import org.voovan.docker.message.container.atom.ContainerUpdate;
import org.voovan.docker.message.exec.ExecCreate;

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
public class CmdExecCreate extends Cmd{
    private ExecCreate execCreate;
    private String nameOrId;

    public CmdExecCreate(String nameOrId) {
        super();
        this.nameOrId = nameOrId;
        execCreate = new ExecCreate();
    }


    public CmdExecCreate cmd(String ... cmd){
        execCreate.getCmd().addAll(Arrays.asList(cmd));
        return this;
    }

    public static CmdExecCreate newInstance(String nameOrId){
        return new CmdExecCreate(nameOrId);
    }

    @Override
    public Result send() throws Exception {
        Result result = getDockerHttpClient().post("/containers/"+nameOrId+"/exec", getParameters(), execCreate);
        if(result.getStatus()>=300){
            throw new DockerClientException(result);
        }else{
            return result;
        }
    }

}
