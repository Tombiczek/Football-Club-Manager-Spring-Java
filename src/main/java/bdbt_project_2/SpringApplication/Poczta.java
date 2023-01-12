package bdbt_project_2.SpringApplication;

public class Poczta {
    private int ID_poczty;
    private String Kod_poczty;
    private String Poczta;


    public Poczta(){}


    public int getID_poczty() {
        return ID_poczty;
    }

    public void setID_poczty(int id_poczty) {
        ID_poczty = id_poczty;
    }

    public String getKod_poczty() {
        return Kod_poczty;
    }

    public void setKod_poczty(String kod_poczty) {
        Kod_poczty = kod_poczty;
    }

    public String getPoczta() {
        return Poczta;
    }

    public void setPoczta(String poczta) {
        Poczta = poczta;
    }

    public Poczta(int ID_poczty, String kod_poczty, String poczta){
        super();
        this.ID_poczty = ID_poczty;
        this.Kod_poczty = kod_poczty;
        this.Poczta = poczta;
    }

    public String toString(){
        return "Poczta{" +
                "Id_poczty=" + ID_poczty +
                ", Kod_poczty='" + Kod_poczty + '\'' +
                ", Poczta='" + Poczta + '\'' +
                '}';
    }
}
