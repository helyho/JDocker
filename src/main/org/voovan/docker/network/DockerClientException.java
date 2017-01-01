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

    public DockerClientException(String message) {
        super(message);
    }

    public DockerClientException(Exception e) {
        this.setStackTrace(e.getStackTrace());
    }
}

