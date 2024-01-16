package com.uce.edu.repository;

import com.uce.edu.repository.modelo.CuentaBancaria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CuentabancariaRepositoryImpl implements ICuentaBancariaRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertar(CuentaBancaria cuentaBancaria) {
        this.entityManager.persist(cuentaBancaria);
    }

    @Override
    public CuentaBancaria seleccionarPorNumero(String numero) {
        TypedQuery<CuentaBancaria> myQuery = this.entityManager.createQuery("SELECT cb FROM CuentaBancaria cb WHERE cb.numero = :numero", CuentaBancaria.class);
        myQuery.setParameter("numero", numero);
        return myQuery.getResultList().get(0);
    }

    @Override
    public void actualizar(CuentaBancaria cuentaBancaria) {
        this.entityManager.merge(cuentaBancaria);
    }

    @Override
    public void eliminar(Integer id) {
        this.entityManager.remove(id);
    }
}
