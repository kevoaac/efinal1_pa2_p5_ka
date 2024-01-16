package com.uce.edu;

import com.uce.edu.repository.modelo.CuentaBancaria;
import com.uce.edu.repository.modelo.Propietario;
import com.uce.edu.repository.modelo.Transferencia;
import com.uce.edu.service.ICuentaBancariaService;
import com.uce.edu.service.ITransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
public class Efinal1Pa2P5KaApplication implements CommandLineRunner {
	@Autowired
	private ICuentaBancariaService iCuentaBancariaService;
	@Autowired
	private ITransferenciaService iTransferenciaService;

	public static void main(String[] args) {
		SpringApplication.run(Efinal1Pa2P5KaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Cuenta 1
		Propietario propietarioA = new Propietario();
		propietarioA.setCedula("171717");
		propietarioA.setNombre("Juan");
		propietarioA.setApellido("Cruz");

		CuentaBancaria cuentaBancariaA = new CuentaBancaria();
		cuentaBancariaA.setNumero("C123");
		cuentaBancariaA.setTipo("Ahorros");
		cuentaBancariaA.setSaldo(new BigDecimal(1000));
		cuentaBancariaA.setPropietario(propietarioA);

		propietarioA.setCuentaBancaria(cuentaBancariaA);
		this.iCuentaBancariaService.registrar(cuentaBancariaA);

		// Cuenta 2
		Propietario propietarioB = new Propietario();
		propietarioB.setCedula("040404");
		propietarioB.setNombre("Luisa");
		propietarioB.setApellido("Mendez");

		CuentaBancaria cuentabancariaB = new CuentaBancaria();
		cuentabancariaB.setNumero("C888");
		cuentabancariaB.setTipo("Ahorros");
		cuentabancariaB.setSaldo(new BigDecimal(2000));
		cuentabancariaB.setPropietario(propietarioB);

		propietarioA.setCuentaBancaria(cuentabancariaB);

		this.iCuentaBancariaService.registrar(cuentabancariaB);

		// Realizar transferencia
		this.iTransferenciaService.realizarTransferencia("171717", "040404", new BigDecimal(100));

		// Imprimir datos
		CuentaBancaria cuentaBancaria1 = this.iCuentaBancariaService.buscarPorNumero("171717");
		CuentaBancaria cuentaBancaria2 = this.iCuentaBancariaService.buscarPorNumero("040404");

		System.out.println(cuentaBancaria1);
		System.out.println(cuentaBancaria2);

		// Imprimir tansferencias
		List<Transferencia> transferencias = this.iTransferenciaService.listar();
		transferencias.forEach(System.out::println);




	}
}
