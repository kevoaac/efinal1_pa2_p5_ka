package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Propietario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class PropietarioRepositoryImpl implements IPropietarioRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void insertar(Propietario propietario) {
        this.entityManager.persist(propietario);
    }

    @Override
    public Propietario seleccionarPorCedula(String cedula) {
        TypedQuery<Propietario> myQuery = this.entityManager.createQuery("SELECT p FROM Propietario p WHERE p.cedula = :cedula", Propietario.class);
        myQuery.setParameter("cedula", cedula);
        return myQuery.getResultList().get(0);
    }

    @Override
    public void actualizar(Propietario propietario) {
        this.entityManager.merge(propietario);
    }

    @Override
    public void eliminar(Integer id) {
        this.entityManager.remove(id);
    }
}
