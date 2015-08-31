import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import customTools.DBUtils;
import model.Customer;
import model.State;
import model.City;
import model.Company;

public class DBtrans {

	
	
	public static List<Customer> selectCust(String fullname){
		
		EntityManager em = DBUtils.getEmFactory().createEntityManager();
		
		String jpa_sql = "select c from Customer c where "   
				+ "c.fullname LIKE :fullname"
				;
	
		TypedQuery<Customer> mq = em.createQuery(jpa_sql, Customer.class);
		
		mq.setParameter("fullname", fullname+"%");
		List<Customer> custs;
		
		try{
			custs = mq.getResultList();
			if(custs==null || custs.isEmpty()){
				custs=null;
			}
		}finally {
			em.close();
		}
		return custs;
		}
	
	
public static List<Customer> selectCustAll(String fullname){
		
		EntityManager em = DBUtils.getEmFactory().createEntityManager();
		
		String jpa_sql = "select c from Customer c where "   
				+ "c.fullname = :fullname"
				;
	
		TypedQuery<Customer> mq = em.createQuery(jpa_sql, Customer.class);
		
		mq.setParameter("fullname", fullname);
		List<Customer> custs;
		
		try{
			custs = mq.getResultList();
			if(custs==null || custs.isEmpty()){
				custs=null;
			}
		}finally {
			em.close();
		}
		return custs;
		}
	

public static List<City> selectCity(double cityid){
		
		EntityManager em = DBUtils.getEmFactory().createEntityManager();
		
		String sql = "select ci from City ci where ci.cityid = :cityid";
		TypedQuery<City> mq = em.createQuery(sql, City.class);
		
		mq.setParameter("cityid", cityid);
		List<City> cities;
		
		try{
			cities = mq.getResultList();
			if(cities==null || cities.isEmpty()){
				cities=null;
			}
		}finally {
			em.close();
		}
		return cities;
		}


public static List<Company> selectComp(double companyid){
	
	EntityManager em = DBUtils.getEmFactory().createEntityManager();
	
	String sql = "select co from Company co where co.comapnyid = :companyid";
	
	TypedQuery<Company> mq = em.createQuery(sql, Company.class);
	
	
	mq.setParameter("companyid", companyid);
	List<Company> comps;
	
	try{
		comps = mq.getResultList();
		if(comps==null || comps.isEmpty()){
			comps=null;
		}
	}finally {
		em.close();
	}
	return comps;
	}


public static List<State> selectState(double stateid){
	
	EntityManager em = DBUtils.getEmFactory().createEntityManager();
	
	String sql = "select st from State st where st.stateid = :stateid";
	TypedQuery<State> mq = em.createQuery(sql, State.class);
	
	mq.setParameter("stateid", stateid);
	List<State> states;
	
	try{
		states = mq.getResultList();
		if(states==null || states.isEmpty()){
			states=null;
		}
	}finally {
		em.close();
	}
	return states;
	}

}
