package bdbt_project_2.SpringApplication;

public class Klub {
    private int idKlubu;
    private String nazwa;
    private String email;
    private String n_telefonu;
    private String data_zal; // na razie String potem pomyślimy
    private String barwy;
    private int idAdresu;


    public Klub(){}

    public Klub(int idKlubu, String nazwa, String email, String n_telefonu, String data_zal, String barwy, int idAdresu){
        super();
        this.idKlubu = idKlubu;
        this.nazwa = nazwa;
        this.email = email;
        this.n_telefonu = n_telefonu;
        this.data_zal = data_zal;
        this.barwy = barwy;
        this.idAdresu = idAdresu;
    }

    public int getIdKlubu(){
        return idKlubu;
    }

    public String getBarwy() {
        return barwy;
    }

    public int getIdAdresu() {
        return idAdresu;
    }

    public String getNazwa(){
        return nazwa;
    }

    public String getData_zal() {
        return data_zal;
    }

    public String getEmail(){
        return email;
    }

    public String getN_telefonu(){
        return n_telefonu;
    }

    public void setIdKlubu(int idKlubu) {
        this.idKlubu = idKlubu;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setN_telefonu(String n_telefonu) {
        this.n_telefonu = n_telefonu;
    }

    public void setData_zal(String data_zal) {
        this.data_zal = data_zal;
    }

    public void setBarwy(String barwy) {
        this.barwy = barwy;
    }

    public void setIdAdresu(int idAdresu) {
        this.idAdresu = idAdresu;
    }


    @Override
    public String toString() {
        return "Klub[" +
                "idKlubu=" + idKlubu +
                ", Nazwa='" + nazwa + '\'' +
                ", Email=" + email +
                ", N_Telefonu=" + n_telefonu +
                ", Data założenia=" + data_zal +
                ", Barwy=" + barwy +
                ", idAdresu=" + idAdresu +
                "]";
    }
}