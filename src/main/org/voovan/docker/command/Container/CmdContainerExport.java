package org.voovan.docker.command.Container;

import org.voovan.docker.command.Cmd;
import org.voovan.docker.message.container.atom.HostConfig;
import org.voovan.docker.network.DockerClientException;
import org.voovan.docker.network.Result;

import java.nio.ByteBuffer;

/**
 * 类文字命名
 *
 * @author helyho
 *         <p>
 *         JDocker Framework.
 *         WebSite: https://github.com/helyho/JDocker
 *         Licence: Apache v2 License
 */
public class CmdContainerExport extends Cmd{
    private String nameOrId;

    public CmdContainerExport(String nameOrId) {
        super();
        this.nameOrId = nameOrId;
    }


    public static CmdContainerExport newInstance(String nameOrId){
        return new CmdContainerExport(nameOrId);
    }

    @Override
    public ByteBuffer send() throws Exception {
        Result result = getDockerHttpClient().get("/containers/"+nameOrId+"/export", getParameters());
        if(result!=null && result.getStatus()>=300){
            throw new DockerClientException(result.getMessage());
        }else{
            return result.getBufferData();
        }
    }

}
