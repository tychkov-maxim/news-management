package com.epam.tm.news.service;


import com.epam.tm.news.entity.News;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;

@Service
public class TestService {

    @Autowired
    private SessionFactory sessionFactory;
    private String mes;

    public TestService() {
        this.mes = "HelloWorld It's spring yo yo)";
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public void saveSomething(){
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            News news = new News();
            news.setTitle("Hello");
            news.setId(1);
            news.setDate(new Time(0));
            news.setBrief("It's brief");
            news.setContent("It's content");
            session.save(news);
            session.getTransaction().commit();
            session.close();
        }
    }
    public String getMes() {
        return mes;
    }
}
