package com.epam.tm.news.service;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    private String mes;

    public TestService() {
        this.mes = "HelloWorld It's spring yo yo)";
    }


    public String getMes() {
        return mes;
    }
}
