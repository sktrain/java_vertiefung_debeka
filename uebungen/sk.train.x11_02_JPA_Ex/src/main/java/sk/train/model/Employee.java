package sk.train.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the EMPLOYEES database table.
 * 
 */
@Entity
@Table(name="EMPLOYEES", schema="HR")
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="EMPLOYEE_ID")
	private long employeeId;

	@Column(name="COMMISSION_PCT")
	private BigDecimal commissionPct;

	private String email;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="HIRE_DATE")
	private Date hireDate;

	@Column(name="JOB_ID")
	private String jobId;

	@Column(name="LAST_NAME")
	private String lastName;

	@Column(name="PHONE_NUMBER")
	private String phoneNumber;

	private BigDecimal salary;

	//bi-directional many-to-one association to Department
	@OneToMany(mappedBy= "depManager")
	private List<Department> departmentsByManager;

	//bi-directional many-to-one association to Department
	@ManyToOne
	@JoinColumn(name="DEPARTMENT_ID")
	private Department department;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="MANAGER_ID")
	private Employee personalManager;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy= "personalManager")
	private List<Employee> employeesByManager;

	public Employee() {
	}

	public long getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public BigDecimal getCommissionPct() {
		return this.commissionPct;
	}

	public void setCommissionPct(BigDecimal commissionPct) {
		this.commissionPct = commissionPct;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getHireDate() {
		return this.hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getJobId() {
		return this.jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public BigDecimal getSalary() {
		return this.salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public List<Department> getDepartmentsByManager() {
		return this.departmentsByManager;
	}

	public void setDepartmentsByManager(List<Department> departments) {
		this.departmentsByManager = departments;
	}

	public Department addDepartment(Department department) {
		getDepartmentsByManager().add(department);
		department.setDepManager(this);

		return department;
	}

	public Department removeDepartment(Department department) {
		getDepartmentsByManager().remove(department);
		department.setDepManager(null);

		return department;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Employee getPersonalManager() {
		return this.personalManager;
	}

	public void setPersonalManager(Employee employee) {
		this.personalManager = employee;
	}

	public List<Employee> getEmployeesByManager() {
		return this.employeesByManager;
	}

	public void setEmployeesByManager(List<Employee> employees) {
		this.employeesByManager = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployeesByManager().add(employee);
		employee.setPersonalManager(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployeesByManager().remove(employee);
		employee.setPersonalManager(null);

		return employee;
	}

}