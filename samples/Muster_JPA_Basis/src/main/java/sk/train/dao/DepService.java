package sk.train.dao;

import javax.persistence.EntityManager;

public class DepService {
	
	private EntityManager myem;

	
	public DepService(EntityManager myem) {
		super();
		this.myem = myem;
	}
	
	
	
}
