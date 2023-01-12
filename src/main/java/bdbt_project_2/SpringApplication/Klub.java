package bdbt_project_2.SpringApplication;

import java.time.*;

public class Klub {
    private int ID_klubu;
    private String nazwa;
    private String email;
    private String numer_telefonu;
    private LocalDate data_zalozenia; // na razie String potem pomyślimy
    private String barwy;
    private int ID_adresu;


    public Klub(){}

    public Klub(int ID_klubu, String nazwa, String email, String numer_telefonu, LocalDate data_zalozenia, String barwy, int ID_adresu){
        this.ID_klubu = ID_klubu;
        this.nazwa = nazwa;
        this.email = email;
        this.numer_telefonu = numer_telefonu;
        this.data_zalozenia = data_zalozenia;
        this.barwy = barwy;
        this.ID_adresu = ID_adresu;
    }

    public int getID_klubu() {
        return ID_klubu;
    }

    public void setID_klubu(int ID_klubu) {
        this.ID_klubu = ID_klubu;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumer_telefonu() {
        return numer_telefonu;
    }

    public void setNumer_telefonu(String numer_telefonu) {
        this.numer_telefonu = numer_telefonu;
    }

    public LocalDate getDdata_zalozenia() {
        return data_zalozenia;
    }

    public void setData_zalozenia(LocalDate data_zalozenia) {
        this.data_zalozenia = data_zalozenia;
    }

    public String getBarwy() {
        return barwy;
    }

    public void setBarwy(String barwy) {
        this.barwy = barwy;
    }

    public int getID_adresu() {
        return ID_adresu;
    }

    public void setID_adresu(int ID_adresu) {
        this.ID_adresu = ID_adresu;
    }


    @Override
    public String toString() {
        return "KLUBY_PILKARSKIE[" +
                "ID_klubu=" + ID_klubu +
                ", Nazwa='" + nazwa + '\'' +
                ", Email=" + email +
                ", Numer_telefonu=" + numer_telefonu +
                ", Data założenia=" + data_zalozenia +
                ", Barwy=" + barwy +
                ", idAdresu=" + ID_adresu +
                "]";
    }
}