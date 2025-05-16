package sk.train.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import sk.train.model.Department;
import sk.train.model.Employee;

public class EmpService {
	
	//@PersistenceContext
	private EntityManager myem;

	
	//default-Konstruktor
	public EmpService(EntityManager myem) {
		super();
		this.myem = myem;
	}
	
	public void createEmp(Employee emp){
		//todo

	}
	
	public Employee readEmp(long id){
		//todo
		return null;
	}
	
	public void removeEmp(long id){
		//todo
	}
	
	public void setSalaryEmp(long id, BigDecimal sal){
		//todo
	}
	
	public List<Employee> getemps(){
		//alle Angestellten: Named Query nutzen
		return null;
	}
	
	
	public List<Department> getdepartments(){
		//todo
		return null;
	}
	
	public Department readDep(long id){
		//todo
		return null;
	}
	
	//nach Bedarf weitere ...
	
}
