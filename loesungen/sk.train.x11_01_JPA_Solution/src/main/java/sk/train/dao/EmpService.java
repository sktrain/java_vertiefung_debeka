package sk.train.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import model.Employee;

public class EmpService {
	
	//@PersistenceContext
	private EntityManager myem;

	
	public EmpService(EntityManager myem) {
		super();
		this.myem = myem;
	}
	
	public void createEmp(Employee emp){		
		myem.persist(emp);		
	}
	
	public Optional<Employee> readEmp(long id){
		Employee emp = myem.find(Employee.class, id);
		//if (emp == null) throw new RuntimeException("Emp existiert nicht");
		return Optional.ofNullable(emp);
	}
	
	public void removeEmp(long id){
		Employee emp = myem.find(Employee.class, id);
		if (emp != null)
		myem.remove(emp);
	}
	
	public void setSalaryEmp(long id, BigDecimal sal){
		Employee emp = myem.find(Employee.class, id);
		if (emp != null)
			emp.setSalary(sal);
	}
	
	public List<Employee> getemps(){
		//alle Angestellten: Named Query nutzen
		return myem.createNamedQuery("Employee.findAll", Employee.class).getResultList();
	}
	
	
}
