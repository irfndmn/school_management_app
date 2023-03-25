package user;

import database.User_Info;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Ogretmen extends User{

    public  String ogrtmnBransi;
    public String ogrtSorumluOlduguSinif;


    public Ogretmen() {
    }

    public Ogretmen(String ogrtmnIsmi, String ogrtTcNo, String ogrtmnBransi, String ogrtCinsiyet, String ogrtSorumluOlduguSinif) {
        super(ogrtmnIsmi,ogrtTcNo,ogrtCinsiyet);
        this.ogrtmnBransi = ogrtmnBransi;
        this.ogrtSorumluOlduguSinif = ogrtSorumluOlduguSinif;
    }

    public String sinifaGore(){
        return this.ogrtSorumluOlduguSinif;
    }

    public String getOgrtmnBransi() {
        return ogrtmnBransi;
    }

    @Override
    public String toString() {
        return "Ogretmen{" +
                "ogrtmnBransi='" + ogrtmnBransi + '\'' +
                ", ogrtSorumluOlduguSinif='" + ogrtSorumluOlduguSinif + '\'' +
                '}';
    }



}


