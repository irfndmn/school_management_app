package user;

import database.User_Info;

import java.util.ArrayList;
import java.util.List;

public class Ogrenci extends User{

    public String sinifi;
    public  String stdId;

    public static int count=100;

    public String kayitYili;

    public Ogrenci(String name, String sinifi) {
        super(name);
        this.sinifi = sinifi;
    }

    public Ogrenci() {
    }



    public Ogrenci(String ogrncIsmi, String tcNo, String sinifi, String ogrencininCinsiyet, String kayitYili) {
        super(ogrncIsmi,tcNo,ogrencininCinsiyet);
        this.sinifi = sinifi;
        this.kayitYili=kayitYili;
        countArtir();
        this.stdId = ogrncIsmi.substring(0,1).toUpperCase()+this.kayitYili+count;
        User_Info.ogrenciList.add(this);

    }

    public void countArtir(){
         ++count;
    }


    public String getSinifi() {
        return sinifi;
    }

    public String getStdId() {
        return stdId;
    }

    @Override
    public String toString() {
        return "Ogrenci{" +
                "sinifi='" + sinifi + '\'' +
                ", stdId='" + stdId + '\'' +
                ", kayitYili='" + kayitYili + '\'' +
                '}';
    }
}

