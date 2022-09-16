package IntegrationEvents;

import core.IntegrationEvent;

import java.util.List;
import java.util.UUID;

public class TripulacionCreado extends IntegrationEvent {

	public UUID keyTripulacion;
	public String descripcion;
	public List<Tripulante> tripulantes;

	public UUID getKeyTripulacion() {
		return this.keyTripulacion;
	}

	public void setKeyTripulacion(UUID keyTripulacion) {
		this.keyTripulacion = keyTripulacion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Tripulante> getTripulantes() {
		return this.tripulantes;
	}

	public void setTripulantes(List<Tripulante> tripulantes) {
		this.tripulantes = tripulantes;
	}

	public class Tripulante {

		private String nombre;
		private String apellido;
		private String emailAddress;

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getApellido() {
			return apellido;
		}

		public void setApellido(String apellido) {
			this.apellido = apellido;
		}

		public String getEmailAddress() {
			return emailAddress;
		}

		public void setEmailAddress(String emailAddress) {
			this.emailAddress = emailAddress;
		}

	}

}
