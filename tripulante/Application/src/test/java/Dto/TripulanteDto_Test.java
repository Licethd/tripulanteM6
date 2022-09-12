package Dto;

import Dto.Tripulante.TripulanteDto;
import Model.Tripulante.Cargo;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class TripulanteDto_Test {

	@Test
	public void CheckPropertiesValid() {
		UUID key = UUID.randomUUID();
		String nombre = "Juanito";
		String apellido = "Morales";
		String emailAddress = "juanito@gmail.com";
		String estado = "1";
		String tipo = "TIERRA";
		Cargo cargo = new Cargo("asistente");
		// TripulanteDto tripulante = new TripulanteDto();
		// TripulanteDto tripulante = new TripulanteDto(any(UUID.class), anyString(),  anyString(),  anyString(), any(Cargo.class));
		TripulanteDto tripulante = new TripulanteDto(
			null,
			null,
			null,
			null,
			null,
			null,
			null,
			null,
			null
		);

		Assert.assertEquals(null, tripulante.Key);
		Assert.assertNull(tripulante.Nombre);
		Assert.assertNull(tripulante.Apellido);
		Assert.assertNull(tripulante.EmailAddress);
		Assert.assertNull(tripulante.Estado);
		Assert.assertNull(tripulante.Tipo);
		Assert.assertNull(tripulante.Cargo);

		tripulante.setKey(key);
		tripulante.setNombre(nombre);
		tripulante.setApellido(apellido);
		tripulante.setEmailAddress(emailAddress);
		tripulante.setEstado(estado);
		tripulante.setTipo(tipo);
		tripulante.setCargo(cargo);

		// tripulante.Nombre = nombre;
		// tripulante.Apellido = apellido;
		// tripulante.EmailAddress = emailAddress;
		// tripulante.Cargo = cargo;

		//falta el dar los valores de ejemplo
		Assert.assertEquals(key, tripulante.getKey());
		Assert.assertEquals(nombre, tripulante.getNombre());
		Assert.assertEquals(apellido, tripulante.getApellido());
		Assert.assertEquals(emailAddress, tripulante.getEmailAddress());
		Assert.assertEquals(cargo, tripulante.getCargo());
	}
}
