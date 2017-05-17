package com.epam.tm.news.dao;

import com.epam.tm.news.entity.BaseEntity;

import java.util.List;

public interface Dao <T extends BaseEntity> {
    T save(T entity);

    T findById(long id);

    void delete(T entity);
}
