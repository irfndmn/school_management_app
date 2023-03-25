package entity;

import yonetim.YonetimService;

import java.util.Scanner;

public class Entity {




    public void start(){


        Scanner sc = new Scanner(System.in);
        YonetimService y=new YonetimService();
        int select=-1;


        do{
            showMenu();
            select= sc.nextInt();
            switch (select){
                case 1:
                    System.out.println("This Menu Is Private... You can only select 3");
                    break;
                case 2:
                    System.out.println("This  Menu Is Private.. You can only select 3");
                    break;
                case 3:
                    y.yonetim(sc);
                    break;

                case 0:
                    System.out.println("\nSistemden Cikis Yapiliyor...\n");
                    System.out.println("Tesekkurler...");
                    break;
                default:
                    System.out.println("\nLutfen Gecerli Bir Tercih yapiniz...");
            }




        }while(select!=0);





    }
    public static void showMenu(){
        System.out.println();
        System.out.println("=================================================================================================");
        System.out.println("||-----------  >>>>>>>>>   ||  OKUL  YONETIM  SISTEMINE HOSGELDINIZ   ||  <<<<<<<   ---------- ||   ");
        System.out.println("-------------------------------------------------------------------------------------------------\n");

        System.out.println("       1  -  Veli Girisi\n\n       2  -  Ogretmen Girisi\n\n       3  -  Yonetim\n\n       0  -  CIKIS\n\n");
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("||--------------------------- >>>>>>>> || TERCIHINIZ || <<<<<<<< ----------------------------- ||");
        System.out.println("=================================================================================================\n");
        System.out.print("----->>>> ");


    }


}
