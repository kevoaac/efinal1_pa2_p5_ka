package com.uce.edu.service;

import com.uce.edu.repository.ICuentaBancariaRepository;
import com.uce.edu.repository.modelo.CuentaBancaria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuentaBancariaServiceImpl implements ICuentaBancariaService{
    @Autowired
    private ICuentaBancariaRepository iCuentaBancariaRepository;
    @Override
    public void registrar(CuentaBancaria cuentaBancaria) {
        this.iCuentaBancariaRepository.insertar(cuentaBancaria);
    }

    @Override
    public CuentaBancaria buscarPorNumero(String numero) {
        return this.iCuentaBancariaRepository.seleccionarPorNumero(numero);
    }

    @Override
    public void actualizar(CuentaBancaria cuentaBancaria) {
        this.iCuentaBancariaRepository.actualizar(cuentaBancaria);
    }
}
