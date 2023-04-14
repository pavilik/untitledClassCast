package org.example;

public class ForStat {
    public static ReqestImplOne castToOne (Request request)
    {
        return (ReqestImplOne) request;
    }


    public static RequestSecondImpl castToSecond (Request request)
    {
        return (RequestSecondImpl) request;
    }
}
