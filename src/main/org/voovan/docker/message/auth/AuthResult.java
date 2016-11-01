package org.voovan.docker.message.auth;

import org.voovan.tools.json.JSONPath;

import java.text.ParseException;

/**
 * 类文字命名
 *
 * @author helyho
 *         <p>
 *         JDocker Framework.
 *         WebSite: https://github.com/helyho/JDocker
 *         Licence: Apache v2 License
 */
public class AuthResult {

    private String Status;
    private String identityToken;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getIdentityToken() {
        return identityToken;
    }

    public void setIdentityToken(String identityToken) {
        this.identityToken = identityToken;
    }

    public static AuthResult load(String jsonStr) throws ParseException, ReflectiveOperationException {
        JSONPath jsonPath = new JSONPath(jsonStr);

        return jsonPath.value("/",AuthResult.class);
    }
}
