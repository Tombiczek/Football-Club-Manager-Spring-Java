package bdbt_project_2.SpringApplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import static org.junit.jupiter.api.Assertions.*;

class KlubDAOTest {
    private KlubDAO dao;

    @BeforeEach
    void setUp() throws Exception {
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setUrl("jdbc:oracle:thin:@194.29.170.4:xe");
        datasource.setUsername("BDBTGRA06");
        datasource.setPassword("BDBTGRA06");
        datasource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new KlubDAO(new JdbcTemplate(datasource));
    }

    @Test
    void testList(){
        fail("Not yet implemented");
    }

    @Test
    void save() {
        fail("Not yet implemented");
    }

    @Test
    void get() {
        fail("Not yet implemented");
    }

    @Test
    void update() {
        fail("Not yet implemented");
    }

    @Test
    void delete() {
        fail("Not yet implemented");
    }
}
