package bdbt_project_2.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;




@Repository
public class KlubDAO {


    @Autowired
    private JdbcTemplate jdbcTemplate;



    public KlubDAO(JdbcTemplate jdbcTemplate){
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Klub> list(){
        String sql = "SELECT * FROM KLUBY_PILKARSKIE";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Klub.class));
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Klub klub) {}
    /* Read – odczytywanie danych z bazy */
    public Klub get(int idKlubu) {
        return null;
    }
    /* Update – aktualizacja danych */
    public void update(Klub klub) {}
    /* Delete – wybrany rekord z danym id */
    public void delete(int idKlubu) {}
}
