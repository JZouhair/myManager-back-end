package org.com.app.metier;
import java.util.List;
import static org.com.app.tables.Employe.EMPLOYE;
import org.com.app.tables.pojos.Employe;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class EmpTraitement implements InterTraitement {
	@Autowired
	private DSLContext dsl;
	public EmpTraitement(DSLContext dsl) {
		super();
		this.dsl = dsl;
	}
	//SELECT ONE
	@Override
	public List<Employe> selectOneEmploye(int id) {
		return dsl.selectFrom(EMPLOYE)
				.where(EMPLOYE.ID.eq(id))
				.fetchInto(Employe.class);
		}
	//SELECT ALL
	public List<Employe> selectAllEmploye(){
		return  dsl
				.selectFrom(EMPLOYE)
				.fetchInto(Employe.class);
	}
	//DELETE
	public void delecteOneEmploye(int id){
		 dsl.delete(EMPLOYE)
				.where(EMPLOYE.ID.eq(id))
                .execute();
	}
	//UPDATE
		public void updateEmp(Employe emp) {
			dsl.update(EMPLOYE)
			.set(EMPLOYE.CIN, emp.getCin())
			.set(EMPLOYE.EMAIL,emp.getEmail())
			.set(EMPLOYE.NAME, emp.getName())
			.set(EMPLOYE.ROLE, emp.getRole())
			.set(EMPLOYE.TELE, emp.getTele())
			.where(EMPLOYE.ID.equal(emp.getId()))
			.execute();
		}
	
	//INSERT
	public void addOneEmp(Employe emp) {
		dsl.insertInto(EMPLOYE)
		.set(EMPLOYE.ID, emp.getId())
		.set(EMPLOYE.CIN, emp.getCin())
		.set(EMPLOYE.EMAIL,emp.getEmail())
		.set(EMPLOYE.NAME, emp.getName())
		.set(EMPLOYE.ROLE, emp.getRole())
		.set(EMPLOYE.TELE, emp.getTele())
		.execute();
	}
	

	
	
	
	
	
	
	
	
	

}
