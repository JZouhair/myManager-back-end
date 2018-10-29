package org.com.app.metier;

import static org.com.app.tables.Employe.EMPLOYE;

import java.util.List;

import static org.com.app.tables.Project.PROJECT;
import org.com.app.tables.pojos.Employe;
import org.com.app.tables.pojos.Project;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;

public class ProjectTraitement implements InterProjectTraitement {

	@Autowired
	private DSLContext dsl;
	public ProjectTraitement(DSLContext dsl) {
		super();
		this.dsl = dsl;
	}
	//SELECT * FROM PROJECT
	@Override
	public List<Project> selectAllProject() {
		return  dsl
				.selectFrom(PROJECT)
				.fetchInto(Project.class);
	}
	//SELECT ONE FROM PROJECT
	@Override
	public List<Project> selectOneProject(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	//DELETE FROM PROJECT
	@Override
	public void delecteOneProject(int id) {
		// TODO Auto-generated method stub
		
	}
	//UPDATE PROJECT
	@Override
	public void updateProject(Project project) {
		// TODO Auto-generated method stub
		
	}
	//INSERT INTO PROJECT
	@Override
	public void addOneProject(Project prject) {
		// TODO Auto-generated method stub
		
	}

}
