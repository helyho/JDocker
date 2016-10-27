package org.voovan.docker.message.container;

import org.voovan.docker.message.container.atom.Process;
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
public class ContainerProcess {

    public static List<Process> load(String jsonStr) throws ParseException, ReflectiveOperationException {
        ArrayList<Process> processes = new ArrayList<Process>();
        JSONPath jsonPath = JSONPath.newInstance(jsonStr);
        for (int i = 0; i < jsonPath.value("/Processes", List.class).size(); i++) {
            Process process = new Process();
            process.setPid(jsonPath.value("/Processes[" + i + "][0]", String.class));
            process.setUser(jsonPath.value("/Processes[" + i + "][1]", String.class));
            process.setTime(jsonPath.value("/Processes[" + i + "][2]", String.class));
            process.setCommand(jsonPath.value("/Processes[" + i + "][3]", String.class));
            processes.add(process);
        }
        return processes;
    }

}
