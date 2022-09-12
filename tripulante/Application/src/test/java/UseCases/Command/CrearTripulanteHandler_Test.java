package UseCases.Command;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import Dto.Tripulante.TripulanteDto;
import UsesCases.Command.Tripulante.Crear.CrearTripulanteCommand;
import UsesCases.Command.Tripulante.Crear.CrearTripulanteHandler;
import UsesCases.Command.Tripulante.Eliminar.EliminarTripulanteCommand;
import UsesCases.Command.Tripulante.Eliminar.EliminarTripulanteHandler;
import Event.PersonalRegistrado;
import Factories.ITripulanteFactory;
import Model.Tripulante.Cargo;
import Model.Tripulante.Tripulante;
import Repositories.ITripulanteRepository;
import Repositories.IUnitOfWork;
import fourteam.http.Exception.HttpException;

public class CrearTripulanteHandler_Test {

	ITripulanteFactory tripulanteFactory = Mockito.mock(ITripulanteFactory.class);
	ITripulanteRepository tripulanteRepository = Mockito.mock(ITripulanteRepository.class);
	IUnitOfWork unitOfWork = Mockito.mock(IUnitOfWork.class);

	@Before
	public void setup() {

	}

	@Test
	public void Handle_Ok() throws HttpException {

		// creando tripulante
		UUID keyTest = UUID.randomUUID();
		String nombreTest = "Jose";
		String apellidoTest = "Perez";
		String emailAddressTest = "jose@gmail.com";
		String estadoTest = "1";
		String tipoTest = "TIERRA";
		Double horasVueloTest = 1200.0;
		Double nroMillasTest = 5600.56;
		// Cargo cargoTest = "Piloto";
		Cargo cargoTest = new Cargo("asistente");

		TripulanteDto tripulanteDtoTest = new TripulanteDto();
		// TripulanteDto tripulanteDtoTest2 = new TripulanteDto(
		// UUID.randomUUID(),anyString(),anyString(),anyString(), any(Cargo.class));

		tripulanteDtoTest.setKey(keyTest);
		tripulanteDtoTest.setNombre(nombreTest);
		tripulanteDtoTest.setApellido(apellidoTest);
		tripulanteDtoTest.setEmailAddress(emailAddressTest);
		tripulanteDtoTest.setEstado(estadoTest);
		tripulanteDtoTest.setCargo(cargoTest);

		Tripulante tripulanteTest = new Tripulante(nombreTest, apellidoTest, emailAddressTest, estadoTest, tipoTest,
				horasVueloTest, nroMillasTest, cargoTest);
		CrearTripulanteCommand command = new CrearTripulanteCommand(tripulanteDtoTest);

		when(tripulanteFactory.Create(anyString(), anyString(), anyString(), anyString(), anyString(), anyDouble(),
				anyDouble(), any(Cargo.class))).thenReturn(tripulanteTest);

		CrearTripulanteHandler handler = new CrearTripulanteHandler(tripulanteFactory, tripulanteRepository,
				unitOfWork);

		Tripulante respuesta = handler.handle(command);

		verify(tripulanteRepository).Create(respuesta);
		verify(unitOfWork).commit();

		Assert.assertEquals(PersonalRegistrado.class,
				respuesta.domainEvents.get(0).getClass());
		Assert.assertEquals(nombreTest, respuesta.getNombre());
		Assert.assertEquals(apellidoTest, respuesta.getApellido());
		Assert.assertEquals(emailAddressTest, respuesta.getEmailAddress());
		Assert.assertEquals(cargoTest, respuesta.getCargo());

		// ELIMINAR
		EliminarTripulanteCommand commandDelete = new EliminarTripulanteCommand(tripulanteDtoTest.Key);
		when(tripulanteRepository.FindByKey(tripulanteDtoTest.Key)).thenReturn(tripulanteTest);
		EliminarTripulanteHandler handlerDelete = new EliminarTripulanteHandler(tripulanteFactory, tripulanteRepository,
				unitOfWork);
		when(tripulanteRepository.Delete(tripulanteTest)).thenReturn(tripulanteTest);
		Tripulante respuestaDelete = handlerDelete.handle(commandDelete);
		verify(tripulanteRepository).Delete(respuestaDelete);

		// TEST ELIMINAR NO EXISTE
		EliminarTripulanteCommand commandDelete2 = new EliminarTripulanteCommand(UUID.randomUUID());
		when(tripulanteRepository.FindByKey(UUID.randomUUID())).thenReturn(tripulanteTest);
		EliminarTripulanteHandler handlerDelete2 = new EliminarTripulanteHandler(tripulanteFactory,
				tripulanteRepository, unitOfWork);

		try {
			handlerDelete2.handle(commandDelete2);
		} catch (HttpException e) {
			Assert.assertEquals(400, e.getCode());
		}

	}
}
