package Factories;

import Model.Tripulante.Cargo;
import Model.Tripulante.Tripulante;

public class TripulanteFactory implements ITripulanteFactory {

	// public enum Tipo{
	// Aire,
	// Tierra
	// }
	public TripulanteFactory() {

	}

	@Override
	public Tripulante Create(String nombre, String apellido, String emailAddress, String estado, String tipo,
			Double horasVuelo, Double nroMillas,
			Cargo cargo) {

		// switch (nombre) {
		// case Tipo.Aire:
		// return new Tripulante(nombre, apellido, emailAddress, cargo);
		// case Tipo.Tierra:
		// return new Tripulante(nombre, apellido, emailAddress, cargo);
		// default:
		// return null;
		// }
		return new Tripulante(nombre, apellido, emailAddress, estado, tipo, horasVuelo, nroMillas, cargo);
	}

}
