package user;

import database.User_Info;

import java.util.Scanner;

public  class UserService extends Validation {


    @Override
    public void ekleme(Scanner sc,User a) {

        sc.nextLine();  // ilk verilen veri girisin cozumu
        a.name=getNameFromUser(sc);
        System.out.println();
        a.tcNo=getTcNoFromUser(sc);
        System.out.println();
        a.cinsiyet=getGenderFromUser(sc);
        System.out.println();
    }


    @Override
    public void arama(Scanner sc) {

    }


    @Override
    public void listeleme(Scanner sc) {

    }

    @Override
    public void silme(Scanner sc) {

    }




    public String getNameFromUser(Scanner sc){
        String frmName="";
        boolean isValid;
        do{
            isValid=true;
            System.out.print("Lutfen Isim Giriniz       :  ");
            String name=sc.nextLine();
            if(!isValideName(name)){
                isValid=false;
            }else {
                frmName=formtName(name);
            }
        }while (!isValid);

        return frmName;

    }


    public String getTcNoFromUser(Scanner sc){
        String tc="";
        boolean isValid;

        do{
            isValid=true;
            System.out.print("Lutfen Tc No Giriniz      : ");
            String tcc=sc.nextLine();
            if(!isValidTc(tcc)){
                isValid=false;
            }else {
                tc=tcc;
            }

        }while(!isValid);

        return tc;

    }


    public String getGenderFromUser(Scanner sc){
        String gender ="";
        boolean isValid;

        do{
            isValid=true;
            System.out.print("Lutfen Cinsiyet Giriniz Erkek icin E, Kadin icin K  : ");
            String gen=sc.next();
            if(cinsiyetDuz(gen).equals("q")){
                isValid=false;
            }else {
                gender=cinsiyetDuz(gen);
            }
        }while (!isValid);

        return gender;

    }

}
