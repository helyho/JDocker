package org.voovan.docker.message.info.atom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private Map<String,IndexConfig> indexConfigs;

    public RegistryConfig(){
        insecureRegistryCIDRs = new ArrayList<String>();
        mirrors = new ArrayList<String>();
        indexConfigs = new HashMap<String,IndexConfig>();
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

    public Map<String, IndexConfig> getIndexConfigs() {
        return indexConfigs;
    }

    public void setIndexConfigs(Map<String, IndexConfig> indexConfigs) {
        this.indexConfigs = indexConfigs;
    }
}
