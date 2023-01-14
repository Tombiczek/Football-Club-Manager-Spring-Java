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

//    @Test
//    void testSave() {
//        Klub klub = new Klub(2, "Essa", "emaial", "6363",
//                new Date(2022, Calendar.FEBRUARY, 2), "czerwony", 2);
//        dao.save(klub);
//    }

    @Test
    void testGet() {
        int id = 1;
        Klub klub = dao.get(id);

        assertNotNull(klub);
    }

    @Test
    void testUpdate() {
        Klub klub = new Klub();
        klub.setID_klubu(15);
        klub.setNazwa("Essowina");
        klub.setEmail("essa@essa.com");
        klub.setNumer_telefonu("44354343");
        klub.setBarwy("Fiolet");
        klub.setID_adresu(5);

        dao.update(klub);
    }

    @Test
    void testDelete() {
        int ID_klubu = 1;
        dao.delete(ID_klubu);
    }
}
