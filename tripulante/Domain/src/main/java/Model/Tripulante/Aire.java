package Model.Tripulante;

import java.util.UUID;

import Model.Tripulante.ValueObjects.HorasVuelo;
import Model.Tripulante.ValueObjects.NroMillas;

public class Aire extends Cargo {

	private HorasVuelo Horas_vuelo;
	private NroMillas Nro_millas;

	private String KeyTripulante_a;

	public Aire(Double Horas_vuelo, Double Nro_millas) {
		// super(sueldo, descripcion)

		this.Horas_vuelo = new HorasVuelo(Horas_vuelo);
		this.Nro_millas = new NroMillas(Nro_millas);
	}

	public HorasVuelo getHorasVuelo() {
		return Horas_vuelo;
	}

	public NroMillas getNroMillas() {
		return Nro_millas;
	}

	public void setHorasVuelo(HorasVuelo horas_vuelo) {
		this.Horas_vuelo = horas_vuelo;
	}

	public void setNroMillas(NroMillas nro_millas) {
		this.Nro_millas = nro_millas;
	}

	// @Override
	// public String toString() {
	// return new Gson().toJson(this);
	// }

	// CAMBIOS
	// public Aire(String keyTripulante, Double Horas_vuelo, Double Nro_millas) {
	// 	key = UUID.randomUUID();
	// 	this.KeyTripulante_a = keyTripulante;
	// 	this.Horas_vuelo = new HorasVuelo(Horas_vuelo);
	// 	this.Nro_millas = new NroMillas(Nro_millas);
	// }

}
