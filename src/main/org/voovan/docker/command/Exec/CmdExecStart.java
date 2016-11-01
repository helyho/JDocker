package org.voovan.docker.command.Exec;

import org.voovan.docker.command.Cmd;
import org.voovan.docker.network.DockerClientException;
import org.voovan.docker.network.Result;
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
        Result result = getDockerHttpClient().post("/Exec/"+execId+"/start", getParameters(), execStart);
        if(result.getStatus()>=300){
            throw new DockerClientException(result);
        }else{
            return result;
        }
    }
}