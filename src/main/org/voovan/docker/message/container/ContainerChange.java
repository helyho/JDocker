package org.voovan.docker.message.container;

import org.voovan.docker.message.container.atom.ChangeItem;
import org.voovan.tools.json.JSONPath;

import java.text.ParseException;
import java.util.List;

/**
 * 类文字命名
 *
 * @author helyho
 *         <p>
 *         DockerFly Framework.
 *         WebSite: https://github.com/helyho/DockerFly
 *         Licence: Apache v2 License
 */
public class ContainerChange {

    public static List<ChangeItem> load(String jsonStr) throws ParseException, ReflectiveOperationException {
        JSONPath jsonPath = JSONPath.newInstance(jsonStr);

        return jsonPath.listObject("/",ChangeItem.class);
    }

}
