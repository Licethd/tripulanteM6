package UsesCases.Command.Cargo.Editar;

import java.security.KeyException;
import java.util.UUID;

import Dto.Cargo.CargoDto;
import Dto.Tripulante.TripulanteDto;
import fourteam.mediator.Request;

public class EditarCargoCommand implements Request<CargoDto> {

    public CargoDto cargoDto;

    public EditarCargoCommand(UUID key) {
        this.cargoDto = new CargoDto();
        this.cargoDto.setKey(key);
    }

    // public EditarTripulanteCommand(TripulanteDto _tripulanteDto) {
    //     this.tripulanteDto = _tripulanteDto;
    // }

}
