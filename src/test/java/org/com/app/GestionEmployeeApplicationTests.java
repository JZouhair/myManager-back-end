package org.com.app;

import static org.assertj.core.api.Assertions.assertThat;
import static org.com.app.tables.Employe.EMPLOYE;
import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.List;

import org.com.app.tables.pojos.Employe;
import org.jooq.DSLContext;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DSL;
import org.jooq.tools.jdbc.MockConnection;
import org.jooq.tools.jdbc.MockDataProvider;
import org.junit.BeforeClass;
import org.junit.Test;

public class GestionEmployeeApplicationTests {

	private static DSLContext JOOQ_CONTEXT;
	
	@BeforeClass
	public static void init() {
		MockDataProvider provider = new MockProvider();
		MockConnection connection = new MockConnection(provider);
		JOOQ_CONTEXT = DSL.using(connection);
	}

	@Test
	public void shouldReturnTheEmployeWithId() {
		List<Employe> foundEmployees =
				JOOQ_CONTEXT.selectFrom(EMPLOYE)
					.where(EMPLOYE.ID.eq(1))
					.fetchInto(Employe.class);
		
		assertThat(foundEmployees.size()).isEqualTo(1);
		
		Employe emp = foundEmployees.get(0);
		
		assertEquals(1, (long) emp.getId());
		assertEquals("BK5573", emp.getCin());
	}

	@Test(expected = DataAccessException.class)
	public void shouldThrowExceptionWhenDropping() {
		JOOQ_CONTEXT.dropTable(EMPLOYE).execute();
	}
	
}
