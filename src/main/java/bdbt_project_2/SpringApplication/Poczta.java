package bdbt_project_2.SpringApplication;

public class Poczta {
    private int ID_poczty;
    private String Kod_poczty;
    private String Poczta;


    public Poczta(){}

    public void setID_poczty(int ID_poczty) {
        this.ID_poczty = ID_poczty;
    }
    public int getID_poczty() {
        return ID_poczty;
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

    public Poczta(int ID_poczty, String Kod_poczty, String Poczta){
        super();
        this.ID_poczty = ID_poczty;
        this.Kod_poczty = Kod_poczty;
        this.Poczta = Poczta;
    }

    public String toString(){
        return "Poczta{" +
                "Id_poczty=" + ID_poczty +
                ", Kod_poczty='" + Kod_poczty + '\'' +
                ", Poczta='" + Poczta + '\'' +
                '}';
    }
}
