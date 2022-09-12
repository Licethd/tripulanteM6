package Controllers;

import static org.mockito.ArgumentMatchers.any;

import Factories.ITripulanteFactory;
import Model.Tripulante.Cargo;
import Repositories.ITripulanteRepository;
import UsesCases.Queries.Tripulante.GetAll.GetAllTripulanteQuery;
import fourteam.http.Exception.HttpException;
import fourteam.mediator.Mediator;
import java.util.UUID;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class TripulanteController_Test {

	ITripulanteFactory tripulanteFactory = Mockito.mock(
		ITripulanteFactory.class
	);
	ITripulanteRepository tripulanteRepository = Mockito.mock(
		ITripulanteRepository.class
	);
	GetAllTripulanteQuery getAllQuery = Mockito.mock(
		GetAllTripulanteQuery.class
	);
	Mediator mediator = Mockito.mock(Mediator.class);

	@Before
	public void setup() {}

	@Test
	public void HandleTripulanteController_Ok() throws HttpException {
		// creando tripulante

		Cargo cargoTest = new Cargo("asistente");

		TripulanteController tripulanteController = new TripulanteController(
			any(Mediator.class)
		);
		mediator.send(new GetAllTripulanteQuery());
		//tripulanteController.getAll();

	}
}
