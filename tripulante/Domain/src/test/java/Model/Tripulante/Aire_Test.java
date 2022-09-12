package Model.Tripulante;

import static org.mockito.ArgumentMatchers.anyDouble;

import Model.Tripulante.ValueObjects.HorasVuelo;
import Model.Tripulante.ValueObjects.NroMillas;
import fourteam.http.Exception.HttpException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Aire_Test {

	@Before
	public void setup() {}

	@Test
	public void HandleAire_Ok() throws HttpException {
		// creando tripulante
		HorasVuelo horasVueloTest = new HorasVuelo(150.99);
		NroMillas nroMillasTest = new NroMillas(250.99);

		Aire AireTest2 = new Aire(anyDouble(), anyDouble());

		AireTest2.setHorasVuelo(horasVueloTest);
		AireTest2.setNroMillas(nroMillasTest);

		Assert.assertEquals(horasVueloTest, AireTest2.getHorasVuelo());
		Assert.assertEquals(nroMillasTest, AireTest2.getNroMillas());
	}
}
