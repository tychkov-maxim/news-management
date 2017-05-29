package com.epam.tm.dao;

import com.epam.tm.news.dao.NewsDao;
import com.epam.tm.news.entity.News;
import org.hibernate.SessionFactory;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/config.xml")
@Transactional
public class DaoTest {

    @Autowired
    SessionFactory sessionFactory;

    @Qualifier("hibernateNewsDao")
    @Autowired
    NewsDao newsDao;

    @Test
    public void savedNewsShouldHaveIdAfterSaving() throws Exception {
        News news = new News();
        newsDao.save(news);
        assertNotEquals(0, news.getId());
    }

    @Test
    public void crudTest() throws Exception {
        News news = new News();
        newsDao.save(news);
        News savedNews = newsDao.fetchById(news.getId());
        assertNotNull(savedNews);
        assertEquals(news, savedNews);

        newsDao.remove(news);
        News deletedNews = newsDao.fetchById(news.getId());
        assertNull(deletedNews);
    }

    @Test
    public void gottenListShouldBeNotNull() throws Exception{
        List allNewsOrderByDate = newsDao.getAllNewsOrderByDate();
        assertNotNull(allNewsOrderByDate);
    }


}
