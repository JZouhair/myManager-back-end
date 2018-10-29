package org.com.app.metier;

import java.util.List;
import org.com.app.tables.pojos.Project;

public interface InterProjectTraitement {

	public List<Project> selectAllProject() ;
	public List<Project>  selectOneProject(int id);
	public void delecteOneProject(int id);
	public void updateProject(Project project);
	public void addOneProject(Project prject);
}
