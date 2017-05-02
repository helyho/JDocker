package org.voovan.docker.message.service.atom.mode;

import org.voovan.tools.json.annotation.NotJSON;

/**
 *
 * @author helyho
 * <p>
 * DockerFly Framework.
 * WebSite: https://git.oschina.net/helyho/JDocker
 * Licence: Apache v2 License
 */
public class Mode {
    @NotJSON
    private String type;
    private Replicated replicated;
    private Global global;
    public Mode() {
        replicated = new Replicated();
        global = null;
        type = "replicated";
    }

    public Replicated getReplicated() {
        return replicated;
    }

    public void setReplicated(Replicated replicated) {
        this.replicated = replicated;
    }

    public void setType(String type){
        this.type = type;
        if("replicated".equals(type)){
            replicated = new Replicated();
            global = null;
        }else if("global".equals(type)){
            replicated = null;
            global = new Global();
        }
    }

    public String getType(){
        return type;
    }

    public boolean isGlobal(){
        if("Global".equals(type)){
            return true;
        }else{
            return false;
        }
    }

    public boolean isReplicated(){
        if("replicated".equals(type)){
            return true;
        }else{
            return false;
        }
    }
}
