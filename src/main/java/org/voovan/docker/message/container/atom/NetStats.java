package org.voovan.docker.message.container.atom;

/**
 * 类文字命名
 *
 * @author helyho
 *         <p>
 *         JDocker Framework.
 *         WebSite: https://github.com/helyho/JDocker
 *         Licence: Apache v2 License
 */
public class NetStats {
    private Long netRxBytes;
    private Long netRxPackets;
    private Long netRxErros;
    private Long netRxDrops;
    private Long netTxBytes;
    private Long netTxPackets;
    private Long netTxErros;
    private Long netTxDrops;

    public Long getNetRxBytes() {
        return netRxBytes;
    }

    public void setNetRxBytes(Long netRxBytes) {
        this.netRxBytes = netRxBytes;
    }

    public Long getNetRxPackets() {
        return netRxPackets;
    }

    public void setNetRxPackets(Long netRxPackets) {
        this.netRxPackets = netRxPackets;
    }

    public Long getNetRxErros() {
        return netRxErros;
    }

    public void setNetRxErros(Long netRxErros) {
        this.netRxErros = netRxErros;
    }

    public Long getNetRxDrops() {
        return netRxDrops;
    }

    public void setNetRxDrops(Long netRxDrops) {
        this.netRxDrops = netRxDrops;
    }

    public Long getNetTxBytes() {
        return netTxBytes;
    }

    public void setNetTxBytes(Long netTxBytes) {
        this.netTxBytes = netTxBytes;
    }

    public Long getNetTxPackets() {
        return netTxPackets;
    }

    public void setNetTxPackets(Long netTxPackets) {
        this.netTxPackets = netTxPackets;
    }

    public Long getNetTxErros() {
        return netTxErros;
    }

    public void setNetTxErros(Long netTxErros) {
        this.netTxErros = netTxErros;
    }

    public Long getNetTxDrops() {
        return netTxDrops;
    }

    public void setNetTxDrops(Long netTxDrops) {
        this.netTxDrops = netTxDrops;
    }
}
