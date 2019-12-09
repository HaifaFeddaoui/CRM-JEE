package Remotes;

import java.util.List;

import javax.ejb.Remote;

import model.Vehicule;

@Remote
public interface VehiculeServiceRemote {

	public void addVehicule(Vehicule Vehicule);

	public void updateVehicule(Vehicule Vehicule);

	Vehicule getVehiculeById(int id);

	public void deleteVehicule(int id);

    List<Vehicule> getall();
    List<Vehicule> getall1();

	List<Vehicule> getall2();

	List<Vehicule> getall3();
	List<Vehicule> getallTruc();

	List<Vehicule> getallCar();

	List<Vehicule> getallSuv();

	List<Vehicule> getallBer();

	

}
