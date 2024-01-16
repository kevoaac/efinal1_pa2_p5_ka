package com.uce.edu.service;

import com.uce.edu.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaService {
    void registrar(CuentaBancaria cuentaBancaria);
    CuentaBancaria buscarPorNumero(String numero);
    void actualizar(CuentaBancaria cuentaBancaria);
}
