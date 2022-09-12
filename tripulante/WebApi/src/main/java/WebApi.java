import Controllers.CargoController;
import Controllers.TripulacionController;
import Controllers.TripulanteController;
import fourteam.http.Rest;

public class WebApi {

	public static void AddControllers() {
		//prueba de hoy hoy

		Rest.addController(TripulanteController.class);
		Rest.addController(CargoController.class);
		Rest.addController(TripulacionController.class);

		Rest.start(8080);
		Rest.createSwagger();
	}

	public static void AddInfraestructure() {
		// TODO Auto-generated method stub

	}
}
