package hyman.spring.datasource.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
@Slf4j
public class DatasourceDemoApplication implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(DatasourceDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        showConnection();
        showData();
    }

    private void showData() throws SQLException {
        log.info(dataSource.toString());
        System.out.println(dataSource.toString());//HikariDataSource (HikariPool-1)
        Connection conn = dataSource.getConnection();
        log.info(conn.toString());
        System.out.println(conn.toString());//HikariProxyConnection@1818592781 wrapping conn0: url=jdbc:h2:mem:testdb user=SA
        conn.close();
    }

    private void showConnection() {
        jdbcTemplate.queryForList("SELECT * FROM testdb")
                .forEach(row -> System.out.println(row.toString()));
    }
}
