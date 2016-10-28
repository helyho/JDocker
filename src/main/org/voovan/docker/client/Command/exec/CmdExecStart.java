package org.voovan.docker.client.Command.exec;

import org.voovan.docker.client.Command.Cmd;
import org.voovan.docker.client.network.DockerClientException;
import org.voovan.docker.client.network.Result;
import org.voovan.docker.message.exec.ExecCreate;
import org.voovan.docker.message.exec.ExecStart;

import java.io.IOException;
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
public class CmdExecStart extends Cmd{
    private ExecStart execStart;
    private String execId;

    public CmdExecStart(String execId) {
        super();
        this.execId = execId;
        execStart = new ExecStart();
    }



    public static CmdExecStart newInstance(String nameOrId){
        return new CmdExecStart(nameOrId);
    }

    @Override
    public Result send() throws Exception {
        Result result = getDockerHttpClient().post("/exec/"+execId+"/start", getParameters(), execStart);
        if(result.getStatus()>=300){
            throw new DockerClientException(result);
        }else{
            return result;
        }
    }
}
