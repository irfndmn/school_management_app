package user;

import database.User_Info;

import java.util.Scanner;

public abstract class Validation{
    public  abstract void ekleme(Scanner sc, User a);
    public abstract void arama(Scanner sc);
    public abstract void listeleme(Scanner sc);
    public abstract void silme(Scanner sc);



    // Name Validation


    public boolean isValideName(String name){

        boolean isValid;

        boolean hasAnotherChar=name.replaceAll("[a-zA-Z ]","").length()>0;
        boolean hasSpace=name.trim().contains(" ");
        if(!hasSpace){
            System.out.println("Lutfen Arada Bir Bosluk Olacak Sekilde Isim ve Soyad Giriniz...");
            isValid=false;
        }else if(hasAnotherChar){
            System.out.println("Isim harf disinda herhangi bir karakter iceremez...");
            isValid=false;
        }else {
            isValid=true;
        }
        return isValid;
    }

    public String formtName(String name){
        name=name.replaceAll("\s+"," ").toLowerCase();
        String []Isim=name.split(" ");
        String frmtl="";
        for(int i=0;i<Isim.length;i++){
            String nam =Isim[i].substring(0,1).toUpperCase()+Isim[i].substring(1).toLowerCase();
            frmtl+=nam+" ";
        }
        return frmtl;
    }




    //tc validation

    public boolean isValidTc(String tc){
        boolean isvalid=tc.trim().replaceAll("[\\d]","").length()>0;
        boolean isLength=tc.trim().length()==11;

        if(isvalid){
            System.out.println("T.C. no'da rakam disinda karakter kullanilmamali...");
        }
        if(!isLength){
            System.out.println("T.C. no 11 rakam olmali...");
        }

        return !isvalid&&isLength;

    }
    public boolean isValidId(String Id){
        boolean isValid=false;
        boolean isStartChar= Id.replaceAll("[^A-Z]","").length()>0;
        boolean isOlmali=Id.replaceAll("[A-Z0-9]","").length()>0;
        if(!isStartChar){
            System.out.println("Id Buyuk Harfle Baslamali...");
            isValid=false;
        }else if(isOlmali){
            System.out.println("Id harf ve Rakam disinda Karakter bulundurmamali...");
            isValid=false;
        }else {
            isValid=true;
        }
        return isValid;

    }



    //validate cinsiyet

    public String cinsiyetDuz(String a){
        String cinsiyet="";
        if(a.equalsIgnoreCase("e")){
            cinsiyet= "Erkek";
        } else if (a.equalsIgnoreCase("k")) {
            cinsiyet= "Kadin";
        }else {
            System.out.println("Lutfen Cinsiyetinizi E veya K olacak sekilde giriniz...");  // eger q dondururse tekrar istencek
            cinsiyet="q";
        }
        return cinsiyet;
    }




    public boolean isAddedBefore(String tc){
        boolean a;
        int count=0;
        for(Ogrenci w: User_Info.ogrenciList){
            if(w.tcNo.equals(tc)){
                count++;
            }
        }
        for(Ogretmen w: User_Info.ogretmenList){
            if(w.tcNo.equals(tc)){
                count++;
            }
        }
        if(count>0){
            System.out.println("Bu T.C nolu kisi daha once eklenmistir...");
            a=true;
        }else {
            a=false;
        }
        return a;
    }


}
