package io.altar.repository;
import io.altar.models.BaseEntity;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Collection;


public abstract class EntityRepository<T extends BaseEntity> {
	
	@PersistenceContext
	protected EntityManager entityManager;
	//atributos antigos
	/*private Map<Long, T> map = new HashMap<Long, T>();
	private long currentId = 0;

	private long nextId(){
		currentId++;
		return currentId;
	}*/
	//A função deleteEntityById está MAL!
	
	
	public void deleteEntity(BaseEntity entity) {
		entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
	}
	public T changeEntity(T entity) {
		return entityManager.merge(entity);
	}

	public T createEntity(T entity) {
		return entityManager.merge(entity);
	}
	
	public T findById(long id){
		return entityManager.find(getEntityClass(),id);
	}
	
	public List<T> getAll() {
		return entityManager.createNamedQuery(getAllEntityQueryName(), getEntityClass()).getResultList();
	}
	
	
	protected abstract Class<T> getEntityClass();
	protected abstract String getAllEntityQueryName();
	
	
	
	//Lista de funções desactualizadas!
	
	/*public long createEntity(T entity) {
		entity.setId(currentId);
		map.put(entity.getId(), entity);
		nextId();
		return entity.getId();
	}
	public T fetchEntityById(Long id) {
		return map.get(id);
	}
	public void deleteEntityById(Long id) {
		map.remove(id);
	}
	public void changeEntityById(T entity) {
		map.replace(entity.getId(), entity);
	}
	public Map <Long, T> getMap() {
		return map;
	}
	public   Collection<T> showAll(){
		return map.values();
	}*/
}
