
import Repositories.*;
import fourteam.extensions.IServiceCollection;
import Context.IWriteDbContext;
import Repository.*;
import UsesCases.Consumers.CheckInCreadoConsumer;

public class Infraestructure {
    public static void AddInfraestructure() {

        IServiceCollection.AddMediator();

        IServiceCollection.AddScoped(IWriteDbContext.class, Context.MongoDB.WriteDbContext.class);
        IServiceCollection.AddScoped(IUnitOfWork.class, UnitOfWork.class);
        IServiceCollection.AddScoped(ITripulanteRepository.class, TripulanteRepository.class);
        IServiceCollection.AddScoped(ICargoRepository.class,  CargoRepository.class);
        IServiceCollection.AddScoped(ITripulacionRepository.class,  TripulacionRepository.class);
        Application.AddApplication();
		AddRabbitMq();
    }

	private static void AddRabbitMq() {
		IServiceCollection.AddMassTransit(config -> {
		  // config.AddConsumer(CheckInCreadoConsumer.class).Endpoint(endpoint -> {
		  // endpoint.Name = CheckInCreadoConsumer.QueueName;
		  // });
		  config.AddConsumer(CheckInCreadoConsumer.class);

		  config.UsingRabbitMq((context, cfg) -> {
			cfg.Host = "192.168.3.2";
			// cfg.ReceiveEndpoint(CheckInCreadoConsumer.QueueName, endpoint -> {
			//   endpoint.ConfigureConsumer(CheckInCreadoConsumer.class);
			// });
		  });
		});
	  }
}
