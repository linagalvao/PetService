package br.com.petservicos.dao.generic;

import br.com.petservicos.dao.mybatis.PaginatedList;
import br.com.petservicos.domain.GenericDomain;
import java.util.List;
import org.springframework.stereotype.Repository;


/**
 * Generic DAO interface to define default database operations.
 * 
 * @author Lina
 *
 * @param <E>
 */
public interface GenericDao<E extends GenericDomain> {

	/**
	 * Generic add method for insert operation.
	 * 
	 * @param entity
         * @return 
	 */
	int add(E entity);

	/**
	 * Generic update method for update operation.
	 * 
	 * @param entity
         * @return 
	 */
	int update(E entity);

	/**
	 * Generic delete method for delete method.
	 * 
	 * @param entity
         * @return 
	 */
	int delete(E entity);

	/**
	 * Generic getEntity by Id to return an entity based on the ID field.
	 * 
	 * @param entity
	 * @return
	 */
	E getById(E entity);

	/**
	 * Generic getEntity by Field to return an entity based on a field of the entity.
	 * 
	 * @param entity
	 * @return
	 */
	E getByField(E entity);

	/**
	 * Generic list to return a list of the typed entity.
	 * 
	 * @param entity
	 * @return
	 */
	List<E> list(E entity);

	/**
	 * Generic list to return a list of the typed entity and the select filter
	 * must be created with LIKE operator of the database.
	 * 
	 * @param entity
	 * @return
	 */
	List<E> listLike(E entity);

	/**
	 * Generic list method to attend the autocomplete functionality. The filter
	 * for an autocomplete MUST HAVE a LIMIT clause to 50 rows max.
	 * 
	 * @param entity
	 * @return
	 */
	List<E> autoComplete(E entity);

	/**
	 * Generic Paginated list method to returns list paginated by the size of the page setted on the
	 * PaginatedList object.
	 * 
	 * @param entity
	 * @param paginatedList
	 * @return
	 */
	PaginatedList<E> paginatedList(E entity, PaginatedList<E> paginatedList);

}
