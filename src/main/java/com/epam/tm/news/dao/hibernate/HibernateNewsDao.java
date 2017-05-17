package com.epam.tm.news.dao.hibernate;

import com.epam.tm.news.dao.NewsDao;
import com.epam.tm.news.entity.News;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class HibernateNewsDao extends HibernateDao<News> implements NewsDao {

    @Override
    public News findById(long id) {
        return sessionFactory.getCurrentSession().get(News.class,id);
    }

    @Override
    public List<News> getAllNewsOrderByDate() {
        Query query = sessionFactory.getCurrentSession().createQuery("from News order by date");
        return query.list();
    }
}
