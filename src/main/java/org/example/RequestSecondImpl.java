package org.example;

public class RequestSecondImpl implements Request{
    Integer poleSecond;
    public Integer getPoleOne() {


        return poleSecond;
    }

    public void setPoleOne(Integer poleOne) {
        this.poleSecond = poleSecond;
    }

    @Override
    public String toString() {
        return poleSecond.toString()+ "ImplSecond";
    }

    @Override
    public String getStr(String str) {
        System.out.printf("impl2 ");
        return str+" Second2";
    }
}
