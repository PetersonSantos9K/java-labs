package database;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DbConnection {

    private static final HikariConfig config = new HikariConfig();
    private static final HikariDataSource ds;

    static {

        Properties props = props();
        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String password = props.getProperty("db.password");

        config.setJdbcUrl(url);
        config.setUsername(user);
        config.setPassword(password);

        ds = new HikariDataSource(config);
    }

    private static Properties props(){
        Properties props = new Properties();
        try(InputStream file = DbConnection.class.getClassLoader().getResourceAsStream("db.properties")){
            props.load(file);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return props;
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public static void closePool() throws SQLException{
        if(getConnection() != null && !getConnection().isClosed()){
            getConnection().close();
        }
    }



}
