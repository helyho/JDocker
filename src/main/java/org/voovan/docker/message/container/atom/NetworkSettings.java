package org.voovan.docker.message.container.atom;

import java.util.Map;

/**
 * 类文字命名
 *
 * @author helyho
 *         <p>
 *         JDocker Framework.
 *         WebSite: https://github.com/helyho/JDocker
 *         Licence: Apache v2 License
 */
public class NetworkSettings {
    private String bridge;
    private String sandboxID;
    private Boolean hairpinMode;
    private String linkLocalIPv6Address;
    private Integer linkLocalIPv6PrefixLen;
    private String ports;
    private String sandboxKey;
    private String secondaryIPAddresses;
    private String secondaryIPv6Addresses;
    private String endpointID;
    private String gateway;
    private String globalIPv6Address;
    private Integer globalIPv6PrefixLen;
    private String iPAddress;
    private Integer iPPrefixLen;
    private String iPv6Gateway;
    private String macAddress;
    private Map<String,Network> networks;

    public NetworkSettings() {
        bridge = null;
        sandboxID = null;
        hairpinMode = null;
        linkLocalIPv6Address = null;
        linkLocalIPv6PrefixLen = null;
        ports = null;
        sandboxKey = null;
        secondaryIPAddresses = null;
        secondaryIPv6Addresses = null;
        endpointID = null;
        gateway = null;
        globalIPv6Address = null;
        globalIPv6PrefixLen = null;
        iPAddress = null;
        iPPrefixLen = null;
        iPv6Gateway = null;
        macAddress = null;
    }

    public String getBridge() {
        return bridge;
    }

    public void setBridge(String bridge) {
        this.bridge = bridge;
    }

    public String getSandboxID() {
        return sandboxID;
    }

    public void setSandboxID(String sandboxID) {
        this.sandboxID = sandboxID;
    }

    public Boolean getHairpinMode() {
        return hairpinMode;
    }

    public void setHairpinMode(Boolean hairpinMode) {
        this.hairpinMode = hairpinMode;
    }

    public String getLinkLocalIPv6Address() {
        return linkLocalIPv6Address;
    }

    public void setLinkLocalIPv6Address(String linkLocalIPv6Address) {
        this.linkLocalIPv6Address = linkLocalIPv6Address;
    }

    public Integer getLinkLocalIPv6PrefixLen() {
        return linkLocalIPv6PrefixLen;
    }

    public void setLinkLocalIPv6PrefixLen(Integer linkLocalIPv6PrefixLen) {
        this.linkLocalIPv6PrefixLen = linkLocalIPv6PrefixLen;
    }

    public String getPorts() {
        return ports;
    }

    public void setPorts(String ports) {
        this.ports = ports;
    }

    public String getSandboxKey() {
        return sandboxKey;
    }

    public void setSandboxKey(String sandboxKey) {
        this.sandboxKey = sandboxKey;
    }

    public String getSecondaryIPAddresses() {
        return secondaryIPAddresses;
    }

    public void setSecondaryIPAddresses(String secondaryIPAddresses) {
        this.secondaryIPAddresses = secondaryIPAddresses;
    }

    public String getSecondaryIPv6Addresses() {
        return secondaryIPv6Addresses;
    }

    public void setSecondaryIPv6Addresses(String secondaryIPv6Addresses) {
        this.secondaryIPv6Addresses = secondaryIPv6Addresses;
    }

    public String getEndpointID() {
        return endpointID;
    }

    public void setEndpointID(String endpointID) {
        this.endpointID = endpointID;
    }

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    public String getGlobalIPv6Address() {
        return globalIPv6Address;
    }

    public void setGlobalIPv6Address(String globalIPv6Address) {
        this.globalIPv6Address = globalIPv6Address;
    }

    public Integer getGlobalIPv6PrefixLen() {
        return globalIPv6PrefixLen;
    }

    public void setGlobalIPv6PrefixLen(Integer globalIPv6PrefixLen) {
        this.globalIPv6PrefixLen = globalIPv6PrefixLen;
    }

    public String getiPAddress() {
        return iPAddress;
    }

    public void setiPAddress(String iPAddress) {
        this.iPAddress = iPAddress;
    }

    public Integer getiPPrefixLen() {
        return iPPrefixLen;
    }

    public void setiPPrefixLen(Integer iPPrefixLen) {
        this.iPPrefixLen = iPPrefixLen;
    }

    public String getiPv6Gateway() {
        return iPv6Gateway;
    }

    public void setiPv6Gateway(String iPv6Gateway) {
        this.iPv6Gateway = iPv6Gateway;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public Map<String, Network> getNetworks() {
        return networks;
    }

    public void setNetworks(Map<String, Network> networks) {
        this.networks = networks;
    }
}
