package org.voovan.docker.test.network;

import org.voovan.docker.message.volume.Volume;
import org.voovan.docker.network.DockerHttpClient;
import org.voovan.network.exception.ReadMessageException;
import org.voovan.network.exception.SendMessageException;
import org.voovan.tools.json.JSON;
import org.voovan.tools.log.Logger;

/**
 * 类文字命名
 *
 * @author helyho
 *         <p>
 *         JDocker Framework.
 *         WebSite: https://github.com/helyho/JDocker
 *         Licence: Apache v2 License
 */
public class DockerHttpClientTest {
    public static void main(String[] args) throws SendMessageException, ReadMessageException {
        DockerHttpClient httpClient = new DockerHttpClient("http://127.0.0.1:2735", "UTF-8", 500);
        Logger.info(httpClient.run("GET","/images/json", null).getMessage());
        Logger.info(httpClient.run("GET","/images/dockerfly/history", null).getMessage());
        Logger.info(httpClient.run("DELETE","/containers/sleepy_austin", null).getMessage());

        Volume volume = new Volume();
        volume.setDriver("local");
        volume.setName("v_tx");
        Logger.info(httpClient.run("POST","/volumes/create", null, JSON.toJSON(volume)).getMessage());
        httpClient.close();
    }
}
