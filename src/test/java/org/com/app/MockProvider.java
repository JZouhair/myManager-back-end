package org.com.app;

import static org.com.app.tables.Employe.EMPLOYE;

import java.sql.SQLException;

import org.jooq.DSLContext;
import org.jooq.Record7;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.tools.jdbc.MockDataProvider;
import org.jooq.tools.jdbc.MockExecuteContext;
import org.jooq.tools.jdbc.MockResult;

public class MockProvider implements MockDataProvider {

	@Override
	public MockResult[] execute(MockExecuteContext mec) throws SQLException {
		DSLContext context = DSL.using(SQLDialect.MYSQL_5_7);
		MockResult[] mock = new MockResult[1];
		
		String sql = mec.sql();
		
		if(sql.toUpperCase().startsWith("DROP")) {
			throw new SQLException("Operation not supported");
		} else if(sql.toUpperCase().startsWith("SELECT")) {
			Result<Record7<Integer, String, String, String, String, String, Integer>> result =
					context.newResult(EMPLOYE.ID, EMPLOYE.NAME, EMPLOYE.CIN, EMPLOYE.EMAIL, EMPLOYE.TELE, EMPLOYE.ROLE, EMPLOYE.ID_DEPT);
			
			result.add(
					context.newRecord(EMPLOYE.ID, EMPLOYE.NAME, EMPLOYE.CIN, EMPLOYE.EMAIL, EMPLOYE.TELE, EMPLOYE.ROLE, EMPLOYE.ID_DEPT)
					.values(1, "ZOUHAIR", "BK5573", null, null, null, null));
			
			mock[0] = new MockResult(1, result);
		}
		
		return mock;
	}

}
