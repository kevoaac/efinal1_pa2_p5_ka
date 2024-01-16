package com.uce.edu.service;

import com.uce.edu.repository.modelo.Transferencia;

import java.math.BigDecimal;
import java.util.List;

public interface ITransferenciaService {
    void guardar(Transferencia transferencia);
    List<Transferencia> listar();
    void realizarTransferencia(String numeroOrigen, String numeroDestino, BigDecimal monto);
}
