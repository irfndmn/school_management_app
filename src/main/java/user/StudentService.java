package user;

import database.User_Info;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StudentService extends UserService {


    public void ekleme(Scanner sc, Ogrenci a) {

        String ogrenciSinifi;
        String kayit;
        String sinif;
        String cikis = "";
        do {
            System.out.println("\n       ===============    Ogrenci Ekleme Islemi     ================     \n");
            super.ekleme(sc,a);

            do {
                System.out.println("Lutfen Ogrencinin Sinifini Giriniz... \n1 - 1. Sinif \n2 - 2. Sinif  \n3 - 3. Sinif \n4 - 4. Sinif\n");
                 sinif = sc.next();
                ogrenciSinifi = ogrencininSinifi(sinif);
            } while (ogrenciSinifi.equals("0"));

            kayit= kayitYili(ogrenciSinifi);

            if (isAddedBefore(a.tcNo)) {
                System.out.println("Lutfen Bilgileri Kontrol Ederek Tekrar Deneyiniz...");
            }else {

                new Ogrenci(a.name,a.tcNo,ogrenciSinifi,a.cinsiyet,kayit);


                System.out.println("Ogrenci Ekleme Isleminiz Basari Ile Tamamlanmistir...\n");
            }
                System.out.print("Cikis Icin Q, Devem Etmek Icin Herhangir Bir Tusa Basiniz  : ");
                cikis = sc.next().substring(0, 1).toLowerCase();

        } while (!cikis.equals("q"));


    }

    @Override
    public void arama(Scanner sc) {
        int secim;
        do {
            System.out.println("========================    Ogrenci Arama Islemi    =======================");
            System.out.println("---------------   Lutfen Yapmak Istediginiz islemi Secin    --------------\n");
            System.out.println("     1 - T.C. No Ile Arama \n     2 - Id Ile Arama\n     0 - CIKIS");
            secim = sc.nextInt();
            switch (secim) {
                case 1:
                    findByTc(sc);
                    break;
                case 2:
                    findByeId(sc);
                    break;
                case 0:
                    System.out.println("Bir Ust Menuye Yonlendiriliyorsunuz...");
                    break;
                default:
                    System.out.println("Lutfen Gecerli Bir Secim Yapiniz....");
            }

        } while (secim != 0);
        System.out.println("Tesekkurler Isleminiz Sonlandirilmistir....");

    }

    @Override
    public void listeleme(Scanner sc) {
        int sec;
        do{
            System.out.println("===================     Ogrenci Listeleme Islemi    ====================");
            System.out.println("----------->>>>>  Listelemeyi Hangi Ture Gore Yapmak Istersiniz...\n\n");
            System.out.println("    1 - Rasgele Ogrencileri Listele\n    2 - Id Noya Gore Ogrencileri Listele\n    3 - Sinifa Gore Ogrencileri Listele\n    0 - CIKIS\n");
            sec=sc.nextInt();

            switch (sec){
                case 1:
                    rasgeleOgrenciListele();
                    break;
                case 2:
                    ogrencilerIdNoyaGore(User_Info.ogrenciList);
                    break;
                case 3:
                    ogrencileSinifaGore(User_Info.ogrenciList);
                    break;
                case 0:
                    System.out.println("Bir Ust Menuye Yonlendiriliyorsunuz....");
                    break;
                default:
                    System.out.println("Lutfen Gecerli Bir Secim Yapiniz...");

            }


        }while(sec!=0);









    }

    @Override
    public void silme(Scanner sc) {
        int secim;
        do {
            System.out.println("========================    Ogrenci Silme Islemi    =======================");
            System.out.println("---------------   Lutfen Yapmak Istediginiz islemi Secin   --------------\n");
            System.out.println("     1 - T.C. No Ile Silme \n     2 - Id Ile Silme\n     0 - CIKIS");
            secim = sc.nextInt();
            switch (secim) {
                case 1:
                    deleteByTc(sc);
                    System.out.println("Tesekkurler Silme Isleminiz Basarili Bir Sekilde Tamamlanmistir....");
                    break;
                case 2:
                    deleteById(sc);
                    System.out.println("Tesekkurler Silme Isleminiz Basarili Bir Sekilde Tamamlanmistir....");
                    break;
                case 0:
                    System.out.println("Bir Ust Menuye Yonlendiriliyorsunuz...");
                    break;
                default:
                    System.out.println("Lutfen Gecerli Bir Secim Yapiniz....");
            }

        } while (secim != 0);
        System.out.println("Tesekkurler...");


    }


    // Ogrencinin Sinifi

    public String ogrencininSinifi(String sinif) {
        String snf = "";

        switch (sinif) {
            case "1":
                snf = "1. Sinif";
                break;
            case "2":
                snf = "2. Sinif";
                break;
            case "3":
                snf = "3. Sinif";
                break;
            case "4":
                snf = "4. Sinif";
                break;
            default:
                System.out.println("Lutfen Gecerli Bir Sinif Giriniz...");
                snf = "0";
        }

        return snf;

    }


    //kayit yili
    public String kayitYili(String sinif) {
        String KayitYili = "";

        switch (sinif) {
            case "1. Sinif":
                KayitYili = "2022";
                break;
            case "2. Sinif":
                KayitYili = "2021";
                break;
            case "3. Sinif":
                KayitYili = "2020";
                break;
            case "4. Sinif":
                KayitYili = "2019";
                break;
        }
        return KayitYili;

    }

    public void findByTc(Scanner sc) {

        System.out.println("==============================================================\n");
        String tc;
        do {
            System.out.print("Lutfen Aramak Istediginiz Ogrencinin Tc No Giriniz   : ");
            tc = sc.nextLine();
        } while (!isValidTc(tc));
        Ogrenci a = findByTc(tc, User_Info.ogrenciList);

        if (a == null) {
            System.out.println("Girmis Oldugunuz T.C. no ile Kayitli Ogrenci Bulunamadi...");
        } else {
            showStudent(a);
        }

    }
    public void findByeId(Scanner sc){
        System.out.println("===============================================================\n");
        String Id;
        do{
            System.out.print("Lutfen Aramak Istediginiz Ogrencinin Id(Ogrenci) No Giriniz   : ");
            Id = sc.nextLine();
        }while (!isValidId(Id));

        Ogrenci a = findByeId(Id, User_Info.ogrenciList);
        if (a == null) {
            System.out.println("Girmis Oldugunuz Id no ile Kayitli Ogrenci Bulunamadi...");
        } else {
            showStudent(a);
        }

    }

    public void deleteByTc(Scanner sc){
        System.out.println("--------------------------------------------------------------------------\n");
        String tc;
        do {
            System.out.print("Lutfen Silmek Istediginiz Ogrencinin Tc No Giriniz   : ");
            tc = sc.nextLine();
        } while (!isValidTc(tc));
        Ogrenci a = findByTc(tc, User_Info.ogrenciList);
        if(a==null){
            System.out.println("Girmis Oldugunuz T.C. no ile Kayitli Ogrenci Zaten Yok...");
        }else {

            User_Info.ogrenciList.remove(a);
        }

    }

    public void deleteById(Scanner sc){
        System.out.println("---------------------------------------------------------------------------\n");
        String Id;
        do {
            System.out.print("Lutfen Silmek Istediginiz Ogrencinin Id No Giriniz   : ");
            Id = sc.nextLine();
        } while (!isValidId(Id));
        Ogrenci a = findByeId(Id, User_Info.ogrenciList);
        if(a==null){
            System.out.println("Girmis Oldugunuz T.C. no ile Kayitli Ogrenci Zaten Yok...");
        }else {

            User_Info.ogrenciList.remove(a);
        }

    }






    public Ogrenci findByTc(String tc, List<Ogrenci> a) {

        Ogrenci k = null;

        for (Ogrenci m : a) {
            if (m.getTcNo().equals(tc)) {
                k = m;
            }
        }
        return k;
    }


    public Ogrenci findByeId(String id, List<Ogrenci> a) {
        Ogrenci k = null;
        for (Ogrenci w : User_Info.ogrenciList) {
            if (w.stdId.equals(id)) {
                k = w;
            }
        }
        return k;
    }


    public void showStudent(Ogrenci a) {

        System.out.println("||-----------------------------------------------------------------------------------------------------------------------------------------------------||");
        System.out.printf("           | %-16s          %-27s    %-10s          %-13s       %-9s          %-15s|\n", "Ogrenci Id", "Ogrenci Ismi", "Cinsiyet", "Sinifi", "Kayit Yili", "T.C. Kimlik No");
        System.out.println("||-----------------------------------------------------------------------------------------------------------------------------------------------------||\n");
        System.out.printf("           %-13s       %-23s       %-9s       %-11s        %-8s       %-14s\n", "|==============|", "|========================|", "|==========|", "|============|", "|==========|", "|=================|");
        System.out.printf("           | %-16s          %-27s     %-10s       %-13s          %-9s          %-15s|\n", a.stdId, a.name, a.cinsiyet, a.sinifi, a.kayitYili, a.tcNo);
        System.out.printf("           %-13s       %-23s       %-9s       %-11s        %-8s       %-14s\n", "|==============|", "|========================|", "|==========|", "|============|", "|==========|", "|=================|");
        System.out.println("||-----------------------------------------------------------------------------------------------------------------------------------------------------||");


    }

    public void rasgeleOgrenciListele(){
        if(User_Info.ogrenciList.isEmpty()){
            System.out.println("Listede Henuz Kayitli Ogrenci Bulunmamaktadir....\n");
        }else {
            System.out.println("||-----------------------------------------------------------------------------------------------------------------------------------------------------||");
            System.out.printf("           | %-16s          %-27s    %-10s          %-13s       %-9s          %-15s|\n", "Ogrenci Id", "Ogrenci Ismi", "Cinsiyet", "Sinifi", "Kayit Yili", "T.C. Kimlik No");
            System.out.println("||-----------------------------------------------------------------------------------------------------------------------------------------------------||\n");
            System.out.printf("           %-13s       %-23s       %-9s       %-11s        %-8s       %-14s\n", "|==============|", "|========================|", "|==========|", "|============|", "|==========|", "|=================|");
            for (Ogrenci w : User_Info.ogrenciList) {
                System.out.printf("           | %-16s          %-27s     %-10s       %-13s          %-9s          %-15s|\n", w.stdId, w.name, w.cinsiyet, w.sinifi, w.kayitYili, w.tcNo);
            }
            System.out.printf("           %-13s       %-23s       %-9s       %-11s        %-8s       %-14s\n", "|==============|", "|========================|", "|==========|", "|============|", "|==========|", "|=================|");
            System.out.println("||-----------------------------------------------------------------------------------------------------------------------------------------------------||");

        }
    }
    public void ogrencilerIdNoyaGore(List<Ogrenci> m){
        if(m.isEmpty()){
            System.out.println("Listede Henuz Kayitli Ogrenci Bulunmamaktadir....\n");
        }else {
            List<Ogrenci> a = m.stream().sorted(Comparator.comparing(Ogrenci::getStdId)).toList();
            for (Ogrenci w : a) {
                System.out.printf("           | %-16s          %-27s     %-10s       %-13s          %-9s          %-15s|\n", w.stdId, w.name, w.cinsiyet, w.sinifi, w.kayitYili, w.tcNo);
            }
        }
    }
    public void ogrencileSinifaGore(List<Ogrenci> m){
        if(m.isEmpty()){
            System.out.println("Listede Henuz Kayitli Ogrenci Bulunmamaktadir....\n");
        }else {
            List<Ogrenci> a = m.stream().sorted(Comparator.comparing(Ogrenci::getSinifi)).toList();
            for (Ogrenci w : a) {
                System.out.printf("           | %-16s          %-27s     %-10s       %-13s          %-9s          %-15s|\n", w.stdId, w.name, w.cinsiyet, w.sinifi, w.kayitYili, w.tcNo);
            }
        }
    }

}