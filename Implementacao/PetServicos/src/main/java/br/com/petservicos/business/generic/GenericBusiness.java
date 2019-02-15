package br.com.petservicos.business.generic;

import br.com.petservicos.business.generic.exception.GenericBusinessException;
import br.com.petservicos.dao.mybatis.PaginatedList;
import br.com.petservicos.domain.GenericDomain;
import java.util.List;

/**
 * Default Service interface for the default application operations.
 * 
 * @author Lina
 *
 * @param <E>
 * @param <T>
 */
public interface GenericBusiness<E extends GenericDomain, T extends GenericBusinessException> {

	String REFLECTION_ERROR_LOG_MESSAGE = "architecture.service.reflection.exception";
	String ARCHITECTURE_SERVICE_DUPLICATEKEY_ADD = "architecture.service.duplicatekey.add";
	String ARCHITECTURE_SERVICE_DUPLICATEKEY_UPDATE = "architecture.service.duplicatekey.update";
	String KEY_DATA_INTEGRITY_VIOLATION = "architecture.service.relatedregistry.delete";

	/**
	 * Default generic add method.
	 * 
	 * @param entity
	 * @throws T
	 */
	void add(E entity) throws T;

	/**
	 * Default generic update method.
	 * 
	 * @param entity
	 * @throws T
	 */
	void update(E entity) throws T;

	/**
	 * Default generic delete method.
	 * 
	 * @param entity
	 * @throws T
	 */
	void delete(E entity) throws T;

	/**
	 * Default generic delete method based on list.
	 * 
	 * @param listEntities
	 * @throws T
	 */
	void deleteList(List<E> listEntities) throws T;

	/**
	 * Default method to return a entity based on its ID.
	 * 
	 * @param entity
	 * @return
	 * @throws T
	 */
	E getById(E entity) throws T;

	/**
	 * Default method to return a entity based on one or more of its fields.
	 * The chosen criteria will be specified on the mybatis xml file.
	 * 
	 * @param entity
	 * @return
	 * @throws T
	 */
	E getByField(E entity) throws T;

	/**
	 * Default method to return a list of an entity.
	 * The chosen criteria will be specified on the mybatis xml file.
	 * 
	 * @param entity
	 * @return
	 * @throws T
	 */
	List<E> list(E entity) throws T;

	/**
	 * Default method to return a list of an entity.
	 * The chosen criteria will be specified on the mybatis xml file.
	 * These criteria must use the LIKE operator.
	 * 
	 * @param entity
	 * @return
	 * @throws T
	 */
	List<E> listLike(E entity) throws T;

	/**
	 * Default method to return a list of an entity.
	 * The chosen criteria will be specified on the mybatis xml file.
	 * These criteria must use the LIKE operator and the LIMIT operator to avoid
	 * a large data collection to be sent to the view.
	 * 
	 * @param entity
	 * @return
	 * @throws T
	 */
	List<E> autoComplete(E entity) throws T;

	/**
	 * Method that returns a custom list object that is paginated on demand.
	 * 
	 * @param entity
	 * @param paginatedList
	 * @return
	 * @throws T
	 */
	List<E> paginatedList(E entity, PaginatedList<E> paginatedList) throws T;

	/**
	 * Default list method without parameters.
	 * 
	 * @return
	 * @throws T
	 */
	List<E> list() throws T;

}
