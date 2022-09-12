package Factories;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyString;

import Model.Tripulante.Cargo;
import Model.Tripulante.Tripulante;
import fourteam.http.Exception.HttpException;
import org.junit.Before;
import org.junit.Test;

public class TripulanteFactory_Test {

	@Before
	public void setup() {}

	@Test
	public void HandleTripulanteFactory_Ok() throws HttpException {
		//creando tripulante
		String nombreTest = "Jose";
		String apellidoTest = "Perez";
		String emailAddressTest = "jose@gmail.com";
		String estadoTest = "1";
		String tipoTest = "AIRE";
		Double horasVueloTest = 1200.0;
		Double nroMillasTest = 5600.56;
		Cargo cargoTest = new Cargo("asistente");
		Tripulante tripulanteTest = new Tripulante(
			nombreTest,
			apellidoTest,
			emailAddressTest,
			estadoTest,
			tipoTest,
			horasVueloTest,
			nroMillasTest,
			cargoTest
		);

		TripulanteFactory factoryTest = new TripulanteFactory();
		Tripulante tripulanteDtoTest2 = factoryTest.Create(
			anyString(),
			anyString(),
			anyString(),
			anyString(),
			anyString(),
			anyDouble(),
			anyDouble(),
			any(Cargo.class)
		);
	}
}
