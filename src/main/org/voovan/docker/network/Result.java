package org.voovan.docker.network;

import org.voovan.http.message.Response;
import org.voovan.tools.json.JSON;

import java.util.Map;

/**
 *
 * @author helyho
 * <p>
 * DockerFly Framework.
 * WebSite: https://git.oschina.net/helyho/JDocker
 * Licence: Apache v2 License
 */
public class Result {
    private int status;
    private String statusCode;
    private String message;

    public Result(int status, String statusCode, String message) {
        this.status = status;
        this.statusCode = statusCode;

        Map<String,String> dockerErrMsg = JSON.toObject(message, Map.class);
        if(dockerErrMsg!=null && dockerErrMsg.containsKey("message")){
            this.message = dockerErrMsg.get("message");
        }else{
            this.message = message;
        }

    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static Result newInstance(Response response) {
        return new Result(response.protocol().getStatus(), response.protocol().getStatusCode(), response.body().getBodyString());
    }

    @Override
    public String toString(){
        return message;
    }

}
