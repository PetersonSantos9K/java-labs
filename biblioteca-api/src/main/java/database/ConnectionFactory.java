package database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    static {

        Properties props = getProps();
        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String password = props.getProperty("db.password");

        config.setJdbcUrl(url);
        config.setUsername(user);
        config.setPassword(password);

        ds = new HikariDataSource(config);
    }

    private static Properties getProps(){

        Properties props = new Properties();

        try(InputStream file = ConnectionFactory.class.getClassLoader().getResourceAsStream("db.properties")){
            props.load(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return props;
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public static void closePool() throws SQLException {
        if(getConnection() != null && !getConnection().isClosed()){
            getConnection().close();
        }
    }

}
