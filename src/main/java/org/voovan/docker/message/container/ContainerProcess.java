package org.voovan.docker.message.container;

import org.voovan.docker.message.container.atom.Process;
import org.voovan.tools.json.JSONPath;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
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

        List<String> titles = jsonPath.listObject("/Titles", String.class);
        List<List> processArrList = jsonPath.listObject("/Processes", List.class);
        for (int i = 0; i < processArrList.size(); i++) {
            Process process = new Process();
            process.setUser(processArrList.get(i).get(titles.indexOf("UID")).toString());
            process.setPid(processArrList.get(i).get(titles.indexOf("PID")).toString());
            process.setPpid(processArrList.get(i).get(titles.indexOf("PPID")).toString());
            process.setC(processArrList.get(i).get(titles.indexOf("C")).toString());
            process.setStime(processArrList.get(i).get(titles.indexOf("STIME")).toString());
            process.setTty(processArrList.get(i).get(titles.indexOf("TTY")).toString());
            process.setTime(processArrList.get(i).get(titles.indexOf("TIME")).toString());
            process.setCommand(processArrList.get(i).get(titles.indexOf("CMD")).toString());
            processes.add(process);
        }
        return processes;
    }

}
