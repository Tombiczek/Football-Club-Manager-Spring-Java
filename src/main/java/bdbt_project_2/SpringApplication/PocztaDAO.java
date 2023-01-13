package bdbt_project_2.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
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
    public Poczta get(int ID_poczty) {
        String sql = "SELECT * FROM POCZTY WHERE ID_poczty = ?";
        Object[] args = {ID_poczty};
        Poczta poczta = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Poczta.class));
        return poczta;
    }

    public Poczta get1(int ID_poczty) {
        Object[] args = {ID_poczty};
        String sql = "SELECT * FROM POCZTY WHERE ID_poczty = " + args[0];
        Poczta poczta = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Poczta.class));
        return poczta;
    }

    public void update(Poczta poczta) {
        String sql = "UPDATE POCZTY SET kod_poczty=:kod_poczty,poczta=:poczta WHERE ID_poczty=:ID_poczty";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(poczta);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }



    public void delete(int ID_poczty) {
        String sql = "DELETE FROM POCZTY WHERE ID_poczty = ?";
        jdbcTemplate.update(sql, ID_poczty);
    }
}
