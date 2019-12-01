package com.mit.sample;

import com.vaadin.data.provider.ListDataProvider;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoadData {

    public List<ServerDetailsNew> load() throws SQLException {
       List<ServerDetailsNew> serverDetailsListNew = new ArrayList<ServerDetailsNew>();

        //JDBCConnection jdbcConnection = new JDBCConnection();
        // Connection conn = jdbcConnection.connectDB();
        SQLQueries sqlQueries = new SQLQueries();
        ResultSet rs = sqlQueries.selectSeverData();

        while (rs.next()) {
            String ip = rs.getString(1);
            String type = rs.getString(2);
            double mem = rs.getDouble(3);
            double root = rs.getDouble(4);
            double x01 = rs.getDouble(5);
            double x02 = rs.getDouble(6);
            double load = rs.getDouble(7);
            String status = rs.getString(11);
            String hostname = rs.getString(9);
            String pt_tomcat_deployment_status = rs.getString(10);
            ServerDetailsNew sd = new ServerDetailsNew();


            sd.setIp(ip);
            sd.setServer_type(type);
            sd.setServer_memory_used(mem);
            sd.setDisk_used_root(root);
            sd.setDisk_used_part1(x01);
            sd.setDisk_used_part2(x02);
            sd.setServer_load_local(load);
            sd.setServer_ststus(status);
            sd.setHostname(hostname);
            sd.setPt_tomcat_deployment_status(pt_tomcat_deployment_status);
            serverDetailsListNew.add(sd);
        }
        return serverDetailsListNew;


    }

    public List<ServerDetailsNew> loadSingle(String SRV_HOSTNAME) throws SQLException {
        List<ServerDetailsNew> serverDetailsListNew = new ArrayList<ServerDetailsNew>();

        //JDBCConnection jdbcConnection = new JDBCConnection();
        // Connection conn = jdbcConnection.connectDB();
        SQLQueries sqlQueries = new SQLQueries();
        ResultSet rs = sqlQueries.selectSingleSeverData(SRV_HOSTNAME);

        while (rs.next()) {
            String ip = rs.getString(1);
            String type = rs.getString(2);
            double mem = rs.getDouble(3);
            double root = rs.getDouble(4);
            double x01 = rs.getDouble(5);
            double x02 = rs.getDouble(6);
            double load = rs.getDouble(7);
            String status = rs.getString(8);
            String hostname = rs.getString(9);
            String pt_tomcat_deployment_status = rs.getString(10);
            ServerDetailsNew sd = new ServerDetailsNew();


            sd.setIp(ip);
            sd.setServer_type(type);
            sd.setServer_memory_used(mem);
            sd.setDisk_used_root(root);
            sd.setDisk_used_part1(x01);
            sd.setDisk_used_part2(x02);
            sd.setServer_load_local(load);
            sd.setServer_ststus(status);
            sd.setHostname(hostname);
            sd.setPt_tomcat_deployment_status(pt_tomcat_deployment_status);
            serverDetailsListNew.add(sd);
        }
        return serverDetailsListNew;


    }

}
