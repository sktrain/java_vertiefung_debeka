package sk.train.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DEPARTMENTS database table.
 * 
 */
@Entity
@Table(name="DEPARTMENTS", schema="HR")
@NamedQuery(name="Department.findAll", query="SELECT d FROM Department d")
public class Department implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DEPARTMENT_ID")
	private long departmentId;

	@Column(name="DEPARTMENT_NAME")
	private String departmentName;

	@Column(name="LOCATION_ID")
	private java.math.BigDecimal locationId;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="MANAGER_ID")
	private Employee depManager;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="department")
	private List<Employee> employeesInDep;

	public Department() {
	}

	public long getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public java.math.BigDecimal getLocationId() {
		return this.locationId;
	}

	public void setLocationId(java.math.BigDecimal locationId) {
		this.locationId = locationId;
	}

	public Employee getDepManager() {
		return this.depManager;
	}

	public void setDepManager(Employee employee) {
		this.depManager = employee;
	}

	public List<Employee> getEmployeesInDep() {
		return this.employeesInDep;
	}

	public void setEmployeesInDep(List<Employee> employees) {
		this.employeesInDep = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployeesInDep().add(employee);
		employee.setDepartment(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployeesInDep().remove(employee);
		employee.setDepartment(null);

		return employee;
	}	

}