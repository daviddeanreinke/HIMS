package com.revature.model;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.business.ClientInfo;
import com.revature.business.LoginBean;
import com.revature.business.SessionInfo;



@Repository
public class HIMSDaoImpl implements HIMSDao{

	@Inject
	private SessionFactory sessionFactory;
	
	@Autowired
	private SessionInfo sessionInfo;
	
	@Autowired
	private List<ClientInfo> cInfoList;
	/**
	 * Spring automatically rolls back transactions for runtime exceptions
	 * NOT checked exceptions. If the propagation is set to SUPPORTS or NOT_SUPPORTED
	 * the transaction will not rollback
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW, readOnly=false)
	public void saveClaim(Claim claim) {
		this.sessionFactory.getCurrentSession().save(claim);
	}


	@Transactional(propagation=Propagation.REQUIRES_NEW, readOnly=false)
	public void savePolicyPlan(PolicyPlan policy) {
		this.sessionFactory.getCurrentSession().save(policy);
		
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW, readOnly=false)
	public void saveClient(Client client) {
		System.out.println("himsDao-saveClient: "+ client.getExpiration_date());
		this.sessionFactory.getCurrentSession().save(client);
		
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW, readOnly=false)
	public void saveInstitution(Institution institution) {
		System.out.println("himsDao-saveInstitution: ");
		this.sessionFactory.getCurrentSession().save(institution);
		
	}


	@Transactional(propagation=Propagation.REQUIRES_NEW, readOnly=false)
	public Client checkPolicy(Client client) {
		@SuppressWarnings("unchecked")
		List<Client> cList = sessionFactory.getCurrentSession().createQuery(
				"From Client where firstname = :firstname and lastname = :lastname")
				.setString("firstname", client.getFirstname())
				.setString("lastname", client.getLastname()).list();
		if(cList.isEmpty())
			return null;
		return cList.get(0);
	}

	
	@Transactional(propagation=Propagation.REQUIRES_NEW, readOnly=false)
	public Client getClient(String clientID) {
		@SuppressWarnings("unchecked")
		List<Client> cList = sessionFactory.getCurrentSession().createQuery(
				"From Client where client_id = :clientid")
				.setString("clientid", clientID).list();
		if(cList.isEmpty())
			return null;
		return cList.get(0);
	}


	@Transactional(propagation=Propagation.REQUIRES_NEW, readOnly=false)
	public void saveLogin(Login login) {
		System.out.println("himsDao-saveLogin: "+ login.getUserid());
		this.sessionFactory.getCurrentSession().save(login);
	}


	@Transactional(propagation=Propagation.REQUIRES_NEW, readOnly=false)
	public SessionInfo userLogin(LoginBean loginBean) {
		try{
			@SuppressWarnings("unchecked")
			List<Login> lList = sessionFactory.getCurrentSession().createQuery(
					"From Login where userid = :userId and password = :password")
					.setString("userId", loginBean.getUsername())
					.setString("password", loginBean.getPassword())
					.list();
			if(lList.isEmpty())
				return null;
			//SessionInfo sessionInfo = new SessionInfo();
			// autoinjected via spring 
			sessionInfo.setUser_id(loginBean.getUsername());
			sessionInfo.setNetwork_name(lList.get(0).getInstitution().getNetwork().getName());
			sessionInfo.setNetwork_id(lList.get(0).getInstitution().getNetwork().getNetwork_id());
			sessionInfo.setInstitution_name(lList.get(0).getInstitution().getName());
			sessionInfo.setInstitution_id(lList.get(0).getInstitution().getInstitution_id());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//sessionFactory.getCurrentSession().close();
		}
		
		
		return sessionInfo; //return a sessionInfo object
		
		
	}


	@Transactional(propagation=Propagation.REQUIRES_NEW, readOnly=false)
	public List<ClientInfo> searchPatient(ClientInfo clientInfo) {
		System.out.println("entered Dao search patient");
		cInfoList.clear();
		try{
			@SuppressWarnings("unchecked")
			
			// this query will return a list of clients, not clientInfo objects.
			List<Client> cList = sessionFactory.getCurrentSession().createQuery(
					"FROM Client "
					+ "WHERE policy_number = :policy_number "
					+ "OR client_id = :clientID "
					+ "OR firstname = :firstname "
					+ "OR lastname = :lastname")
					.setString("policy_number", clientInfo.getPolicy_number())
					.setString("clientID", clientInfo.getClientID())
					.setString("firstname", clientInfo.getFirstname())
					.setString("lastname", clientInfo.getLastname())
					.list();
			for(Client c: cList){
				ClientInfo result = new ClientInfo();
				result.setPolicy_number(c.getPolicy_number());
				result.setClientID(c.getClient_id());
				result.setFirstname(c.getFirstname());
				result.setLastname(c.getLastname());
				result.setBirthdate(c.getBirthdate());
				result.setCovered(c.isActive());
				result.setPolicyType(c.getPolicyPlan().getPolicy_type());
				result.setNetworkID(c.getNetwork().getNetwork_id());
				result.setNetworkName(c.getNetwork().getName());
				cInfoList.add(result);
			}
			return cInfoList;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
 
}
