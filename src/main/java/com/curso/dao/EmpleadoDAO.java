package com.curso.dao;

import java.util.List;

import com.curso.entidades.Empleado;
/**
 * Implementa las operaciones CRUD
 * create
 * read
 * update
 * delete
 * 
 * @author begonaolea
 *
 */
public interface EmpleadoDAO {

	Empleado crear(Empleado e);
	void modificar(Empleado e);
	void borrar(int id);
	Empleado  getByID(int id);
    List<Empleado> getAll();
	
}












