package org.example;

public class Main {
    public static void main(String[] args) {


        ReqestImplOne reqestImplOne = new ReqestImplOne();

        RequestSecondImpl requestSecond = ForStat.castToSecond(reqestImplOne);

        System.out.printf(requestSecond.toString());


    }

}