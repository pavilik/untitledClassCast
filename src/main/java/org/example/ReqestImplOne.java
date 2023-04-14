package org.example;

public class ReqestImplOne implements Request {

Integer poleOne;

    public Integer getPoleOne() {
        return poleOne;
    }

    public void setPoleOne(Integer poleOne) {
        this.poleOne = poleOne;
    }

    @Override
    public String toString() {
        return poleOne.toString()+ "ImplONE";
    }

    @Override
    public String getStr(String str) {
        System.out.printf("impl1 ");
        return str+" Impl1";
    }
}
