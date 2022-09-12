package Repositories;

import java.util.List;
import java.util.UUID;

import Model.Tripulacion.Tripulacion;
// import Domain.Model.Cargo.Aeronave;
import Model.Tripulante.Cargo;
import core.IRepository;

public interface ITripulacionRepository extends IRepository<Tripulacion, UUID> {
	public List<Tripulacion> GetAll();

    public Tripulacion Delete(Tripulacion tripulacion);

    public Tripulacion Update(Tripulacion tripulacion);
}
