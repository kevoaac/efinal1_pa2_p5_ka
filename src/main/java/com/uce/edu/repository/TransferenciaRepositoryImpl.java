package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Transferencia;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class TransferenciaRepositoryImpl implements ITransferenciaRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertar(Transferencia transferencia) {
        this.entityManager.persist(transferencia);
    }

    @Override
    public List<Transferencia> listar() {
        TypedQuery<Transferencia> myQuery = this.entityManager.createQuery("SELECT t FROM Transferencia t", Transferencia.class);

        return myQuery.getResultList();
    }
}
