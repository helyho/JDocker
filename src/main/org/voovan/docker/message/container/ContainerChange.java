package org.voovan.docker.message.container;

import org.voovan.docker.message.container.atom.ChangeItem;
import org.voovan.tools.json.JSONPath;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author helyho
 * <p>
 * DockerFly Framework.
 * WebSite: https://git.oschina.net/helyho/JDocker
 * Licence: Apache v2 License
 */
public class ContainerChange {

    public static List<ChangeItem> load(String jsonStr) throws ParseException, ReflectiveOperationException {
        JSONPath jsonPath = JSONPath.newInstance(jsonStr);

        List<ChangeItem> changeItems = jsonPath.value("/", List.class, new ArrayList<ChangeItem>());
        return changeItems;
    }

}
