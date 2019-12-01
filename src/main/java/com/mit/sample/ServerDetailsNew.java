package com.mit.sample;

public class ServerDetailsNew {

    private String ip = null;
    private String server_type = null;
    private double server_memory_used = 0;
    private double disk_used_root = 0;
    private double disk_used_part1 = 0;
    private double disk_used_part2 = 0;
    private double server_load_local = 0;

    public String getPt_tomcat_deployment_status() {
        return pt_tomcat_deployment_status;
    }

    public void setPt_tomcat_deployment_status(String pt_tomcat_deployment_status) {
        this.pt_tomcat_deployment_status = pt_tomcat_deployment_status;
    }

    private String pt_tomcat_deployment_status= null;

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    private String hostname = null;

    public String getServer_ststus() {
        return server_ststus;
    }

    public void setServer_ststus(String server_ststus) {
        this.server_ststus = server_ststus;
    }

    private String server_ststus = null;
    public ServerDetailsNew(String ip) {
        this.ip = ip;
    }

    public ServerDetailsNew() {
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getServer_type() {
        return server_type;
    }

    public void setServer_type(String server_type) {
        this.server_type = server_type;
    }

    public double getServer_memory_used() {
        return server_memory_used;
    }

    public void setServer_memory_used(double server_memory_used) {
        this.server_memory_used = server_memory_used;
    }

    public double getDisk_used_root() {
        return disk_used_root;
    }

    public void setDisk_used_root(double disk_used_root) {
        this.disk_used_root = disk_used_root;
    }

    public double getDisk_used_part1() {
        return disk_used_part1;
    }

    public void setDisk_used_part1(double disk_used_part1) {
        this.disk_used_part1 = disk_used_part1;
    }

    public double getDisk_used_part2() {
        return disk_used_part2;
    }

    public void setDisk_used_part2(double disk_used_part2) {
        this.disk_used_part2 = disk_used_part2;
    }

    public double getServer_load_local() {
        return server_load_local;
    }

    public void setServer_load_local(double server_load_local) {
        this.server_load_local = server_load_local;
    }


}
