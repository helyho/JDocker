package org.voovan.docker.command.Image;

import org.voovan.docker.command.Cmd;
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
    public class CmdImageCreate extends Cmd {


    public CmdImageCreate(){
    }

    public CmdImageCreate fromImage(String fromImage){
        addParameter("fromImage",fromImage);
        return this;
    }

    public CmdImageCreate fromSrc(String fromSrc){
        addParameter("fromSrc",fromSrc);
        return this;
    }

    public CmdImageCreate repo(String repo){
        addParameter("repo",repo);
        return this;
    }

    public CmdImageCreate tag(String tag){
        addParameter("tag",tag);
        return this;
    }

    public static CmdImageCreate newInstance() {
        return new CmdImageCreate();
    }

    @Override
    public String send() throws Exception {
        Result result = getDockerHttpClient().run("POST","/images/create",getParameters());
        if(result!=null && result.getStatus()>=300){
            throw new DockerClientException(result.getMessage());
        } if(result.getMessage().contains("\"errorDetail\"") ) {
            throw new DockerClientException("Pull image error.");
        } else{
            return result.getMessage();
        }

    }
}
