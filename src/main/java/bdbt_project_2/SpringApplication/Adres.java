package bdbt_project_2.SpringApplication;

public class Adres {

    private int ID_adresu;
    private String Miasto;
    private String Ulica;
    private String Nr_lokalu;
    private int ID_poczty;

    public Adres(){
    }

    public int getID_adresu() {
        return ID_adresu;
    }

    public void setID_adresu(int ID_adresu) {
        this.ID_adresu = ID_adresu;
    }



    public void setMiasto(String miasto) {
        Miasto = miasto;
    }


    public String getMiasto() {
        return Miasto;
    }

    public String getUlica() {
        return Ulica;
    }

    public void setUlica(String ulica) {
        Ulica = ulica;
    }

    public String getNr_lokalu() {
        return Nr_lokalu;
    }

    public void setNr_lokalu(String nr_lokalu) {
        Nr_lokalu = nr_lokalu;
    }

    public int getID_poczty() {
        return ID_poczty;
    }

    public void setID_poczty(int ID_poczty) {
        this.ID_poczty = ID_poczty;
    }

    public Adres(int ID_adresu, String miasto, String ulica, String nr_lokalu, int ID_poczty){
        super();
        this.ID_adresu = ID_adresu;
        this.Miasto = miasto;
        this.Ulica = ulica;
        this.Nr_lokalu = nr_lokalu;
        this.ID_poczty = ID_poczty;
    }


    @Override
    public String toString() {
        return "Adres{" +
                "ID_adresu=" + ID_adresu +
                ", Miasto='" + Miasto + '\'' +
                ", Ulica='" + Ulica + '\'' +
                ", Nr_lokalu='" + Nr_lokalu + '\'' +
                ", Id_poczty='" + ID_poczty + '\'' +
                '}';
    }



}
