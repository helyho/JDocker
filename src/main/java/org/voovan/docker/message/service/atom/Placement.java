package org.voovan.docker.message.service.atom;

import java.util.ArrayList;
import java.util.List;

/**
 * 类文字命名
 *
 * @author: helyho
 * JDocker Framework.
 * WebSite: https://github.com/helyho/JDocker
 * Licence: Apache v2 License
 */
public class Placement {
    private List<String> constraints;

    public Placement(){
        constraints = new ArrayList<String>();
    }

    public List<String> getConstraints() {
        return constraints;
    }

    public void setConstraints(List<String> constraints) {
        this.constraints = constraints;
    }
}
