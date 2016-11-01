package org.voovan.docker.test.message;

import org.voovan.docker.message.swarm.SwarmInfo;
import org.voovan.tools.log.Logger;

import java.text.ParseException;

/**
 *
 * @author helyho
 * <p>
 * DockerFly Framework.
 * WebSite: https://git.oschina.net/helyho/JDocker
 * Licence: Apache v2 License
 */
public class SwarmInfoTest {

    public static String tmp = "{\n" +
            "  \"ID\": \"bcik63bvaii0knq267dtfjmd7\",\n" +
            "  \"Version\": {\n" +
            "    \"Index\": 108652\n" +
            "  },\n" +
            "  \"CreatedAt\": \"2016-10-19T19:00:40.195332844Z\",\n" +
            "  \"UpdatedAt\": \"2016-10-24T10:52:58.001944245Z\",\n" +
            "  \"Spec\": {\n" +
            "    \"Name\": \"default\",\n" +
            "    \"Orchestration\": {},\n" +
            "    \"Raft\": {\n" +
            "      \"SnapshotInterval\": 10000,\n" +
            "      \"LogEntriesForSlowFollowers\": 500,\n" +
            "      \"HeartbeatTick\": 1,\n" +
            "      \"ElectionTick\": 3\n" +
            "    },\n" +
            "    \"Dispatcher\": {\n" +
            "      \"HeartbeatPeriod\": 5000000000\n" +
            "    },\n" +
            "    \"CAConfig\": {\n" +
            "      \"NodeCertExpiry\": 7776000000000000\n" +
            "    },\n" +
            "    \"TaskDefaults\": {}\n" +
            "  },\n" +
            "  \"JoinTokens\": {\n" +
            "    \"Worker\": \"SWMTKN-1-5c69u8yda9efe44qochz3a6mu9qypb9774v4d8teraptjnr07f-6ae6prv9iohuk5uuu9rova3jb\",\n" +
            "    \"Manager\": \"SWMTKN-1-5c69u8yda9efe44qochz3a6mu9qypb9774v4d8teraptjnr07f-8mkije8c7u83q877hlkq9fiyh\"\n" +
            "  }\n" +
            "}";

    public static void main(String[] args) throws ParseException, ReflectiveOperationException {
        SwarmInfo swarmInfo = SwarmInfo.load(tmp);

        Logger.simple("----");

    }
}
