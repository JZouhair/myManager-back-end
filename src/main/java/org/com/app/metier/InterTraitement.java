package org.com.app.metier;

import java.util.List;

import org.com.app.tables.pojos.Employe;


public interface InterTraitement {
	
	public List<Employe> selectAllEmploye() ;
	public  List<Employe>  selectOneEmploye(int id);
	public void delecteOneEmploye(int id);
	public void updateEmp(Employe emp);
	public void addOneEmp(Employe emp);
}
