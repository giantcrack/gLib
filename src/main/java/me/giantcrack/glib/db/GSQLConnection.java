package me.giantcrack.glib.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class GSQLConnection {

    private String ip;

    private int port;

    private String userName;

    private String passWord;

    private String dbName;

    private HikariDataSource hikariDataSource;

    public GSQLConnection(String ip, int port, String userName, String password, String dbName) {
        this.ip = ip;
        this.port = port;
        this.userName = userName;
        this.passWord = password;
        this.dbName = dbName;

        //Set up properties for config
        Properties properties = new Properties();
        properties.setProperty("dataSourceClass","com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
        properties.setProperty("dataSource.user",userName);
        properties.setProperty("dataSource.password",password);
        properties.setProperty("dataSource.databaseName", dbName);
        properties.put("dataSource.logWriter", new PrintWriter(System.out));

        HikariConfig hikariConfig = new HikariConfig(properties);

        this.hikariDataSource = new HikariDataSource(hikariConfig);

        this.hikariDataSource.setMaximumPoolSize(10);
    }

    public HikariDataSource getHikariDataSource() {
        return hikariDataSource;
    }

    public Connection getConnection() {
        try {
            return getHikariDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public GSQLConnection close() {
        if (this.hikariDataSource != null) {
            this.hikariDataSource.close();
        }
        return this;
    }
}
