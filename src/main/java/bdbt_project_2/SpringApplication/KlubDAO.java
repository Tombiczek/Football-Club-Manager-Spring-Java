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
public class KlubDAO {


    @Autowired
    private JdbcTemplate jdbcTemplate;



    public KlubDAO(JdbcTemplate jdbcTemplate){
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Klub> list(){
        String sql = "SELECT * FROM KLUBY_PILKARSKIE";
        List<Klub> listKlub;
        listKlub = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Klub.class));
        return listKlub;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Klub klub) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("KLUBY_PILKARSKIE").usingColumns("ID_klubu", "nazwa", "email",
                "numer_telefonu", "data_zalozenia", "barwy", "ID_adresu");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(klub);
        insertActor.execute(param);
    }
    /* Read – odczytywanie danych z bazy */
    public Klub get(int ID_klubu) {
        String sql = "SELECT * FROM KLUBY_PILKARSKIE WHERE ID_klubu = ?";
        Object[] args = {ID_klubu};
        Klub klub = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Klub.class));
        return klub;
    }

    public Klub get1(int ID_klubu) {
        Object[] args = {ID_klubu};
        String sql = "SELECT * FROM KLUBY_PILKARSKIE WHERE ID_klubu = " + args[0];
        Klub klub = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Klub.class));
        return klub;
    }

    public void update(Klub klub) {
        String sql = "UPDATE KLUBY_PILKARSKIE SET nazwa=:nazwa,email=:email,numer_telefonu=:numer_telefonu," +
                "data_zalozenia=:data_zalozenia,barwy=:barwy,ID_adresu=:ID_adresu WHERE ID_klubu=:ID_klubu";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(klub);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }


    public void delete(int ID_klubu) {
        String sql = "DELETE FROM KLUBY_PILKARSKIE WHERE ID_klubu = ?";
        jdbcTemplate.update(sql, ID_klubu);
    }
}
