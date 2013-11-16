package com.sdicons;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "helloService")
public class SoapService {
    public String hello(@WebParam(name="name") String name) {
        if(name == null) name = "World";
        return String.format("SOAP Service - Hello %s!", name);
    }
}
