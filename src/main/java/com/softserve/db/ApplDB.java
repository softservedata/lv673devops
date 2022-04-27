package com.softserve.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ApplDB {
    // Microsoft
    // private static String URL =
    // "jdbc:sqlserver://CLASS02.training.local\\SQLEXPRESS";
    // private static String URL =
    // "jdbc:sqlserver://CLASS02.training.local\\SQLEXPRESS;databasename=lv304test;";
    //
    // Sybase
    //// private static String URL =
    // "jdbc:jtds:sqlserver://CLASS02/lv304test;instance=SQLEXPRESS;";
    // private static String URL =
    // "jdbc:jtds:sqlserver://ssu-sql12/ssu-oms;instance=tc;"; // port=1433
//  private static String URL ="jdbc:jtds:sqlserver://ssu-sql12/ssu-oms;instance=tc;";
//  private static String URL ="jdbc:jtds:sqlserver://ssu-oms/_067_OMS1;instance=SQLEXPRESS;"; // 192.168.195.239
    //private static String URL = "jdbc:jtds:sqlserver://192.168.195.146/Oms;instance=SSU-SQL;"; // 192.168.195.239
    //
    // MySQL
    // private static String URL = "jdbc:mysql://localhost:3306/lv326";
    // private static String URL = "jdbc:mysql://localhost:3306/lv304test";
     // private static String URL = "jdbc:mysql://192.168.103.191:3306/opencart";
    //
    // PostgresSQL
    // private static String URL =
    // "jdbc:postgresql://192.168.195.250:5432/registrator_db";

    private static Connection con = null;
    private static String username = "pmp3132";
    private static String password = "Pmp-31-32uni";
    private static String URL = "jdbc:mysql://192.168.198.128:3306/lv673";

    public static void main(String[] args) throws SQLException {
        System.out.println("Start...");
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        con = DriverManager.getConnection(URL, username, password);
        if (con != null) {
            System.out.println("Connection Successful! \n");
        } else {
            System.out.println("Connection ERROR \n");
            System.exit(1);
        }
        Statement st = con.createStatement();
        System.out.println("con.getAutoCommit() = " + con.getAutoCommit());
        /*-
        st.execute("CREATE DATABASE lv673;");
        st.execute("use lv673");
        String query = "CREATE TABLE temp "
        	+ "( id int unsigned not null auto_increment primary key, "
        	+ "name varchar(20), "
        	+ "login varchar(20), "
        	+ "password varchar(30), "
        	+ "age int );";
        st.execute(query);
        query = "INSERT INTO temp (name,login,password,age) VALUES ('Ivan','iva','qwerty',21);";
        st.execute(query);
        */
        //
        // String query = "INSERT INTO temp (name,login,password,age) VALUES ('Ivan','iva','qwerty',21);";
        // String query = "INSERT INTO temp (name,login,password,age) VALUES ('Petro2','pet','123456',22);";
        //st.execute(query);
        //
        //st.execute("UPDATE temp SET name='Taras' WHERE login LIKE 'iv%';");
        //st.execute("DELETE FROM temp WHERE password='qwerty';");
        //
        ResultSet rs = st.executeQuery("select * from temp;");
        int columnCount = rs.getMetaData().getColumnCount();
        // Resultset.getMetaData () get the information
        for (int i = 1; i <= columnCount; i++) {
            System.out.print(rs.getMetaData().getColumnName(i) + "\t");
        }
        System.out.println();
        // output file
        while (rs.next()) {
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(rs.getString(i) + "\t");
            }
            System.out.println();
        }
        System.out.println("before close");
        if (rs != null) {
            rs.close();
        }
        if (st != null) {
            st.close();
        }
        if (con != null) {
            con.close();
        }
        System.out.println("DONE");
    }
}