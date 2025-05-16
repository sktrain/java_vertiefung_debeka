package sk.train.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import sk.train.model.Department;
import sk.train.model.Employee;
import sk.train.model.Name;

public class EmpService {
	
	//@PersistenceContext
	private EntityManager myem;

	
	//default-Konstruktor
	public EmpService(EntityManager myem) {
		super();
		this.myem = myem;
	}
	
	/********** Employee-Zugriffe ***********/
	
	public void createEmp(Employee emp){
		myem.persist(emp);		
	}
	
	public Employee readEmp(long id){
		Employee emp = myem.find(Employee.class, id);
		return emp;
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
	
	
	/********** Department-Zugriffe ***********/
	
	public List<Department> getdepartments(){
		return myem.createNamedQuery("Department.findAll", Department.class).getResultList();
	}
	
	public Department readDep(long id){
		Department dep = myem.find(Department.class, id);
		return dep;
	}
	
	
	/********** Query-Beispiele ***********/
	
	public List<Employee> getempsBySalary(BigDecimal lowerbound){
		//alle Ang. mit Gehalt >= lowerbound
		TypedQuery<Employee> query = 
				myem.createQuery("select e from Employee e where e.salary >= " + lowerbound, Employee.class);
		//query.setParameter("bound", lowerbound);
		return query.getResultList();
	}
	
	public BigDecimal getSumSalary() {
		return myem.createQuery("select sum(e.salary)from Employee e" , BigDecimal.class).getSingleResult();
	}
	
	public List<Name> getNames(){
		//Liste aller Nachnamen + Vorname mit Mapping
		Query query = myem.createQuery("SELECT NEW sk.train.model.Name(e.firstName, e.lastName) FROM Employee e");
		return query.getResultList();		
	}
	
	public List<Object[]> getNamesAsParts(){
		//Liste aller Nachnamen + Vorname
		Query query = myem.createQuery("SELECT e.firstName, e.lastName FROM Employee e");
		return query.getResultList();		
	}
	
	//als JPQL-Query
	public List<Employee> getChefs(){
		// select * from employees where 
		//  employee_id in (select distinct manager_id from employees)
		return myem.createQuery("select distinct e from Employee e where e in" +
		                          "(select c.employee from Employee c)", Employee.class).getResultList();
	}
	
	//als JPQL-Query
	public List<Employee>  getIndianer(){
		// select * from employees where 
		//  employee_id in (select distinct manager_id from employees where manager_id is not null)
		return myem.createQuery("select distinct e from Employee e where e not in" 
	                             + "(select c.employee from Employee c)",
				Employee.class).getResultList();
	}
	
	//Liste der Chefs (Nativer Query), Vorsicht Schema muss qualifiziert werden
	public List<Employee> getChefsNative(){
		return myem.createNativeQuery("select * from hr.employees where employee_id in" +
				"(select distinct manager_id from hr.employees)", Employee.class)
				.getResultList();		
	}
	
	//Liste der Indianer (Nativer Query)
	public List<Employee> getIndianerNative(){
	   return myem.createNativeQuery("select * from hr.employees where employee_id  not in" +
				  "(select distinct manager_id from hr.employees where manager_id is not null)",
				  Employee.class).getResultList();
		}

	//Liste der Chefs (CriteriaApi)
	public List<Employee> getChefsCriteria(){
		CriteriaBuilder cb = myem.getCriteriaBuilder();
		CriteriaQuery<Employee> c = cb.createQuery(Employee.class);
		Root<Employee> remp = c.from(Employee.class);
		Subquery<Employee> sq = c.subquery(Employee.class);
		Root<Employee> mgr = sq.from(Employee.class);
		sq.select(mgr.<Employee>get("employee")).distinct(true);
		c.select(remp).where(cb.in(remp).value(sq));
		return myem.createQuery(c).getResultList();
	}


	//Aufruf einer Stored_Procedure (ab JPA 2.1 unterstützt)
	//Prozeduraufruf setzt Prozedur bzw. Funktion bei H2 voraus und das ist eigentlich immer Funktion (Java-Methode)
	public int add1(int param1, int param2){
		StoredProcedureQuery query = myem.createStoredProcedureQuery("add_proc");
		query.registerStoredProcedureParameter(1, int.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, int.class, ParameterMode.IN);
		//query.registerStoredProcedureParameter(3, int.class, ParameterMode.OUT);
		query.setParameter(1, 2);
		query.setParameter(2, 4);
		query.execute();
		//int i = (int) query.getOutputParameterValue(3);
		//System.out.println(i);
		return (int) query.getSingleResult();
	}

	public int add2(int param1, int param2){
		//mal mit benannten Parametern, die Parameter müssen analog zur Prozedur benannt werden
		StoredProcedureQuery query_named = myem.createStoredProcedureQuery("add_proc");
		query_named.registerStoredProcedureParameter("a", int.class, ParameterMode.IN);
		query_named.registerStoredProcedureParameter("b", int.class, ParameterMode.IN);
		//query_named.registerStoredProcedureParameter("result", int.class, ParameterMode.OUT);
		query_named.setParameter("a", 2);
		query_named.setParameter("b", 4);
		query_named.execute();
		//i = (int) query_named.getOutputParameterValue("result");
		//System.out.println(i);
		return (int) query_named.getSingleResult();
	}

	//Test einer Stored Function per Native Query (wird leider noch nicht wie Prozedur unterstützt)
	public int addFunction(int param1, int param2){
		Query q = myem.createNativeQuery("SELECT add_proc(?1, ?2)");
		q.setParameter(1, 5);
		q.setParameter(2, 5);
		return (int) q.getSingleResult();
	}

}
