package com.uce.edu.repository.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "propietario")
public class Propietario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_propietario")
    @SequenceGenerator(name = "seq_propietario", sequenceName = "seq_propietario", allocationSize = 1)
    @Column(name = "prop_id")
    private Integer id;
    @Column(name = "prop_nombre")
    private String nombre;
    @Column(name = "prop_apellido")
    private String apellido;
    @Column(name = "prop_cedula")
    private String cedula;
    @OneToOne(mappedBy = "propietario")
    private CuentaBancaria cuentaBancaria;

    // SET Y GET

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    @Override
    public String toString() {
        return "Propietario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", cedula='" + cedula + '\'' +
                '}';
    }
}
