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
public class AdresDAO {


    @Autowired
    private JdbcTemplate jdbcTemplate;



    public AdresDAO(JdbcTemplate jdbcTemplate){
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Adres> list(){
        String sql = "SELECT * FROM ADRESY";
        List<Adres> listAdres;
        listAdres = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Adres.class));
        return listAdres;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Adres adres) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("ADRESY").usingColumns("ID_adresu", "miasto", "ulica", "nr_lokalu", "ID_poczty");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adres);
        insertActor.execute(param);
    }
    /* Read – odczytywanie danych z bazy */
    public Adres get(int ID_adresu) {
        String sql = "SELECT * FROM ADRESY WHERE ID_adresu = ?";
        Object[] args = {ID_adresu};
        Adres adres = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Adres.class));
        return adres;
    }

    public Adres get1(int ID_adresu) {
        Object[] args = {ID_adresu};
        String sql = "SELECT * FROM ADRESY WHERE ID_adresu = " + args[0];
        Adres adres = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Adres.class));
        return adres;
    }

    public void update(Adres adres) {
        String sql = "UPDATE ADRESY SET Miasto=:Miasto,Ulica=:Ulica,Nr_lokalu=:Nr_lokalu,ID_poczty=:ID_poczty " +
                "WHERE ID_adresu=:ID_adresu";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adres);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int ID_adresu) {
        String sql = "DELETE FROM ADRESY WHERE ID_adresu = ?";
        jdbcTemplate.update(sql, ID_adresu);
    }
}

