package user;

public class Dersler extends Ogrenci{

    public String dersIsmi;

    public double dersNotu;

    public Dersler(String ismi,String sinifi,String dersIsmi, double dersNotu) {
        super(ismi,sinifi);
        this.dersIsmi = dersIsmi;
        this.dersNotu = dersNotu;
    }


    @Override
    public String toString() {
        return "Dersler{" +
                "dersIsmi='" + dersIsmi + '\'' +
                ", dersNotu=" + dersNotu +
                '}';
    }
}
