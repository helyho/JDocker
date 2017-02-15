package org.voovan.docker.command.Auth;

import org.voovan.docker.DockerGlobal;
import org.voovan.docker.command.Cmd;
import org.voovan.docker.message.auth.AuthRequest;
import org.voovan.docker.message.auth.AuthResult;
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
public class CmdAuth extends Cmd{
    private AuthRequest authRequest;

    public CmdAuth() {
        super();
        this.authRequest = new AuthRequest();
    }

    public CmdAuth serveraddress(String serveraddress){
        authRequest.setServeraddress(serveraddress);
        return this;
    }

    public CmdAuth username(String username){
        authRequest.setUsername(username);
        return this;
    }

    public CmdAuth password(String password){
        authRequest.setPassword(password);
        return this;
    }


    public static CmdAuth newInstance(){
        return new CmdAuth();
    }

    public AuthRequest getEntity(){
        return authRequest;
    }

    @Override
    public AuthResult send() throws Exception {
        Result result = getDockerHttpClient().post("/auth", getParameters(),authRequest);
        if(result!=null && result.getStatus()>=300){
            throw new DockerClientException(result.getMessage());
        }else{
            DockerGlobal.DOCKER_AUTH_RESULT = AuthResult.load(result.getMessage());
            return DockerGlobal.DOCKER_AUTH_RESULT;
        }
    }

}
