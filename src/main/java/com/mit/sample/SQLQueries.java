package com.mit.sample;

import com.mit.sample.JDBCConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLQueries {

    JDBCConnection jdbcConnection = new JDBCConnection();

    Connection conn = jdbcConnection.connectDB();


    public void insertData(String SRV_IP, String SRV_TYPE, double SRV_MEM_USAGE, double SRV_DISK_USAGE_ROOT, double SRV_DISK_USAGE_PART1, double SRV_DISK_USAGE_PART2, double SRV_CPU_LOAD, String project) {

        Statement stmt = null;

        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sql = "INSERT INTO PT_SRV_USAGE " + "VALUES ('" + SRV_IP + "','" + SRV_TYPE + "','" + SRV_MEM_USAGE + "','" + SRV_DISK_USAGE_ROOT + "','" + SRV_DISK_USAGE_PART1 + "','" + SRV_DISK_USAGE_PART2 + "','" + SRV_CPU_LOAD + "','" + project + "')";
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateData(String SRV_IP, String SRV_TYPE, double SRV_MEM_USAGE, double SRV_DISK_USAGE_ROOT, double SRV_DISK_USAGE_PART1, double SRV_DISK_USAGE_PART2, double SRV_CPU_LOAD, String project) {

        Statement stmt = null;

        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sql = "UPDATE  PT_SRV_USAGE SET SRV_TYPE='" + SRV_TYPE + "',SRV_MEM_USAGE='" + SRV_MEM_USAGE + "',SRV_DISK_USAGE_ROOT='" + SRV_DISK_USAGE_ROOT + "',SRV_DISK_USAGE_PART1='" + SRV_DISK_USAGE_PART1 + "',SRV_DISK_USAGE_PART2='" + SRV_DISK_USAGE_PART2 + "',SRV_CPU_LOAD='" + SRV_CPU_LOAD + "',PROJECT='" + project + "' WHERE SRV_IP='" + SRV_IP + "'";
        System.out.println(sql);
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public ResultSet selectSeverData() throws SQLException {
        Statement stmt = null;
        ResultSet results = null;
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sql = "select * from PT_SRV_USAGE ";
        try {
            results = stmt.executeQuery(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(results.getRow());
        return results;

    }


    public ResultSet selectSingleSeverData(String SRV_HOSTNAME) throws SQLException {
        Statement stmt = null;
        ResultSet results = null;
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sql = "select * from PT_SRV_USAGE WHERE SRV_HOSTNAME like '%"+ SRV_HOSTNAME_HOSTNAME +"%'";

        System.out.println(sql);
        try {
            results = stmt.executeQuery(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(results.getRow());
        return results;

    }


}
