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
    void testSave() {
        Poczta poczta = new Poczta(14, "gsgsg", "ksksk");
        dao.save(poczta);
    }

    @Test
    void testGet() {
        int id = 1;
        Poczta poczta = dao.get(id);

        assertNotNull(poczta);
    }

    @Test
    void testUpdate() {
        Poczta poczta = new Poczta();
        poczta.setID_poczty(15);
        poczta.setKod_poczty("343434");
        poczta.setPoczta("SuperPoczta");

        dao.update(poczta);
    }

    @Test
    void testDelete() {
        int ID_poczty = 2;
        dao.delete(ID_poczty);
    }
}
