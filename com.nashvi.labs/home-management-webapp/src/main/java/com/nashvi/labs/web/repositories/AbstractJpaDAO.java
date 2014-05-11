package com.nashvi.labs.web.repositories;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * @author labs-nashvi
 * 
 * <pre>
 * <b>Description:</b>
 * Abstract JPA based DAO class for common generic operations. 
 * </pre>
 * @param <T> Entity.class
 */
public abstract class AbstractJpaDAO <T extends Serializable >
{

    private Class < T > clazz;

    @PersistenceContext ( unitName = "emf" )
    private EntityManager entityManager;

    /**
     * Set the Entity class to be queried.
     * 
     * @param clazzToSet
     */
    public void setClazz ( Class < T > clazzToSet )
    {
        this.clazz = clazzToSet;
    }

    /**
     * Find the primary key record
     * 
     * @param id - primary key
     * @return the primary key record.
     */
    public T findById ( Object id )
    {
        return this.entityManager.find ( this.clazz, id );
    }

    /**
     * Find all <code>Entity</code> records.
     * 
     * @return all records from the table
     */
    public List < T > findAll ( )
    {
        return this.entityManager.createQuery ( "from " + this.clazz.getName ( ) ).getResultList ( );
    }

    /**
     * Execute query to load list of <code>Entity</code>.
     * 
     * @param queryString - JPA query
     * @return - list of records
     */
    protected List < T > executeQuery ( String queryString )
    {
        return this.entityManager.createQuery ( queryString ).getResultList ( );
    }

    /**
     * Get a single record for the query.
     * 
     * @param queryString JPA query
     * @return a record for the query
     */
    protected T findOne ( String queryString )
    {
        return ( T ) this.entityManager.createQuery ( queryString ).getSingleResult ( );
    }

    /**
     * Save / Persist / Create
     * 
     * @param entity to persist or create
     */
    public void save ( T entity )
    {
        this.entityManager.persist ( entity );
    }

    /**
     * Update or Merge
     * 
     * @param entity to save or merge
     */
    public void update ( T entity )
    {
        this.entityManager.merge ( entity );
    }

    /**
     * Delete
     * 
     * @param entity to delete
     */
    public void delete ( T entity )
    {
        this.entityManager.remove ( entity );
    }

    /**
     * Delete entity by primary key id.
     * 
     * @param entityId key column
     */
    public void deleteById ( Object entityId )
    {
        T entity = this.findById ( entityId );

        this.delete ( entity );
    }

    protected Query createQuery ( String queryString )
    {
        return this.entityManager.createQuery ( queryString );
    }

    protected List < T > executeQueryWithParameterArray ( String queryString, Object[ ] params )
    {
        Query query = createQuery ( queryString );
        if ( params != null )
        {
            for ( int i = 0; i < params.length; ++i )
            {
                query.setParameter ( i + 1, params[i] );
            }
        }
        return query.getResultList ( );
    }

    /**
     * Set named parameters in the query and execute to return <code>Entity</code> list.
     * 
     * @param queryString
     * @param paramMap parameter map with <code>Key,Value</code> pair.
     * @return List of <code>Entity</code> records.
     */
    protected List < T > executeQueryWithNamedParameter ( String queryString, final Map < String, Object > paramMap )
    {
        Query query = createQuery ( queryString );
        if ( paramMap != null )
        {
            for ( Map.Entry < String, Object > entry : paramMap.entrySet ( ) )
            {
                query.setParameter ( entry.getKey ( ), entry.getValue ( ) );
            }
        }
        return query.getResultList ( );
    }

}