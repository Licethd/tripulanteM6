// import UsesCases.Command.Cargo.UpdateCargoWhenTripulanteCreado.UpdateCargoWhenTripulanteCreado;
import UsesCases.Command.Cargo.Crear.CrearCargoHandler;
import UsesCases.Command.Cargo.Editar.EditarCargoHandler;
import UsesCases.Command.Cargo.Eliminar.EliminarCargoHandler;
import UsesCases.Command.Tripulacion.Crear.CrearTripulacionHandler;
import UsesCases.Command.Tripulacion.Editar.EditarTripulacionHandler;
import UsesCases.Command.Tripulacion.Eliminar.EliminarTripulacionHandler;
import UsesCases.Command.Tripulante.Crear.CrearTripulanteHandler;
import UsesCases.Command.Tripulante.Editar.EditarTripulanteHandler;
import UsesCases.Command.Tripulante.Eliminar.EliminarTripulanteHandler;
import UsesCases.Queries.Cargo.GetAll.GetAllCargoHandler;
import UsesCases.Queries.Cargo.GetByKey.GetCargoByKeyHandler;
import UsesCases.Queries.Tripulante.GetAll.GetAllTripulanteHandler;
import UsesCases.Queries.Tripulante.GetByKey.GetTripulanteByKeyHandler;
import Factories.CargoFactory;
import Factories.ICargoFactory;
import Factories.ITripulacionFactory;
import Factories.ITripulanteFactory;
import Factories.TripulacionFactory;
import Factories.TripulanteFactory;
import fourteam.extensions.IServiceCollection;
import fourteam.mediator.IMediator;

public class Application {

    public static void AddApplication() {
        // INFO:Usamos el IMediator del SharedKernel en cambio del MediatR de Spring
		//TRIPULANTE
        IMediator.registerHandler(GetAllTripulanteHandler.class);
        IMediator.registerHandler(GetTripulanteByKeyHandler.class);

		IMediator.registerHandler(CrearTripulanteHandler.class);
        IMediator.registerHandler(EliminarTripulanteHandler.class);
        IMediator.registerHandler(EditarTripulanteHandler.class);

		//CARGO
		IMediator.registerHandler(GetAllCargoHandler.class);
        IMediator.registerHandler(GetCargoByKeyHandler.class);

        IMediator.registerHandler(CrearCargoHandler.class);
        IMediator.registerHandler(EliminarCargoHandler.class);
        IMediator.registerHandler(EditarCargoHandler.class);

		//TRIPULACION
		// IMediator.registerHandler(GetAllCargoHandler.class);
        // IMediator.registerHandler(GetCargoByKeyHandler.class);

        IMediator.registerHandler(CrearTripulacionHandler.class);
        IMediator.registerHandler(EliminarTripulacionHandler.class);
        IMediator.registerHandler(EditarTripulacionHandler.class);

        // IMediator.registerHandler(UpdateCargoWhenTripulanteCreado.class);

        IServiceCollection.AddTransient(ITripulanteFactory.class, TripulanteFactory.class);
        IServiceCollection.AddTransient(ICargoFactory.class, CargoFactory.class);
        IServiceCollection.AddTransient(ITripulacionFactory.class, TripulacionFactory.class);
    }
}
