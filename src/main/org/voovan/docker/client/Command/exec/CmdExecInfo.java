package org.voovan.docker.client.Command.exec;

import org.voovan.docker.client.Command.Cmd;
import org.voovan.docker.client.network.DockerClientException;
import org.voovan.docker.client.network.Result;
import org.voovan.docker.message.exec.ExecInfo;
import org.voovan.docker.message.exec.ExecStart;

/**
 * 类文字命名
 *
 * @author helyho
 *         <p>
 *         JDocker Framework.
 *         WebSite: https://github.com/helyho/JDocker
 *         Licence: Apache v2 License
 */
public class CmdExecInfo extends Cmd{
    private String execId;

    public CmdExecInfo(String execId) {
        super();
        this.execId = execId;
    }



    public static CmdExecInfo newInstance(String execId){
        return new CmdExecInfo(execId);
    }

    @Override
    public ExecInfo send() throws Exception {
        Result result = getDockerHttpClient().get("/exec/"+execId+"/json", getParameters());
        if(result.getStatus()>=300){
            throw new DockerClientException(result);
        }else{
            return ExecInfo.load(result.getMessage());
        }
    }

}
