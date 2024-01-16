package com.uce.edu.repository.modelo;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transferencia")
public class Transferencia {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_transferencia")
    @SequenceGenerator(name = "seq_transferencia", sequenceName = "seq_transferencia", allocationSize = 1)
    @Column(name = "tran_id")
    private Integer id;
    @Column(name = "tran_fecha")
    private LocalDateTime fecha;
    @Column(name = "tran_monto")
    private BigDecimal monto;
    @Column(name = "tran_comision")
    private BigDecimal comision;

    @Column(name = "tran_id_cuenta_origen")
    private CuentaBancaria cuentaBancariaOrigen;
    @Column(name = "tran_id_cuenta_destino")
    private CuentaBancaria cuentaBancariaDestino;

    // GET Y SET

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public BigDecimal getComision() {
        return comision;
    }

    public void setComision(BigDecimal comision) {
        this.comision = comision;
    }

    public CuentaBancaria getCuentaBancariaOrigen() {
        return cuentaBancariaOrigen;
    }

    public void setCuentaBancariaOrigen(CuentaBancaria cuentaBancariaOrigen) {
        this.cuentaBancariaOrigen = cuentaBancariaOrigen;
    }

    public CuentaBancaria getCuentaBancariaDestino() {
        return cuentaBancariaDestino;
    }

    public void setCuentaBancariaDestino(CuentaBancaria cuentaBancariaDestino) {
        this.cuentaBancariaDestino = cuentaBancariaDestino;
    }

    @Override
    public String toString() {
        return "Transferencia{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", monto=" + monto +
                ", comision=" + comision +
                '}';
    }
}
