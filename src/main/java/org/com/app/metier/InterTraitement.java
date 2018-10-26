package org.com.app.metier;

import java.util.List;

import org.com.app.tables.pojos.Employe;


public interface InterTraitement {
	
	public void addEmploye(Employe emp);
	public List<Employe> SelectEmploye() ;
	public Employe getOneEmpl(Long id);
	public void deleteEmp(Long id);

}
