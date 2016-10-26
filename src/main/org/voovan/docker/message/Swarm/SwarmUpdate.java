package org.voovan.docker.message.Swarm;

import org.voovan.docker.message.Swarm.atom.Spec;
import org.voovan.tools.TReflect;
import org.voovan.tools.json.JSON;
import org.voovan.tools.log.Logger;

/**
 * 类文字命名
 *
 * @author helyho
 *         <p>
 *         DockerFly Framework.
 *         WebSite: https://github.com/helyho/DockerFly
 *         Licence: Apache v2 License
 */
public class SwarmUpdate extends Spec{

    public SwarmUpdate(){
        super();
    }

    public static void main(String[] args) throws ReflectiveOperationException {
        SwarmUpdate swarmUpdate = new SwarmUpdate();
        swarmUpdate.setName("UpdatedSwarm");
        Logger.simple(JSON.formatJson(JSON.toJSON(swarmUpdate)));
    }
}
