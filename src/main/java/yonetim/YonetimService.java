package yonetim;

import entity.Entity;
import user.*;

import java.util.Scanner;

public class YonetimService {





    public void yonetim(Scanner sc){

        int select=-1;

        do{

            showMenu();

            select= sc.nextInt();

            switch (select){

                case 1:
                    showOperationStd(sc,select);
                    break;
                case 2:
                    showOperationTec(sc,select);
                    break;
                case 0:
                    break;
                default:
                    System.out.println();
                    System.out.println("Lutfen gecerli bir tercih giriniz...");
            }

        }while (select!=0);


        System.out.println("\nBir Ust Menuye Yonlendiriliyorsunuz...");


    }


    public void showMenu(){
        System.out.println("\n---------------------------------------------------------------------------");
        System.out.println("||                =============   YONETIM   =============                ||");
        System.out.println("---------------------------------------------------------------------------\n");
        System.out.println("||     1 - Ogrenci Islemleri \n\n||     2 - Ogretmen Islemleri \n\n||     0 - CIKIS");
        System.out.println("\n----------------------------------------------------------------------------");
        System.out.println("||                   ---------  TERCIHINIZ  --------                     ||");
        System.out.println("----------------------------------------------------------------------------\n");
        System.out.print("------- >>>> ");
    }




    public  void showOperationStd( Scanner sc, int cikis){

        StudentService st=new StudentService();
        Ogrenci o = new Ogrenci();

        int select= -1;


        do{
            showOpMenu();
            select=sc.nextInt();
            switch (select){
                case 1:
                   st.ekleme(sc,o);
                    break;
                case 2:
                    st.arama(sc);
                    break;
                case 3:
                    st.listeleme(sc);   /// tekrar dene
                    break;
                case 4:
                    st.silme(sc);
                    break;
                case 5:
                    System.out.println("\nAna Menuye Yonlendiriliyorsunuz...\n");
                    cikis=0;
                    select=0;
                    break;
                case 0:
                    System.out.println("\nBir Ust Menuye Yonlendiriliyorsunuz...\n");
                    break;
                default:
                    System.out.println("Lutfen Gecerli Bir Tercih Yapiniz...");
            }

        }while (select!=0);

        }

    public  void showOperationTec( Scanner sc, int cikis) {

        TeacherService tech = new TeacherService();
        Ogretmen o = new Ogretmen();

        int select = -1;


        do {
            showOpMenu();
            select = sc.nextInt();
            switch (select) {
                case 1:
                    tech.ekleme(sc, o);
                    break;
                case 2:
                    tech.arama(sc);
                    break;
                case 3:
                    tech.listeleme(sc);
                    break;
                case 4:
                    tech.silme(sc);
                    break;
                case 5:
                    System.out.println("\nAna Menuye Yonlendiriliyorsunuz...\n");
                    cikis = 0;
                    select = 0;
                    break;
                case 0:
                    System.out.println("\nBir Ust Menuye Yonlendiriliyorsunuz...\n");
                    break;
                default:
                    System.out.println("Lutfen Gecerli Bir Tercih Yapiniz...");
            }

        } while (select != 0);

    }
        public void showOpMenu(){

            System.out.println("============                 Lutfen Yapmak Istediginiz Islemi Secin            ==========\n");
            System.out.println("---------------------------------------------------------------------------------------- \n");
            System.out.println("  1 - EKLE \n  2 - ARAMA \n  3 - LISTELEME \n  4 - SILME \n  5 - ANAMENU \n  0 - CIKIS\n");
            System.out.println("---------------------------------------------------------------------------------------- \n");
            System.out.print("------   >>>>>>>>");

    }

}
