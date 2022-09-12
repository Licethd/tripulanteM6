package Model.Tripulacion;

import Event.PersonalRegistrado;
import Event.TripulacionRegistrado;
import Model.Tripulante.Aire;
import Model.Tripulante.Cargo;
import Model.Tripulante.Tierra;
import core.AggregateRoot;
import core.Entity;

import java.sql.Date;
import java.util.UUID;

public class TripulacionDetalle extends Entity<UUID> {
    public UUID KeyTripulacion;
	private String Nombre;
	private String Estado;
	private Date FechaOn;



	public TripulacionDetalle() {}

	public TripulacionDetalle(
		UUID keyTripulacion,
		String nombre,
		String estado,
		Date fechaOn
	) {
		key = UUID.randomUUID();
		this.KeyTripulacion = keyTripulacion;
		this.Nombre = nombre;
		this.Estado = estado;
		this.FechaOn = fechaOn;
	}

	public void eventCreado() {
		addDomainEvent(new TripulacionRegistrado(key, Nombre));
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		this.Nombre = nombre;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		this.Estado = estado;
	}

	public Date getFechaOn() {
		return this.FechaOn;
	}

	public void setFechaOn(Date fechaOn) {
		this.FechaOn = fechaOn;
	}




}
