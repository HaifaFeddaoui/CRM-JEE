package interfaces;

import javax.ejb.Remote;

import entities.Reservation;

@Remote
public interface IReservationServiceRemote {
	public void reserver (Reservation res);
	//public List<Reservation> getMostRes();
}
