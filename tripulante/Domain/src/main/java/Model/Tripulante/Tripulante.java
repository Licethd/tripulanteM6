package Model.Tripulante;

import Event.PersonalRegistrado;
import core.AggregateRoot;
import java.util.UUID;

public class Tripulante extends AggregateRoot<UUID> {

	private String Nombre;
	private String Apellido;
	private String EmailAddress;
	private String Estado;
	private String Tipo;
	private Double HorasVuelo;
	private Double NroMillas;

	Cargo Cargo;
	private Tierra cargo_tierra;
	private Aire cargo_aire;

	public Tripulante() {}

	public Tripulante(
		String nombre,
		String apellido,
		String emailAddress,
		String estado,
		String tipo,
		Double horasVuelo,
		Double nroMillas,
		Cargo cargo
	) {
		key = UUID.randomUUID();
		this.Nombre = nombre;
		this.Apellido = apellido;
		this.EmailAddress = emailAddress;
		this.Estado = estado;
		this.Tipo = tipo;
		this.HorasVuelo = horasVuelo;
		this.NroMillas = nroMillas;
		this.Cargo = cargo;
	}

	public void eventCreado() {
		addDomainEvent(new PersonalRegistrado(key, Nombre));
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		this.Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		this.Apellido = apellido;
	}

	public String getEmailAddress() {
		return EmailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.EmailAddress = emailAddress;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		this.Estado = estado;
	}


	public String getTipo() {
		return this.Tipo;
	}

	public void setTipo(String tipo) {
		this.Tipo = tipo;
	}

	public Double getHorasVuelo() {
		return this.HorasVuelo;
	}

	public void setHorasVuelo(Double horasVuelo) {
		this.HorasVuelo = horasVuelo;
	}

	public Double getNroMillas() {
		return this.NroMillas;
	}

	public void setNroMillas(Double nroMillas) {
		this.NroMillas = nroMillas;
	}



	public Cargo getCargo() {
		return Cargo;
	}

	public void setCargo(Cargo cargo) {
		this.Cargo = cargo;
	}
}
