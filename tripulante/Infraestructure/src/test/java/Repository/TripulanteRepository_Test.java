package Repository;

import static org.mockito.ArgumentMatchers.any;

import Context.IWriteDbContext;
import Context.MongoDB.WriteDbContext;
import Model.Tripulante.Cargo;
import Model.Tripulante.Tripulante;
import fourteam.db.DbSet;
import fourteam.http.Exception.HttpException;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class TripulanteRepository_Test {

	@Before
	public void setup() {}

	IWriteDbContext bdTest = Mockito.mock(IWriteDbContext.class);
	DbSet<Tripulante> _tripulante = Mockito.mock(DbSet.class);

	@Before
	public void setUp() {
		bdTest.Tripulante = _tripulante;
	}

	@Test
	public void HandlePersonalRegistrado_Ok() throws HttpException {
		// creando tripulante
		UUID keyTest = UUID.randomUUID();
		String nombreTest = "Jose";
		String apellidoTest = "Perez";
		String emailAddressTest = "jose@gmail.com";
		String estadoTest = "1";
		String tipoTest = "AIRE";
		Double horasVueloTest = 1200.0;
		Double nroMillasTest = 5600.56;
		// Cargo cargoTest = "Piloto";
		Cargo cargoTest = new Cargo("asistente");

		IWriteDbContext bdTest = new WriteDbContext();

		TripulanteRepository tripulanteRepository = new TripulanteRepository(
			bdTest
		);

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
	}

	@Test
	public void GetAll_Test() {
		TripulanteRepository tripulanteRepository = new TripulanteRepository(
			bdTest
		);
		tripulanteRepository.GetAll();
		Assert.assertNotNull(tripulanteRepository);
	}

	@Test
	public void Create_Test() {
		TripulanteRepository tripulanteRepository = new TripulanteRepository(
			bdTest
		);
		tripulanteRepository.Create(any(Tripulante.class));
		Assert.assertNotNull(tripulanteRepository);
	}

	@Test
	public void Update_Test() {
		TripulanteRepository tripulanteRepository = new TripulanteRepository(
			bdTest
		);
		tripulanteRepository.Update(new Tripulante());
		Assert.assertNotNull(tripulanteRepository);
	}

	@Test
	public void Delete_Test() {
		TripulanteRepository tripulanteRepository = new TripulanteRepository(
			bdTest
		);
		tripulanteRepository.Delete(new Tripulante());
		Assert.assertNotNull(tripulanteRepository);
	}

	@Test
	public void FindByKey_Test() {
		TripulanteRepository tripulanteRepository = new TripulanteRepository(
			bdTest
		);
		tripulanteRepository.FindByKey(UUID.randomUUID());
		Assert.assertNotNull(tripulanteRepository);
	}
	// @Test
	// public void GetByKey_Test() {
	//     TripulanteRepository tripulanteRepository = new TripulanteRepository(bdTest);
	//     UUID keyTest = UUID.randomUUID();
	//     Tripulante tripulanteTest = new Tripulante("Jose", "Perez", "");
	// }

}
