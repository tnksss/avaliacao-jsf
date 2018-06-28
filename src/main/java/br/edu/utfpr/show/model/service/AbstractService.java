package br.edu.utfpr.show.model.service;

import java.util.List;
import br.edu.utfpr.show.model.dao.AbstractDAO;
import br.edu.utfpr.show.util.JPAUtil;

public class AbstractService<PK, T> {

    protected AbstractDAO<PK, T> dao;

    public boolean save(T entity) {
        boolean isSuccess = true;
        try {
            JPAUtil.beginTransaction();
            dao.save(entity);
            JPAUtil.commit();
        } catch (Exception e) {
            JPAUtil.rollBack();
            isSuccess = false;
        } finally {
            JPAUtil.closeEntityManager();
        }
        return isSuccess;
    }

    public boolean update(T entity) {
        boolean isSuccess = true;
        try {
            JPAUtil.beginTransaction();
            dao.update(entity);
            JPAUtil.commit();
        } catch (Exception e) {
            JPAUtil.rollBack();
            isSuccess = false;
        } finally {
            JPAUtil.closeEntityManager();
        }
        return isSuccess;
    }

    public boolean delete(T entity) {
        boolean isSuccess = true;
        try {
            JPAUtil.beginTransaction();
            dao.delete(entity);
            JPAUtil.commit();
        } catch (Exception e) {
            JPAUtil.rollBack();
            isSuccess = false;
            e.printStackTrace();
        } finally {
            JPAUtil.closeEntityManager();
        }
        return isSuccess;
    }

    public T getById(PK pk) {
        T entity = null;

        try {
            JPAUtil.beginTransaction();
            entity = dao.getById(pk);
            JPAUtil.commit();
        } catch (Exception e) {
            JPAUtil.rollBack();
        } finally {
            JPAUtil.closeEntityManager();
        }

        return entity;
    }

    public T getByProperty(String propertyName, String propertyValue) {
        T entity = null;
        try {
            JPAUtil.beginTransaction();
            entity = dao.getByProperty(propertyName, propertyValue);
            JPAUtil.commit();
        } catch (Exception e) {
            JPAUtil.rollBack();
        } finally {
            JPAUtil.closeEntityManager();
        }

        return entity;
    }

    public List<T> findAll() {
        List<T> list = null;
        try {
            JPAUtil.beginTransaction();
            list = dao.findAll();
            JPAUtil.commit();
        } catch (Exception e) {
            JPAUtil.rollBack();
        } finally {
            JPAUtil.closeEntityManager();
        }

        return list;
    }
}
