package service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import model.UserProfil;
import service.inter.IUserProfilServiceRemote;

@Stateless
@LocalBean
public class UserProfilService implements IUserProfilServiceRemote{
	@PersistenceContext
	EntityManager em;
	@Override
	public UserProfil getUserById(String UserProfilId) {
		return em.find(UserProfil.class, UserProfilId);
	}
	@Override
	public void updateUser(UserProfil user) {
		UserProfil emp = em.find(UserProfil.class, user.getUserProfilId());
		emp.setBirthDate(user.getBirthDate());
		emp.setGender(user.getGender());
		emp.setImage(user.getImage());
		emp.setInternet(user.getInternet());
		emp.setLastName(user.getLastName());
		emp.setName(user.getName());
		emp.setPoint(user.getPoint());
		emp.setRole(user.getRole());
		emp.setSolde(user.getSolde());
		emp.setUserAddress(user.getUserAddress());
		emp.setUserMail(user.getUserMail());
		emp.setUserNum(user.getUserNum());
		

	}
	@Override
	public List<UserProfil> getUser() {
		List<UserProfil> emp = em.createQuery("SELECT u FROM UserProfil u WHERE name='haifa'", UserProfil.class).getResultList();
		return emp;
	}

}
