package sk.stuba.fei.uim.oop.utility;

import java.io.*;
import java.util.Random;

public class ZKlavesnice {

    public static char readChar(String napis_pre_uzivatela) {
        char c = ' ';

        InputStreamReader zklavesnice = new InputStreamReader(System.in);
        try {
            System.out.println(napis_pre_uzivatela);
            c = (char) zklavesnice.read();
            //System.out.println("Nacital som " + c);
        } catch (Exception e) {
            System.out.println("nepodarilo sa");
            c = readChar(napis_pre_uzivatela);
        }

        return c;
    }

    public static String readString(String napis_pre_uzivatela) {
        String s = "";

        BufferedReader zklavesnice = new BufferedReader(new InputStreamReader(System.in));
        try {	System.out.println(napis_pre_uzivatela);
            s = zklavesnice.readLine();
            //System.out.println("Nacital som " + s);
        } catch (Exception e) {
            System.out.println("nepodarilo sa");
            s = readString(napis_pre_uzivatela);
        }

        return s;
    }

    public static int readInt(String napis_pre_uzivatela, int diapason) {
        int n = 0;
        String s;

//        BufferedReader zklavesnice = new BufferedReader(new InputStreamReader(System.in));
//        try {	System.out.println(napis_pre_uzivatela);
//            s = zklavesnice.readLine();
//            //System.out.println("Nacital som " + s);
//            n = Integer.parseInt(s);
//        } catch (Exception e) {
//            System.out.println("nepodarilo sa");
//            n = readInt(napis_pre_uzivatela, diapason);
//        }

        var aa = new Random();
        n = aa.nextInt(6) + 1;
        while (n < 1 || n > diapason)
        {
            System.out.println("nepodarilo se");
            n = aa.nextInt(6) + 1;
        }

        return n;
    }

    public static double readDouble(String napis_pre_uzivatela) {
        double x = 0.0;
        String s;

        BufferedReader zklavesnice = new BufferedReader(new InputStreamReader(System.in));
        try {	System.out.println(napis_pre_uzivatela);
            s = zklavesnice.readLine();
            //System.out.println("Nacital som " + s);
            x = Double.parseDouble(s);
        } catch (Exception e) {
            System.out.println("nepodarilo sa");
            x = readDouble(napis_pre_uzivatela);
        }

        return x;
    }
}
