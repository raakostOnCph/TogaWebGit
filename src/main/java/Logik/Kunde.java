package Logik;

public class Kunde {

    private int kundeId;
    private String navn;

    public Kunde() {
    }

    public Kunde(String navn) {
        this.navn = navn;
    }



    public int getKundenr() {
        return kundeId;
    }

    public void setKundenr(int kundenr) {
        kundeId = kundenr;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }
}
