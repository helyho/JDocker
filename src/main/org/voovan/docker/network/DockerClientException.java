package org.voovan.docker.network;

/**
 * 类文字命名
 *
 * @author helyho
 *         <p>
 *         JDocker Framework.
 *         WebSite: https://github.com/helyho/JDocker
 *         Licence: Apache v2 License
 */
public class DockerClientException extends Exception {

    private Result result;

    public DockerClientException(Result result) {
        super(result.toString());
        this.result = result;
    }

    public DockerClientException(String message){
        super(message);
    }

    public DockerClientException(Exception e){
        this.setStackTrace(e.getStackTrace());
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
