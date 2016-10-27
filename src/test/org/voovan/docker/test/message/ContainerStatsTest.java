package org.voovan.docker.test.message;

import org.voovan.docker.message.container.ContainerStats;
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
public class ContainerStatsTest {
    private static String tmp = "{\n" +
            "  \"read\": \"2016-10-24T12:30:46.784539166Z\",\n" +
            "  \"precpu_stats\": {\n" +
            "    \"cpu_usage\": {\n" +
            "      \"total_usage\": 293457840,\n" +
            "      \"percpu_usage\": [\n" +
            "        111226656,\n" +
            "        182231184\n" +
            "      ],\n" +
            "      \"usage_in_kernelmode\": 190000000,\n" +
            "      \"usage_in_usermode\": 70000000\n" +
            "    },\n" +
            "    \"system_cpu_usage\": 97224770000000,\n" +
            "    \"throttling_data\": {\n" +
            "      \"periods\": 0,\n" +
            "      \"throttled_periods\": 0,\n" +
            "      \"throttled_time\": 0\n" +
            "    }\n" +
            "  },\n" +
            "  \"cpu_stats\": {\n" +
            "    \"cpu_usage\": {\n" +
            "      \"total_usage\": 293457840,\n" +
            "      \"percpu_usage\": [\n" +
            "        111226656,\n" +
            "        182231184\n" +
            "      ],\n" +
            "      \"usage_in_kernelmode\": 190000000,\n" +
            "      \"usage_in_usermode\": 70000000\n" +
            "    },\n" +
            "    \"system_cpu_usage\": 97226750000000,\n" +
            "    \"throttling_data\": {\n" +
            "      \"periods\": 0,\n" +
            "      \"throttled_periods\": 0,\n" +
            "      \"throttled_time\": 0\n" +
            "    }\n" +
            "  },\n" +
            "  \"memory_stats\": {\n" +
            "    \"usage\": 4190208,\n" +
            "    \"max_usage\": 5111808,\n" +
            "    \"stats\": {\n" +
            "      \"active_anon\": 528384,\n" +
            "      \"active_file\": 2723840,\n" +
            "      \"cache\": 3624960,\n" +
            "      \"dirty\": 0,\n" +
            "      \"hierarchical_memory_limit\": 9223372036854771712,\n" +
            "      \"hierarchical_memsw_limit\": 9223372036854771712,\n" +
            "      \"inactive_anon\": 4096,\n" +
            "      \"inactive_file\": 892928,\n" +
            "      \"mapped_file\": 2359296,\n" +
            "      \"pgfault\": 8296,\n" +
            "      \"pgmajfault\": 24,\n" +
            "      \"pgpgin\": 4351,\n" +
            "      \"pgpgout\": 3338,\n" +
            "      \"rss\": 524288,\n" +
            "      \"rss_huge\": 0,\n" +
            "      \"swap\": 0,\n" +
            "      \"total_active_anon\": 528384,\n" +
            "      \"total_active_file\": 2723840,\n" +
            "      \"total_cache\": 3624960,\n" +
            "      \"total_dirty\": 0,\n" +
            "      \"total_inactive_anon\": 4096,\n" +
            "      \"total_inactive_file\": 892928,\n" +
            "      \"total_mapped_file\": 2359296,\n" +
            "      \"total_pgfault\": 8296,\n" +
            "      \"total_pgmajfault\": 24,\n" +
            "      \"total_pgpgin\": 4351,\n" +
            "      \"total_pgpgout\": 3338,\n" +
            "      \"total_rss\": 524288,\n" +
            "      \"total_rss_huge\": 0,\n" +
            "      \"total_swap\": 0,\n" +
            "      \"total_unevictable\": 0,\n" +
            "      \"total_writeback\": 0,\n" +
            "      \"unevictable\": 0,\n" +
            "      \"writeback\": 0\n" +
            "    },\n" +
            "    \"failcnt\": 0,\n" +
            "    \"limit\": 2096566272\n" +
            "  },\n" +
            "  \"blkio_stats\": {\n" +
            "    \"io_service_bytes_recursive\": [\n" +
            "      {\n" +
            "        \"major\": 254,\n" +
            "        \"minor\": 0,\n" +
            "        \"op\": \"Read\",\n" +
            "        \"value\": 3616768\n" +
            "      },\n" +
            "      {\n" +
            "        \"major\": 254,\n" +
            "        \"minor\": 0,\n" +
            "        \"op\": \"Write\",\n" +
            "        \"value\": 0\n" +
            "      },\n" +
            "      {\n" +
            "        \"major\": 254,\n" +
            "        \"minor\": 0,\n" +
            "        \"op\": \"Sync\",\n" +
            "        \"value\": 0\n" +
            "      },\n" +
            "      {\n" +
            "        \"major\": 254,\n" +
            "        \"minor\": 0,\n" +
            "        \"op\": \"Async\",\n" +
            "        \"value\": 3616768\n" +
            "      },\n" +
            "      {\n" +
            "        \"major\": 254,\n" +
            "        \"minor\": 0,\n" +
            "        \"op\": \"Total\",\n" +
            "        \"value\": 3616768\n" +
            "      }\n" +
            "    ],\n" +
            "    \"io_serviced_recursive\": [\n" +
            "      {\n" +
            "        \"major\": 254,\n" +
            "        \"minor\": 0,\n" +
            "        \"op\": \"Read\",\n" +
            "        \"value\": 73\n" +
            "      },\n" +
            "      {\n" +
            "        \"major\": 254,\n" +
            "        \"minor\": 0,\n" +
            "        \"op\": \"Write\",\n" +
            "        \"value\": 0\n" +
            "      },\n" +
            "      {\n" +
            "        \"major\": 254,\n" +
            "        \"minor\": 0,\n" +
            "        \"op\": \"Sync\",\n" +
            "        \"value\": 0\n" +
            "      },\n" +
            "      {\n" +
            "        \"major\": 254,\n" +
            "        \"minor\": 0,\n" +
            "        \"op\": \"Async\",\n" +
            "        \"value\": 73\n" +
            "      },\n" +
            "      {\n" +
            "        \"major\": 254,\n" +
            "        \"minor\": 0,\n" +
            "        \"op\": \"Total\",\n" +
            "        \"value\": 73\n" +
            "      }\n" +
            "    ],\n" +
            "    \"io_queue_recursive\": [],\n" +
            "    \"io_service_time_recursive\": [],\n" +
            "    \"io_wait_time_recursive\": [],\n" +
            "    \"io_merged_recursive\": [],\n" +
            "    \"io_time_recursive\": [],\n" +
            "    \"sectors_recursive\": []\n" +
            "  },\n" +
            "  \"pids_stats\": {\n" +
            "    \"current\": 4\n" +
            "  },\n" +
            "  \"networks\": {\n" +
            "    \"eth0\": {\n" +
            "      \"rx_bytes\": 157144,\n" +
            "      \"rx_packets\": 973,\n" +
            "      \"rx_errors\": 0,\n" +
            "      \"rx_dropped\": 0,\n" +
            "      \"tx_bytes\": 197594,\n" +
            "      \"tx_packets\": 943,\n" +
            "      \"tx_errors\": 0,\n" +
            "      \"tx_dropped\": 0\n" +
            "    }\n" +
            "  }\n" +
            "}";

    public static void main(String[] args) throws ParseException, ReflectiveOperationException {
        ContainerStats containerStats = ContainerStats.load(tmp);

        Logger.simple("-----");

    }
}
