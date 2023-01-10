package bdbt_project_2.SpringApplication;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class KlubManager {

    public static void main(String[] args){
        SpringApplication.run(KlubManager.class, args);
    }
}
