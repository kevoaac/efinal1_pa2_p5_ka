package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Propietario;

public interface IPropietarioRepository {
    void insertar(Propietario propietario);
    Propietario seleccionarPorCedula(String cedula);
    void actualizar(Propietario propietario);
    void eliminar(Integer id);
}
