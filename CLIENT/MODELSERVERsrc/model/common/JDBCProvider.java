package model.common;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;

public class JDBCProvider {
    private static BasicDataSource basicDataSource = new BasicDataSource();

    static {
        basicDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
        basicDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        basicDataSource.setUsername("amirsam");
        basicDataSource.setPassword("myjava123");
        basicDataSource.setMaxTotal(10);
    }

    public static Connection getConnection() throws Exception {
        return basicDataSource.getConnection();
    }
}
