package org.com.app.web;
import java.util.List;
import org.com.app.metier.EmpTraitement;
import org.com.app.tables.pojos.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class EmployController {
	@Autowired 
	private EmpTraitement empTraitement;

	public EmployController(EmpTraitement empTraitement) {
		super();
		this.empTraitement = empTraitement;
	}
	@GetMapping(value="/AllEmps")
	public List<Employe> getAllEmployes() {	
		 return empTraitement.selectAllEmploye();
	}
	@GetMapping(value="/OneEmp/{id}")
	public List<Employe> getOneEmployes(@PathVariable int id) {	
		 return empTraitement.selectOneEmploye(id);
	}
	@GetMapping(value="/DeleteEmp/{id}")
	public String deleteOneEmployes(@PathVariable int id) {	
		  empTraitement.delecteOneEmploye(id);
		  return "an employe with id ="+id+"was deleted";
	}
	

}
