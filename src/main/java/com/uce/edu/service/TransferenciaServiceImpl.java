package com.uce.edu.service;

import com.uce.edu.repository.ICuentaBancariaRepository;
import com.uce.edu.repository.ITransferenciaRepository;
import com.uce.edu.repository.modelo.CuentaBancaria;
import com.uce.edu.repository.modelo.Transferencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService{
    @Autowired
    private ITransferenciaRepository iTransferenciaRepository;

    @Autowired
    private ICuentaBancariaRepository iCuentaBancariaRepository;


    @Override
    public void guardar(Transferencia transferencia) {
        this.iTransferenciaRepository.insertar(transferencia);
    }

    @Override
    public List<Transferencia> listar() {
        return this.iTransferenciaRepository.listar();
    }

    @Override
    public void realizarTransferencia(String numeroOrigen, String numeroDestino, BigDecimal monto) {
        CuentaBancaria ctaOrigen = this.iCuentaBancariaRepository.seleccionarPorNumero(numeroOrigen);
        CuentaBancaria ctaDestino = this.iCuentaBancariaRepository.seleccionarPorNumero(numeroDestino);

        // verificar Saldo
        if(monto.compareTo(ctaOrigen.getSaldo()) == -1){
            System.out.println("\n<<<Saldo insuficiente");
        }

        BigDecimal saldoActualOrigen = ctaOrigen.getSaldo();
        ctaOrigen.setSaldo(saldoActualOrigen.subtract(monto));

        BigDecimal saldoActualDestino = ctaOrigen.getSaldo();
        ctaOrigen.setSaldo(saldoActualDestino.add(monto));

        // Actualizar cuentas
        this.iCuentaBancariaRepository.actualizar(ctaOrigen);
        this.iCuentaBancariaRepository.actualizar(ctaDestino);


        BigDecimal comision = monto.multiply(new BigDecimal(0.10));


        Transferencia transferencia = new Transferencia();
        transferencia.setFecha(LocalDateTime.now());
        transferencia.setCuentaBancariaOrigen(ctaOrigen);
        transferencia.setCuentaBancariaDestino(ctaDestino);
        transferencia.setComision(comision);

        this.iTransferenciaRepository.insertar(transferencia);


    }
}
