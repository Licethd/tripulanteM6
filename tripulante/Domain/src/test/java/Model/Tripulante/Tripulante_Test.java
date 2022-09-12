package Model.Tripulante;

import fourteam.http.Exception.HttpException;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Tripulante_Test {

	@Before
	public void setup() {}

	@Test
	public void HandleTripulante_Ok() throws HttpException {
		// creando tripulante
		String nombreTest = "Jose";
		String apellidoTest = "Perez";
		String emailAddressTest = "jose@gmail.com";
		Cargo cargoTest = new Cargo( "asistente");

		Tripulante tripulanteTest = new Tripulante();

		tripulanteTest.setNombre(nombreTest);
		tripulanteTest.setApellido(apellidoTest);
		tripulanteTest.setEmailAddress(emailAddressTest);
		tripulanteTest.setCargo(cargoTest);

		Assert.assertEquals(nombreTest, tripulanteTest.getNombre());
		Assert.assertEquals(apellidoTest, tripulanteTest.getApellido());
		Assert.assertEquals(emailAddressTest, tripulanteTest.getEmailAddress());
		Assert.assertEquals(cargoTest, tripulanteTest.getCargo());

		tripulanteTest.eventCreado();
	}
}
