package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Transferencia;

import java.util.List;

public interface ITransferenciaRepository {
    void insertar(Transferencia transferencia);
    List<Transferencia> listar();
}
