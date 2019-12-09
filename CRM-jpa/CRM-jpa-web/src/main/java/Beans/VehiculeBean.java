package Beans;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.PieChartModel;

import Remotes.EmailRemote;
import Remotes.TemplateMessage;
import Remotes.VehiculeServiceRemote;
import model.Vehicule;






@ManagedBean(name = "VehiculeBean")
@SessionScoped
public class VehiculeBean {
	
@EJB 
VehiculeServiceRemote es ;
@EJB
EmailRemote emails;
private String selectedItem = "all"; 
private int vehiculeId ;
private String matricule;
private String typeVh;
private Date dateCirc;


private List<Vehicule> vehicules = new ArrayList<>();
private List<Vehicule> vehicules1 = new ArrayList<>();
private List<Vehicule> vehicules2 = new ArrayList<>();
private List<Vehicule> vehicules3 = new ArrayList<>();
private List<Vehicule> Camions = new ArrayList<>();
private List<Vehicule> Berlines = new ArrayList<>();
private List<Vehicule> Suvs = new ArrayList<>();
private List<Vehicule> Camionettes = new ArrayList<>();



private PieChartModel pieModel2;

public PieChartModel getPieModel2() {
	return pieModel2;
}

public void setPieModel2(PieChartModel pieModel2) {
	this.pieModel2 = pieModel2;
}

public String getSelectedItem() {
	return selectedItem;
}
public void setSelectedItem(String selectedItem) {
	this.selectedItem = selectedItem;
}
public int getVehiculeId() {
	return vehiculeId;
}
public void setVehiculeId(int vehiculeId) {
	this.vehiculeId = vehiculeId;
}
public String getMatricule() {
	return matricule;
}
public void setMatricule(String matricule) {
	this.matricule = matricule;
}
public String getTypeVh() {
	return typeVh;
}
public void setTypeVh(String typeVh) {
	this.typeVh = typeVh;
}
public Date getDateCirc() {
	return this.dateCirc;
}

public void setDateCirc(Date dateCirc) {
	this.dateCirc = dateCirc;
}
public List<Vehicule> getVehicules() {
	this.vehicules= es.getall();
	return vehicules;
}
public void setVehicules(List<Vehicule> vehicules) {
	this.vehicules = vehicules;
}
public List<Vehicule> getVehicules1() {
	this.vehicules1= es.getall1();
	return vehicules1;
}
public void setVehicules1(List<Vehicule> vehicules1) {
	this.vehicules1 = vehicules1;
}
public List<Vehicule> getVehicules2() {
	this.vehicules2= es.getall2();
	return vehicules2;
}
public void setVehicules2(List<Vehicule> vehicules2) {
	this.vehicules2 = vehicules2;
}
public List<Vehicule> getVehicules3() {
	this.vehicules3= es.getall3();
	return vehicules3;
}
public void setVehicules3(List<Vehicule> vehicules3) {
	this.vehicules3 = vehicules3;
}

public List<Vehicule> getCamions() {
	this.Camions= es.getallTruc();
    return Camions;
	

}
public void setCamions(List<Vehicule> camions) {
	Camions = camions;
}
public List<Vehicule> getBerlines() {
	this.Berlines= es.getallBer();
    return Berlines;
	
}
public void setBerlines(List<Vehicule> berlines) {
	Berlines = berlines;
}
public List<Vehicule> getSuvs() {
	this.Suvs= es.getallSuv();
    return Suvs;
}
public void setSuvs(List<Vehicule> suvs) {
	Suvs = suvs;
}
public List<Vehicule> getCamionettes() {
	this.Camionettes= es.getallCar();
    return Camionettes;
	
}
public void setCamionettes(List<Vehicule> camionettes) {
	Camionettes = camionettes;
}



public String add() {
	Vehicule Vh = new Vehicule();
	//Vh.setVehiculeId(15);
	Vh.setMatricule(this.getMatricule());
	Vh.setTypeVh(this.getTypeVh());
	//Date date = new Date();
	Vh.setDateCirc(this.getDateCirc());
	TemplateMessage template = new TemplateMessage("test");
	emails.sendEmail("mohamed.fezai@esprit.tn", "Vehicul Created ", template.getTemplate());
	
	
	es.addVehicule(Vh);
	
	Vh.setVehiculeId(0);
	Vh.setMatricule("");
	Vh.setTypeVh("");
	
	return "/pages/list?faces-redirect=true";
	
}
public void delete( int id) {

	es.deleteVehicule(id);;
	
}
public String updateVehicule(Vehicule Vh) {
	
	this.setMatricule(Vh.getMatricule());
	this.setTypeVh(Vh.getTypeVh());
	Date date = new Date();
	this.setDateCirc(date);
	
	
	return "/pages/update?faces-redirect=true";
	
	
	}

private void createPieModel() {
    
    createPieModel2();
    
}
private void createPieModel2() {
    pieModel2 = new PieChartModel();

	this.vehicules = es.getall();
	for (Vehicule vehicule : vehicules) {
		

		if( vehicule.getTypeVh().equals("Truc")) {this.Camions.add(vehicule);  }
		else if(vehicule.getTypeVh().equals("Berlin")){this.Berlines.add(vehicule); }
		else if(vehicule.getTypeVh().equals("SUV")){this.Suvs.add(vehicule);  }
		else if(vehicule.getTypeVh().equals("Car")){this.Camionettes.add(vehicule);  }
    pieModel2.set("Truc", Camions.size());
    pieModel2.set("Berlin", Berlines.size());
    pieModel2.set("SUV", Suvs.size());
    pieModel2.set("Car", Camionettes.size());

    pieModel2.setTitle("Stat Vehicules");
    pieModel2.setLegendPosition("e");
    pieModel2.setFill(false);
    pieModel2.setShowDataLabels(true);
    pieModel2.setDiameter(300);
    pieModel2.setShadow(true);}
}
@PostConstruct
public void init() {
	this.vehicules = es.getall();
	for (Vehicule vehicule : vehicules) {
		
	
		if( vehicule.getTypeVh().equals("Truc")  ) {this.Camions.add(vehicule);  }
		else if( vehicule.getTypeVh().equals("Berlin")  ) {this.Berlines.add(vehicule);  }
		else if( vehicule.getTypeVh().equals("SUV")  ) {this.Suvs.add(vehicule);  }
		else if( vehicule.getTypeVh().equals("Car")  ) {this.Camionettes.add(vehicule);  }
		
	}
	System.out.println("/////////////////////////////////////////////////////////////////////");
	System.out.println(this.Camions);
	
	createPieModel();
	
	} 
public String update() {
	Vehicule Vh = new Vehicule();
	Vh.setMatricule(this.getMatricule());
	Vh.setTypeVh(this.getTypeVh());
	Date date = new Date();
	Vh.setDateCirc(date);
	
	es.updateVehicule(Vh);
	
	Vh.setMatricule("");
	
	Vh.setTypeVh(this.typeVh=null);
	
	
	return "/pages/list?faces-redirect=true";
	
}


public List<Vehicule> getAll()
{
	return es.getall();
}
public List<Vehicule> getAll1()
{
	return es.getall1();
}
public List<Vehicule> getAll2()
{
	return es.getall2();
}
public List<Vehicule> getAll3()
{
	
	return es.getall3();
}
public List<Vehicule> getallTruc()
{
	
	return es.getallTruc();
}






}
