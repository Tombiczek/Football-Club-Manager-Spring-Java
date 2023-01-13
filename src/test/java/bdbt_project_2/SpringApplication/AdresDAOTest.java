package bdbt_project_2.SpringApplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class AdresDAOTest {
    private AdresDAO dao;

    @BeforeEach
    void setUp() throws Exception {
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setUrl("jdbc:oracle:thin:@194.29.170.4:1521:xe");
        datasource.setUsername("BDBTGRC16");
        datasource.setPassword("BDBTGRC16");
        datasource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new AdresDAO(new JdbcTemplate(datasource));
    }

    @Test
    void testList(){
        List<Adres> listAdres = dao.list();
        assertFalse(listAdres.isEmpty());
    }

    @Test
    void testSave() {
        Adres adres = new Adres(10, "gsgs", "swdswd", "10a", 5);
        dao.save(adres);
    }

    @Test
    void testGet() {
        int id = 1;
        Adres adres = dao.get(id);

        assertNotNull(adres);
    }

    @Test
    void testUpdate() {
        Adres adres = new Adres();
        adres.setID_adresu(12);
        adres.setMiasto("Krakow");
        adres.setUlica("Elegancka");
        adres.setNr_lokalu("22c");
        adres.setID_poczty(4);

        dao.update(adres);
    }

    @Test
    void testDelete() {
        int ID_adresu = 2;
        dao.delete(ID_adresu);
    }
}

