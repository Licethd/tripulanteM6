package Model.Tripulante;

import java.util.UUID;

// import com.google.gson.Gson;

public class Tierra extends Cargo {

	private String Descripcion_c;
	private String KeyTripulante_t;

	public Tierra(String descripcion_c) {
		// super(sueldo, descripcion, nombre, apellido, emailAddress);

		this.Descripcion_c = descripcion_c;
	}

	public String getDescripcion_c() {
		return Descripcion_c;
	}

	public void setDescripcion_c(String descripcion_c) {
		this.Descripcion_c = descripcion_c;
	}

	// @Override
	// public String toString() {
	// return new Gson().toJson(this);
	// }

	// CAMBIOS
	// public Tierra(String keyTripulante) {
	// 	key = UUID.randomUUID();
	// 	this.KeyTripulante_t = keyTripulante;
	// }

}
