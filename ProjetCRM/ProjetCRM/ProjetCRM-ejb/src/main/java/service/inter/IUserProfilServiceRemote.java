package service.inter;

import java.util.List;

import javax.ejb.Remote;

import model.UserProfil;



@Remote
public interface IUserProfilServiceRemote {
	public UserProfil getUserById(String UserProfilId);
	public void updateUser(UserProfil user);
	public List<UserProfil> getUser();



}
