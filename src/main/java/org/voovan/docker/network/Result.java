package org.voovan.docker.network;

import org.voovan.http.message.Response;
import org.voovan.tools.json.JSON;

import java.nio.ByteBuffer;
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
    private String message;
    private Response response;

    public Result(Response response) {
        this.response = response;

        if(this.response==null){
            this.response = new Response();
            this.response.protocol().setStatus(506);
            this.response.protocol().setStatusCode("NULLERROR");
            this.response.body().write("The HTTP response is null, may hava some error.");
        }

        if(this.response.header().contain("Content-Type")
                && !this.response.header().get("Content-Type").contains("application/octet-stream")){
            message = this.response.body().getBodyString();
            Map<String, String> dockerErrMsg = null;
            try {
                dockerErrMsg = JSON.toObject(message, Map.class);
            } catch (Exception e) {
                dockerErrMsg = null;
            }
            if (dockerErrMsg != null && dockerErrMsg.containsKey("message")) {
                this.message = dockerErrMsg.get("message");
            } else {
                this.message = message;
            }
        }
    }

    public int getStatus() {
        return response.protocol().getStatus();
    }

    public String getStatusCode() {
        return  response.protocol().getStatusCode();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ByteBuffer getBufferData(){
        return ByteBuffer.wrap(response.body().getBodyBytes());
    }

    public static Result newInstance(Response response) {
        return new Result(response);
    }

    @Override
    public String toString(){
        return message;
    }

}
