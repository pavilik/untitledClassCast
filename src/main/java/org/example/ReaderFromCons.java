package org.example;

import java.util.Scanner;

public class ReaderFromCons {

     static String scans()  {
       Scanner in = new Scanner(System.in);
       int num = in.nextInt();
       int num2 = in.nextInt();
       String result = (num + num2) + "\n" + num * num2 ;
       System.out.println(result);
       return result;

   }
}
