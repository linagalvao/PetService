/*
 * Copyright (c) 2014 LG Eletronics. All Rights Reserved. This software is the
 * confidential and proprietary information of LG Eletronics. You shall not
 * disclose such Confidential Information and shall use it only in accordance
 * with the terms of the license agreement you entered into with LG Eletronics.
 */
package br.com.petservicos.business.generic;

import br.com.petservicos.business.generic.exception.GenericBusinessException;
import br.com.petservicos.business.utilitarios.InvokeEntiteValidation;
import br.com.petservicos.business.utilitarios.InvokeEntiteValidationException;
import br.com.petservicos.dao.generic.GenericDao;
import br.com.petservicos.dao.mybatis.PaginatedList;
import br.com.petservicos.domain.GenericDomain;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.logging.Level;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Default abstract Service implementations for the default application
 * operations.
 *
 * @author Lina
 *
 * @param <E>
 * @param <T>
 * @param <D>
 */
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public abstract class GenericBusinessImpl<E extends GenericDomain, T extends GenericDao, D extends GenericBusinessException> implements
        GenericBusiness<E, D> {

//    @Autowired
    private T genericDao;

    protected abstract T getGenericDao();

    public GenericBusinessImpl(T genericDao) {
        this.genericDao = genericDao;
    }

    public GenericBusinessImpl() {
    }

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void add(E entity) throws D {
        try {
            InvokeEntiteValidation.insertValidation(entity);
            getGenericDao().add(entity);
        } catch (DuplicateKeyException ex) {
            throw getNewException(ARCHITECTURE_SERVICE_DUPLICATEKEY_ADD);
        } catch (InvokeEntiteValidationException ex) {
           throw getNewException(ex.getMessage());
        }
    }

    @Override
    public void update(E entity) throws D {
        try {
            InvokeEntiteValidation.updateValidation(entity);
            getGenericDao().update(entity);
        } catch (DuplicateKeyException ex) {
            throw getNewException(ARCHITECTURE_SERVICE_DUPLICATEKEY_UPDATE);
        } catch (InvokeEntiteValidationException ex) {
           throw getNewException(ex.getMessage());
        }
    }

    @Override
    public void delete(E entity) throws D {
        try {
            InvokeEntiteValidation.deleteValidation(entity);
            getGenericDao().delete(entity);
        } catch (DataIntegrityViolationException e) {
            throw getNewException(KEY_DATA_INTEGRITY_VIOLATION);
        }catch (InvokeEntiteValidationException ex) {
           throw getNewException(ex.getMessage());
        }
    }

    @Override
    public void deleteList(List<E> listEntities) throws D {
        try {
            for (E entity : listEntities) {
                delete(entity);
            }
        } catch (DataIntegrityViolationException e) {
            throw getNewException(KEY_DATA_INTEGRITY_VIOLATION);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public E getById(E entity) throws D {
        return (E) getGenericDao().getById(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public E getByField(E entity) throws D {
        return (E) getGenericDao().getByField(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<E> list(E entity) throws D {
        List<E> list =getGenericDao().list(entity);
        if(list==null || list.isEmpty()){
            throw getNewException("Nenhum registro encontrado.");
        }
        return list;
    }

    @Override
    @Transactional(readOnly = true)
    public List<E> listLike(E entity) throws D {
        return getGenericDao().listLike(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<E> autoComplete(E entity) throws D {
        return getGenericDao().autoComplete(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public PaginatedList<E> paginatedList(E entity, PaginatedList<E> paginatedList) throws D {
        return getGenericDao().paginatedList(entity, paginatedList);
    }

    /**
     * Method that returns a instance of the parameterized exception type.
     *
     * @param message
     * @return
     */
    @SuppressWarnings("unchecked")
    private D getNewException(String message) {
        try {
            ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
            Class<D> theType = (Class<D>) type.getActualTypeArguments()[2];
            Constructor<D> constructor = theType.getConstructor(String.class);
            return constructor.newInstance(message);
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            logger.error(REFLECTION_ERROR_LOG_MESSAGE + e.getMessage());
        }
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<E> list() throws D {
        return getGenericDao().list(null);
    }

    /**
     * Returns genericDaoImpl class.
     *
     * @return
     */
//    @SuppressWarnings("unchecked")
//    private Class<T> getDaoClass() {
//        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
//        return (Class<T>) type.getActualTypeArguments()[1];
//    }
//
//    /**
//     * @return the genericDao
//     */
//    protected T getGenericDao() {
//        if (genericDao == null) {
//            Class<T> classService = getDaoClass();
//            genericDao = appContext.getBean(classService);
//        }
//        return genericDao;
//    }

    /**
     * @param genericDao the genericDao to set
     */
//    protected void setGenericDao(T genericDao) {
//        this.genericDao = genericDao;
//    }
}
