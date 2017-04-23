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
            if(titles.contains("UID")) {
                process.setUser(processArrList.get(i).get(titles.indexOf("UID")).toString());
            }
            if(titles.contains("USER")) {
                process.setUser(processArrList.get(i).get(titles.indexOf("USER")).toString());
            }
            if(titles.contains("PID")) {
                process.setPid(processArrList.get(i).get(titles.indexOf("PID")).toString());
            }
            if(titles.contains("PPID")) {
                process.setPpid(processArrList.get(i).get(titles.indexOf("PPID")).toString());
            }
            if(titles.contains("C")) {
                process.setC(processArrList.get(i).get(titles.indexOf("C")).toString());
            }
            if(titles.contains("STIME")) {
                process.setStime(processArrList.get(i).get(titles.indexOf("STIME")).toString());
            }
            if(titles.contains("TTY")) {
                process.setTty(processArrList.get(i).get(titles.indexOf("TTY")).toString());
            }
            if(titles.contains("TIME")) {
                process.setTime(processArrList.get(i).get(titles.indexOf("TIME")).toString());
            }
            if(titles.contains("CMD")) {
                process.setCommand(processArrList.get(i).get(titles.indexOf("CMD")).toString());
            }
            if(titles.contains("COMMAND")) {
                process.setCommand(processArrList.get(i).get(titles.indexOf("COMMAND")).toString());
            }
            processes.add(process);
        }
        return processes;
    }

}
