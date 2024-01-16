package com.uce.edu.repository.modelo;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "cuenta_bancaria")
public class CuentaBancaria {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cuenta_bancaria")
    @SequenceGenerator(name = "seq_cuenta_bancaria", sequenceName = "seq_cuenta_bancaria", allocationSize = 1)
    @Column(name = "cuba_id")
    private Integer id;
    @Column(name = "cuba_numero")
    private String numero;
    @Column(name = "cuba_tipo")
    private String tipo;
    @Column(name = "cuba_saldo")
    private BigDecimal saldo;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cuba_id_propietario")
    private Propietario propietario;

    // SET Y GET

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", tipo='" + tipo + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
