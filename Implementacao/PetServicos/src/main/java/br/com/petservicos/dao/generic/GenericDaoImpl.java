package br.com.petservicos.dao.generic;

import br.com.petservicos.dao.mybatis.PaginatedDaoSupportMyBatis;
import br.com.petservicos.dao.mybatis.PaginatedList;
import br.com.petservicos.domain.GenericDomain;
import br.com.petservicos.domain.Servico;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Generic DAO class to handle default database operations.
 *
 * @author Lina
 *
 * @param <E>
 */
public class GenericDaoImpl<E extends GenericDomain> extends PaginatedDaoSupportMyBatis<E> implements GenericDao<E> {

    private static final String CHAR_POINT = ".";

    @Override
    public int add(E entity) {
        return getSqlSessionTemplate().insert(getMapper("insert"), entity);
    }

    @Override
    public int update(E entity) {
        return getSqlSessionTemplate().update(getMapper("update"), entity);
    }

    @Override
    public int delete(E entity) {
        return getSqlSessionTemplate().delete(getMapper("delete"), entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public E getById(E entity) {
        return (E) getSqlSessionTemplate().selectOne(getMapper("getById"), entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public E getByField(E entity) {
        return (E) getSqlSessionTemplate().selectOne(getMapper("getByField"), entity);
    }

    @Override
    public List<E> list(E entity) {
        List<E> l = getSqlSessionTemplate().selectList(getMapper("select"), entity);
        return l;
    }

    @Override
    public List<E> listLike(E entity) {
        return getSqlSessionTemplate().selectList(getMapper("listLike"), entity);
    }

    @Override
    public List<E> autoComplete(E entity) {
        return getSqlSessionTemplate().selectList(getMapper("autoComplete"), entity);
    }

    @Override
    public PaginatedList<E> paginatedList(E entity, PaginatedList<E> paginatedList) {
        return queryListPaginatedList(getNameSpaceMapper(), "paginatedList" + getEntityClass().getSimpleName(), entity, paginatedList);
    }

    /**
     * Default SqlSessionTemplate method to inject this propertier from spring
     * configuration.
     *
     * @param sessionTemplate
     */
    @Autowired
    public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
        super.setSqlSessionTemplate(sessionTemplate);
    }

    public SqlSessionTemplate getSessionTemplate() {
        return super.getSqlSessionTemplate();
    }

    /**
     * Método utilizado para retornar o mapper correto de acordo com a operação.
     *
     * @param operacao
     * @return mapper
     */
    public String getMapper(String operacao) {
        return getNameSpaceMapper() + CHAR_POINT + operacao;
    }

    /**
     * Format the Mybatis xml id operation with the given operation name and the
     * name of the parameterized Type class.
     *
     * @param operation
     * @return
     */
    public String getIdSQLInstruction(String operation) {
        return CHAR_POINT + operation + getEntityClass().getSimpleName();
    }

    /**
     * Returns the mybatis namespace for the current DAO Entity.
     *
     * @return
     */
    public String getNameSpaceMapper() {
        return (getClass().getPackage().getName() + CHAR_POINT + getEntityClass().getSimpleName() + "Dao").replaceAll("\\.impl", "");
    }

    /**
     * Return the Class Type instance from the parameterized type.
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    protected Class<E> getEntityClass() {
        ParameterizedType tipo = (ParameterizedType) getClass().getGenericSuperclass();
        return (Class<E>) tipo.getActualTypeArguments()[0];
    }

}
