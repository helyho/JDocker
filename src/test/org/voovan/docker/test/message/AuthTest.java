package org.voovan.docker.test.message;

import org.voovan.docker.message.auth.AuthResult;
import org.voovan.docker.message.node.NodeInfo;
import org.voovan.tools.log.Logger;

import java.text.ParseException;
import java.util.List;

/**
 *
 * @author helyho
 * <p>
 * DockerFly Framework.
 * WebSite: https://git.oschina.net/helyho/JDocker
 * Licence: Apache v2 License
 */
public class AuthTest {
    public static String tmp = "{\n" +
            "     \"Status\": \"Login Succeeded\",\n" +
            "     \"IdentityToken\": \"9cbaf023786cd7...\"\n" +
            "}";


    public static void main(String[] args) throws ParseException, ReflectiveOperationException {
        AuthResult authResult = AuthResult.load(tmp);
        Logger.simple("11111");
    }
}
