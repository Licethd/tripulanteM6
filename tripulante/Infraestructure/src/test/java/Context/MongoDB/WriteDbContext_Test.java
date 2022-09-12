package Context.MongoDB;

import fourteam.db.DbSet;
import java.util.ArrayList;
import org.junit.Test;
import org.mockito.Mockito;

public class WriteDbContext_Test {

	DbSet dbSet = Mockito.mock(DbSet.class);

	@Test
	public void test() {
		WriteDbContext writeDbContext = new WriteDbContext();
		writeDbContext.onModelCreating(new ArrayList<DbSet>());
		writeDbContext.isConnected();
		writeDbContext.Commit();
		writeDbContext.Transaction();
		writeDbContext.Rollback();
	}
}
