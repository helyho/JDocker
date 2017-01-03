package org.voovan.docker.message.info.atom;

import java.util.ArrayList;
import java.util.List;

/**
 * 类文字命名
 *
 * @author helyho
 *         <p>
 *         JDocker Framework.
 *         WebSite: https://github.com/helyho/JDocker
 *         Licence: Apache v2 License
 */
public class RegistryConfig {
    private List<String> insecureRegistryCIDRs;
    private List<String> mirrors;

    public RegistryConfig(){
        insecureRegistryCIDRs = new ArrayList<String>();
        mirrors = new ArrayList<String>();
    }

    public List<String> getInsecureRegistryCIDRs() {
        return insecureRegistryCIDRs;
    }

    public void setInsecureRegistryCIDRs(List<String> insecureRegistryCIDRs) {
        this.insecureRegistryCIDRs = insecureRegistryCIDRs;
    }

    public List<String> getMirrors() {
        return mirrors;
    }

    public void setMirrors(List<String> mirrors) {
        this.mirrors = mirrors;
    }
}
