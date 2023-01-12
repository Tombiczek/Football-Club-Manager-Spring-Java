package bdbt_project_2.SpringApplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class PocztaDAOTest {
    private PocztaDAO dao;

    @BeforeEach
    void setUp() throws Exception {
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setUrl("jdbc:oracle:thin:@194.29.170.4:1521:xe");
        datasource.setUsername("BDBTGRC16");
        datasource.setPassword("BDBTGRC16");
        datasource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new PocztaDAO(new JdbcTemplate(datasource));
    }

    @Test
    void testList(){
        List<Poczta> listPoczta = dao.list();
        assertFalse(listPoczta.isEmpty());
    }

    @Test
    void save() {
        Poczta poczta = new Poczta(8, "gsgsg", "ksksk");
        dao.save(poczta);
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
