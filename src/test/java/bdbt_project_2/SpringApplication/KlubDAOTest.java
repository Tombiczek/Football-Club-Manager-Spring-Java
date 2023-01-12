package bdbt_project_2.SpringApplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.time.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class KlubDAOTest {
    private KlubDAO dao;

    @BeforeEach
    void setUp() throws Exception {
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setUrl("jdbc:oracle:thin:@194.29.170.4:1521:xe");
        datasource.setUsername("BDBTGRC16");
        datasource.setPassword("BDBTGRC16");
        datasource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new KlubDAO(new JdbcTemplate(datasource));
    }

    @Test
    void testList(){
        List<Klub> listKlub = dao.list();
        assertFalse(listKlub.isEmpty());
    }

    @Test
    void save() {
        Klub klub = new Klub(2, "Essa", "emaial", "6363",
                LocalDate.of(2020, 1, 8), "czerwony", 2);
        dao.save(klub);
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
