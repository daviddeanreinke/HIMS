package com.revature.model;

import java.util.List;

import com.revature.business.ClientInfo;
import com.revature.business.LoginBean;
import com.revature.business.SessionInfo;

public interface HIMSDao {
	
	public void saveClaim(Claim claim);
	
	public void savePolicyPlan(PolicyPlan policy);

	public Client checkPolicy(Client client);

	public void saveClient(Client client);

	public void saveInstitution(Institution institution);

	public Client getClient(String clientID);

	public void saveLogin(Login login);

	public SessionInfo userLogin(LoginBean loginBean);

	public List<ClientInfo> searchPatient(ClientInfo clientInfo);


}
