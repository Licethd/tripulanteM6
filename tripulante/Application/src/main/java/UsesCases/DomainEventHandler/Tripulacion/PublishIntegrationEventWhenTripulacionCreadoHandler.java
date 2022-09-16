package UsesCases.DomainEventHandler.Tripulacion;

import Event.TripulacionRegistrado;
import core.ConfirmedDomainEvent;
import fourteam.massTransit.IPublishEndpoint;
import fourteam.mediator.Notification;
import fourteam.mediator.NotificationHandler;

public class PublishIntegrationEventWhenTripulacionCreadoHandler
  implements NotificationHandler<ConfirmedDomainEvent<TripulacionRegistrado>> {

  private IPublishEndpoint publishEndpoint;

  public PublishIntegrationEventWhenTripulacionCreadoHandler(IPublishEndpoint publishEndpoint) {
    this.publishEndpoint = publishEndpoint;
  }

  @Override
  public void handle(Notification notification) {
    ConfirmedDomainEvent event = (ConfirmedDomainEvent) notification;
    TripulacionRegistrado tripulacion = (TripulacionRegistrado) event.DomainEvent;
    IntegrationEvents.TripulacionCreado evento = new IntegrationEvents.TripulacionCreado();
    evento.setKeyTripulacion(tripulacion.getKey());
    evento.setDescripcion(tripulacion.getNombre());
    this.publishEndpoint.Publish(evento);
  }
}
