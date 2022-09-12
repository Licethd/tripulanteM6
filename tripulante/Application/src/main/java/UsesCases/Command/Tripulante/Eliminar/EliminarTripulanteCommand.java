package UsesCases.Command.Tripulante.Eliminar;

import java.util.UUID;

import Dto.Tripulante.TripulanteDto;
import fourteam.mediator.Request;

public class EliminarTripulanteCommand implements Request<TripulanteDto> {

    TripulanteDto tripulante;
    public EliminarTripulanteCommand(UUID key) {
        this.tripulante = new TripulanteDto();
        this.tripulante.Key = key;
    }

}
