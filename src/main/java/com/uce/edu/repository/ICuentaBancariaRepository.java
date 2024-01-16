package com.uce.edu.repository;

import com.uce.edu.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaRepository {
    void insertar(CuentaBancaria cuentaBancaria);
    CuentaBancaria seleccionarPorNumero(String numero);
    void actualizar(CuentaBancaria cuentaBancaria);
    void eliminar(Integer id);
}
