/*
 * Copyright (c) 2014 LG Eletronics. All Rights Reserved. This software is the
 * confidential and proprietary information of LG Eletronics. You shall not
 * disclose such Confidential Information and shall use it only in accordance
 * with the terms of the license agreement you entered into with LG Eletronics.
 */
package br.com.petservicos.dao.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.dao.DataAccessException;

/**
 * Paginated DAO support class that extends SqlSessionDaoSupport to inject MyBatis sessionTemplate
 * to allow the database operations.
 * 
 * @author Lina
 *
 * @param <E>
 */
public class PaginatedDaoSupportMyBatis<E> extends SqlSessionDaoSupport {

	private static final String TERM_PAGESIZE = "pageSize";
	private static final String TERM_OBJECT = "object";
	private static final String TERM_FIRST = "first";
	private static final String TERM_COUNT = "Count";
	private static final String CHAR_POINT = ".";
	private static final String TERM_FILTERS = "filters";
	public String idSelect = "paginatedList";

	/**
	 * Defaul constructor.
	 */
	public PaginatedDaoSupportMyBatis() {
            super();
	}

	/**
	 * Constructor which receives the SqlSessionTemplate.
	 * 
	 * @param sessionTemplate
	 */
	public PaginatedDaoSupportMyBatis(SqlSessionTemplate sessionTemplate) {
		super.setSqlSessionTemplate(sessionTemplate);
	}

	public SqlSessionTemplate getSqlSessionTemplate() {
		return (SqlSessionTemplate) super.getSqlSession();
	}

	/**
	 * 
	 * This method is resposible to call a specific designed query of the database to retrieve
	 * results based on pages information of the Generic Parameterized Object. <br>
	 * This method performs to queries on the database one to get the data based on the page size
	 * and another to get the total row count for the query e.g. if the query return a total of 1000
	 * registries and the pageSize parameter is 10 it will return 10 registries but the totalCount
	 * will be filled with 1000 value.
	 * 
	 * @param pathMapper Path of the mapper on the MyBatis xml file
	 * @param objectParam Instance of the object that should be sent to the query so it can be used
	 *        as a restrictions parameters
	 * @param paginatedList PaginatedList&lt;E&gt; instance of the typed paginatedList
	 * @return {@link PaginatedList}
	 * @throws DataAccessException
	 */
	@SuppressWarnings("unchecked")
	public PaginatedList<E> queryListPaginatedList(String pathMapper, final Object objectParam, PaginatedList<E> paginatedList)
	throws DataAccessException {

		if (paginatedList == null) {
			paginatedList = new PaginatedList<E>();
		}

		Map<String, Object> parameters = new HashMap<String, Object>();

		if (paginatedList.getPageSize() - (paginatedList.getFirst() + 1) > paginatedList.getPageSize()) {
			if (paginatedList.getFirst() + 1 == 1) {
				paginatedList.setPageSize(paginatedList.getFirst() + paginatedList.getPageSize());
			} else {
				paginatedList.setFirst(paginatedList.getPageSize() - paginatedList.getPageSize());
			}
		}

		parameters.put(TERM_OBJECT, objectParam);
		parameters.put(TERM_FIRST, paginatedList.getFirst());
		parameters.put(TERM_PAGESIZE, paginatedList.getPageSize());

		paginatedList.setTotalCount(0);
		Integer totalCount = this.getSqlSessionTemplate().selectOne(pathMapper + CHAR_POINT + idSelect + TERM_COUNT, parameters);
		paginatedList.setTotalCount(totalCount);

		/**
		 * This avoid the query to run if the count query returns 0
		 */
		if (paginatedList.getTotalCount() > 0) {
			paginatedList.clear();
			paginatedList.addAll((List<E>) this.getSqlSessionTemplate().selectList(pathMapper + CHAR_POINT + idSelect, parameters));
		}

		return paginatedList;
	}

	/**
	 * This method overrides queryListPaginatedList allowing the programmer to inform the id
	 * of the query on the MyBatis xml file so it can do more than one paginated search.
	 * 
	 * @param pathMapper Path of the mapper on the MyBatis xml file
	 * @param idSelect Id of the query to be called on the MyBatis xml file
	 * @param objectParam Instance of the object that should be sent to the query so it can be used
	 *        as a restrictions parameters
	 * @param paginatedList PaginatedList&lt;E&gt; instance of the typed paginatedList
	 * @return {@link PaginatedList}
	 * @throws DataAccessException
	 */
	public PaginatedList<E> queryListPaginatedList(String pathMapper, String idSelect, final Object objectParam, PaginatedList<E> paginatedList)
	throws DataAccessException {
		this.idSelect = idSelect;
		return queryListPaginatedList(pathMapper, objectParam, paginatedList);
	}

	/**
	 * This method is resposible to call a specific designed query of the database to retrieve
	 * results based on pages information of the Any Parameterized Object. <br>
	 * This method performs to queries on the database one to get the data based on the page size
	 * and another to get the total row count for the query e.g. if the query return a total of 1000
	 * registries and the pageSize parameter is 10 it will return 10 registries but the totalCount
	 * will be filled with 1000 value.<br>
	 * The PaginatedList object can be parameterized with any object e.g. List&lt;Map&gt;
	 * 
	 * @param pathMapper Path of the mapper on the MyBatis xml file
	 * @param idSelect Id of the query to be called on the MyBatis xml file
	 * @param objectParam Instance of the object that should be sent to the query so it can be used
	 *        as a restrictions parameters
	 * @param paginatedList PaginatedList&lt;E&gt; instance of the typed paginatedList
	 * @return {@link PaginatedList}
	 * @throws DataAccessException
	 */
	@SuppressWarnings("unchecked")
	public <G> PaginatedList<G> queryListPaginated(String pathMapper, String idSelect, final Object objectParam, PaginatedList<G> paginatedList)
	throws DataAccessException {
		this.idSelect = idSelect;

		if (paginatedList == null) {
			paginatedList = new PaginatedList<G>();
		}

		Map<String, Object> parameters = new HashMap<String, Object>();

		if (paginatedList.getPageSize() - (paginatedList.getFirst() + 1) > paginatedList.getPageSize()) {
			if (paginatedList.getFirst() + 1 == 1) {
				paginatedList.setPageSize(paginatedList.getFirst() + paginatedList.getPageSize());
			} else {
				paginatedList.setFirst(paginatedList.getPageSize() - paginatedList.getPageSize());
			}
		}

		parameters.put(TERM_OBJECT, objectParam);
		parameters.put(TERM_FIRST, paginatedList.getFirst());
		parameters.put(TERM_PAGESIZE, paginatedList.getPageSize());
		/**
		 * The jsf sends nested objects as
		 * objectName + "." + fieldName
		 * Mybatis.xml can't process nested maps objects with "." e.g. filters.namedEntity.value
		 * So we change the map key name replacing dots by underlines e.g. filters.namedEntity_value
		 */
		Map<String, Object> mapFilters = new HashMap<String, Object>();
		for (Entry<String, Object> item : paginatedList.getFilters().entrySet()) {
			mapFilters.put(item.getKey().replaceAll("\\.", "_"), item.getValue());
		}
		parameters.put(TERM_FILTERS, mapFilters);

		paginatedList.setTotalCount(0);
		Integer totalCount = this.getSqlSessionTemplate().selectOne(pathMapper + CHAR_POINT + idSelect + TERM_COUNT, parameters);
		paginatedList.setTotalCount(totalCount);

		/**
		 * This avoid the query to run if the count query returns 0
		 */
		if (paginatedList.getTotalCount() > 0) {
			paginatedList.clear();
			paginatedList.addAll((List<G>) this.getSqlSessionTemplate().selectList(pathMapper + CHAR_POINT + idSelect, parameters));
		}

		return paginatedList;
	}
}