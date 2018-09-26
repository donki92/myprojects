package com.doan.springdemo.dao;

import java.util.List;
import com.doan.springdemo.entity.Customer;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

	//inject session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		// get the hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		//create a query
		Query<Customer> query = currentSession.createQuery ("from Customer order by lastName", Customer.class);
		//get a result list
		List<Customer> customers =query.getResultList();
		//display result list
		return customers;
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {
		//get session
		Session currentSession = sessionFactory.getCurrentSession();
		//get customer from database based on primary key
		Customer theCustomer = currentSession.get(Customer.class, theId);
		return theCustomer; 
		
		
	}

	@Override
	public void deleteCustomer(int theId) {
		// get current session
		Session currentSession = sessionFactory.getCurrentSession();
		//delete object with the primary key of theId
		Query query = currentSession.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", theId);
		query.executeUpdate();
	}

}
