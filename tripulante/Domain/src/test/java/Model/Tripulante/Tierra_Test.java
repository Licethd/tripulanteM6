package Model.Tripulante;

import static org.mockito.ArgumentMatchers.anyString;

import fourteam.http.Exception.HttpException;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Tierra_Test {

	@Before
	public void setup() {}

	@Test
	public void HandleTierra_Ok() throws HttpException {
		String descripcioncTest = "piloto";

		Tierra TierrraTest2 = new Tierra(anyString());

		TierrraTest2.setDescripcion_c(descripcioncTest);

		Assert.assertEquals(descripcioncTest, TierrraTest2.getDescripcion_c());
	}
}
