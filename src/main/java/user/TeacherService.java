package user;

import database.User_Info;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TeacherService extends UserService {


    public void ekleme(Scanner sc, Ogretmen a) {
        String cikis = "";
        do {
            System.out.println("\n       ===============    Ogretmen Ekleme Islemi     ================     \n");
            super.ekleme(sc,a);
            String secim;

            do {
                System.out.println("Lutfen Ogretmenin Bransini Giriniz...  \n   1 - Matematik\n   2 - Fizik\n   3 - Kimya\n   4 - Geometri\n   5 - Cografya\n");
                secim = ogretmenBransi(sc.nextInt());
            } while (secim.equals("q"));

            String sec;
            do {
                System.out.println("Lutfen Ogretmenin Sorumlu Oldugu Sinifi Giriniz...\n   1 - 1. Sinif\n   2 - 2. Sinif\n   3 - 3. Sinif\n   4 - 4. Sinif\n ");
                sec = ogretmenSorumluSinif(sc.nextInt());
            } while (sec.equals("q"));
            a.ogrtmnBransi = secim;
            a.ogrtSorumluOlduguSinif = sec;
            if (isAddedBefore(a.tcNo)) {
                System.out.println("Lutfen Bilgileri Kontrol Ederek Tekrar Deneyiniz...");
            } else {
                User_Info.ogretmenList.add(new Ogretmen(a.name, a.tcNo, a.ogrtmnBransi, a.cinsiyet, a.ogrtSorumluOlduguSinif));  /// Buraya Tekrar bak sadece obje koyabilir miyiz
                System.out.println("Ogretmen Ekleme Isleminiz Basari Ile Tamamlanmistir...\n");
                System.out.print("Cikis Icin Q, Devem Etmek Icin Herhangir Bir Tusa Basiniz  : ");
                cikis = sc.next().substring(0, 1).toLowerCase();
                sc.nextLine();
            }

        } while (!cikis.equals("q"));

    }

    @Override
    public void arama(Scanner sc) {

        int secim;
        do {
            System.out.println("===========================    Ogretmen Arama Islemi   =============================\n");
            System.out.println("---------------   Lutfen Yapmak Istediginiz islemi Secin    ---------------\n");
            System.out.println("     1 - T.C. No Ile Arama\n     0 - CIKIS");
            secim = sc.nextInt();
            switch (secim) {
                case 1:
                    findByTc(sc);
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
        int sec1;
        do {
            System.out.println("===================     Ogretmen Listeleme Islemi    ====================");
            System.out.println("----------->>>>>  Listelemeyi Hangi Ture Gore Yapmak Istersiniz...\n\n");
            System.out.println("    1 - Rasgele Ogretmenleri Listele\n    2 - Bransa Gore Listele\n    3 - Sorumlu Olduklari Sinifa Gore Listele\n    0 - CIKIS\n");
            sec1 = sc.nextInt();

            switch (sec1) {
                case 1:
                    rasgeleOgreSirala();
                    break;
                case 2:
                    bransaGoreSirala(User_Info.ogretmenList);
                    break;
                case 3:
                    sinifaGoreSirala(User_Info.ogretmenList);
                    break;
                case 0:
                    System.out.println("Bir Ust Menuye Yonlendiriliyorsunuz....");
                    break;
                default:
                    System.out.println("Lutfen Gecerli Bir Secim Yapiniz...");

            }

        }while (sec1!=0);
    }


    @Override
    public void silme(Scanner sc) {
        int secim;
        do {
            System.out.println("========================    Ogretmen Silme Islemi    =======================");
            System.out.println("---------------   Lutfen Yapmak Istediginiz islemi Secin    --------------\n");
            System.out.println("     1 - T.C. No Ile Silme \n     0 - CIKIS");
            secim = sc.nextInt();
            switch (secim) {
                case 1:
                    deleteByTc(sc);
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

    //Ogretmeninin sorumlu oldugu sinif
    public String ogretmenSorumluSinif(int a) {
        String sinif = "";
        switch (a) {
            case 1:
                sinif = "1. Sinif";
                break;
            case 2:
                sinif = "2. Sinif";
                break;
            case 3:
                sinif = "3. Sinif";
                break;
            case 4:
                sinif = "4. Sinif";
                break;
            default:
                sinif = "q";
                System.out.println("Lutfen Gecerli Bir Sinif Giriniz...");
        }
        return sinif;
    }

    // ogretmen bransi
    public String ogretmenBransi(int brans) {

        String branss = "";

        switch (brans) {
            case 1:
                branss = "matematik";
                break;
            case 2:
                branss = "fizik";
                break;
            case 3:
                branss = "kimya";
                break;
            case 4:
                branss = "geometri";
                break;
            case 5:
                branss = "cografya";
                break;
            default:
                branss = "q";
                System.out.println("Lutfen Okulumuzda mevcut olan bir brans seciniz...");
        }
        return branss;

    }


    public void findByTc(Scanner sc) {
        System.out.println("==============================================================\n");
        String tc;
        do {
            System.out.print("Lutfen Aramak Istediginiz Ogretmenin Tc No Giriniz   : ");
            tc = sc.nextLine();
        } while (!isValidTc(tc));
        Ogretmen a = findByeTc(tc, User_Info.ogretmenList);

        if (a == null) {
            System.out.println("Girmis Oldugunuz T.C. no ile Kayitli Ogrenci Bulunamadi...");
        } else {
            showOgretmen(a);
        }

    }


    public void showOgretmen(Ogretmen a) {
        System.out.println("||----------------------------------------------------------------------------------------------------------------------------------------------------||");
        System.out.printf("           | %-15s          %-25s    %-10s          %-15s       %-13s|\n", "Ogretmen T.C. No", "Ogretmen Ismi", "Cinsiyet", "Bransi", "Girdigi Sinif");
        System.out.println("||-----------------------------------------------------------------------------------------------------------------------------------------------------||\n");
        System.out.printf("           %-15s       %-25s       %-10s       %-15s        %-13s\n", "|==============|", "|========================|", "|==========|", "|============|", "|==========|");
        System.out.printf("           | %-15s          %-25s      %-10s          %-15s       %-9s|\n", a.tcNo, a.name, a.cinsiyet, a.ogrtmnBransi, a.ogrtSorumluOlduguSinif);
        System.out.printf("           %-15s       %-25s       %-10s       %-15s        %-13s\n", "|==============|", "|========================|", "|==========|", "|============|", "|==========|");
        System.out.println("||-----------------------------------------------------------------------------------------------------------------------------------------------------||");

    }


    public Ogretmen findByeTc(String tc, List<Ogretmen> a) {
        Ogretmen k = null;
        for (Ogretmen w : a) {
            if (w.getTcNo().equals(tc)) {
                k = w;
            }
        }
        return k;
    }


    public void deleteByTc(Scanner sc) {
        System.out.println("-------------------------------------------------------------------------\n");
        String tc;
        do {
            System.out.print("Lutfen Silmek Istediginiz Ogretmenin Tc No Giriniz   : ");
            tc = sc.nextLine();
        } while (!isValidTc(tc));
        Ogretmen a = findByeTc(tc, User_Info.ogretmenList);
        if (a == null) {
            System.out.println("Girmis Oldugunuz T.C. no ile Kayitli Ogrenci Zaten Yok...");
        } else {

            User_Info.ogretmenList.remove(a);
        }

    }


    public void rasgeleOgreSirala(){
        if(User_Info.ogretmenList.isEmpty()){
            System.out.println("Listede Henuz Kayitli Ogretmen Bulunmamaktadir....\n");
        }else {
            System.out.println("||----------------------------------------------------------------------------------------------------------------------------------------------------||");
            System.out.printf("           | %-15s          %-25s    %-10s          %-15s       %-13s|\n", "Ogretmen T.C. No", "Ogretmen Ismi", "Cinsiyet", "Bransi", "Girdigi Sinif");
            System.out.println("||-----------------------------------------------------------------------------------------------------------------------------------------------------||\n");
            System.out.printf("           %-15s       %-25s       %-10s       %-15s        %-13s\n", "|==============|", "|========================|", "|==========|", "|============|", "|==========|");
            for (Ogretmen w : User_Info.ogretmenList) {
                System.out.printf("           | %-15s          %-25s      %-10s          %-15s       %-9s|\n", w.tcNo, w.name, w.cinsiyet, w.ogrtmnBransi, w.ogrtSorumluOlduguSinif);
            }
            System.out.printf("           %-15s       %-25s       %-10s       %-15s        %-13s\n", "|==============|", "|========================|", "|==========|", "|============|", "|==========|");
            System.out.println("||-----------------------------------------------------------------------------------------------------------------------------------------------------||");
        }
    }

    public void bransaGoreSirala(List<Ogretmen> a){
        if(a.isEmpty()){
            System.out.println("Listede Henuz Kayitli Ogretmen Bulunmamaktadir....\n");
        }else {
            List<Ogretmen> km = a.stream().sorted(Comparator.comparing(Ogretmen::getOgrtmnBransi)).toList();
            for (Ogretmen w : km) {
                System.out.printf("           | %-15s          %-25s      %-10s          %-15s       %-9s|\n", w.getTcNo(), w.name, w.cinsiyet, w.ogrtmnBransi, w.ogrtSorumluOlduguSinif);
            }
        }
    }
    public void sinifaGoreSirala(List<Ogretmen> a){
        if(a.isEmpty()){
            System.out.println("Listede Henuz Kayitli Ogretmen Bulunmamaktadir....\n");
        }else {
            List<Ogretmen> km = a.stream().sorted(Comparator.comparing(Ogretmen::sinifaGore)).toList();
            for (Ogretmen w : km) {
                System.out.printf("           | %-15s          %-25s      %-10s          %-15s       %-9s|\n", w.getTcNo(), w.name, w.cinsiyet, w.ogrtmnBransi, w.ogrtSorumluOlduguSinif);
            }
        }
    }




}