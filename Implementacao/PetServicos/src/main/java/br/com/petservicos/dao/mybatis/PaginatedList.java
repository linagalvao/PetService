/*
 * Copyright (c) 2015 LG Eletronics. All Rights Reserved. This software is the
 * confidential and proprietary information of LG Eletronics. You shall not
 * disclose such Confidential Information and shall use it only in accordance
 * with the terms of the license agreement you entered into with LG Eletronics.
 */
package br.com.petservicos.dao.mybatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Custom List object to handle pagination lists on the views.
 * 
 * @author Lina
 *
 * @param <E>
 */
public class PaginatedList<E> extends ArrayList<E> {
	private static final long serialVersionUID = 4725484094779721223L;

	private static final Integer NO_TOTAL_COUNT = -1;

	/**
	 * Defines the amount of regitries that the range should return.
	 */
	private static Integer pageSize = 10;
	/**
	 * Defines the start of the search range.
	 */
	private Integer first = 0;
	/**
	 * Total number of registries on the database..
	 */
	private Integer totalCount = NO_TOTAL_COUNT;
	/**
	 * Filters.
	 */
	private Map<String, Object> filters;

	/**
	 * Construtor default.
	 */
	public PaginatedList() {
		super(pageSize);
		this.filters = new HashMap<String, Object>();
	}

	/**
	 * 
	 * @param first
	 */
	public PaginatedList(Integer first) {
		super(pageSize);
		this.first = first;
		this.filters = new HashMap<String, Object>();
	}

	/**
	 * 
	 * @param first
	 * @param maxResults
	 */
	public PaginatedList(Integer first, Integer pageSize) {
		super(pageSize);
		this.first = first;
		PaginatedList.pageSize = pageSize;
		this.filters = new HashMap<String, Object>();
	}

	/**
	 * 
	 * @param first
	 * @param maxResults
	 * @param totalCount
	 */
	public PaginatedList(Integer first, Integer pageSize, Integer totalCount) {
		super(pageSize);
		this.first = first;
		PaginatedList.pageSize = pageSize;
		this.totalCount = totalCount;
		this.filters = new HashMap<String, Object>();
	}

	/**
	 * 
	 * @param first
	 * @param pageSize
	 * @param filters
	 */
	public PaginatedList(Integer first, Integer pageSize, Map<String, Object> filters) {
		this(first, pageSize);
		this.filters = filters;
	}

	public Integer getFirst() {
		return first;
	}

	public void setFirst(Integer first) {
		this.first = first;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		PaginatedList.pageSize = pageSize;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * @return the filters
	 */
	public Map<String, Object> getFilters() {
		return filters;
	}

	/**
	 * @param filters the filters to set
	 */
	public void setFilters(Map<String, Object> filters) {
		this.filters = filters;
	}
}