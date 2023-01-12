package bdbt_project_2.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import java.util.List;




@Repository
public class PocztaDAO {


    @Autowired
    private JdbcTemplate jdbcTemplate;



    public PocztaDAO(JdbcTemplate jdbcTemplate){
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Poczta> list(){
        String sql = "SELECT * FROM POCZTY";
        List<Poczta> listPoczta;
        listPoczta = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Poczta.class));
        return listPoczta;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Poczta poczta) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("POCZTY").usingColumns("ID_poczty", "kod_poczty", "poczta");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(poczta);
        insertActor.execute(param);
    }
    /* Read – odczytywanie danych z bazy */
    public Poczta get(int id_poczty) {
        return null;
    }
    /* Update – aktualizacja danych */
    public void update(Poczta poczta) {}
    /* Delete – wybrany rekord z danym id */
    public void delete(int id_poczty) {}
}
