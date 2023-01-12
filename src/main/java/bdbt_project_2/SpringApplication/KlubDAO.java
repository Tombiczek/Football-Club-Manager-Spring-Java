package bdbt_project_2.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
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
        String sql = "SELECT * FROM kluby_pilkarskie";
        List<Klub> listKlub = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Klub.class));
        return listKlub;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Klub klub) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("klub").usingColumns("nazwa", "email", "n_telefonu", "data_zal", "barwy");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(klub);
        insertActor.execute(param);
    }
    /* Read – odczytywanie danych z bazy */
    public Klub get(int idKlubu) {
        return null;
    }
    /* Update – aktualizacja danych */
    public void update(Klub klub) {}
    /* Delete – wybrany rekord z danym id */
    public void delete(int idKlubu) {}
}
