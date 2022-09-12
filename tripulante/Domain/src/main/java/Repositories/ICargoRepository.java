package Repositories;

import java.util.List;
import java.util.UUID;

// import Domain.Model.Cargo.Aeronave;
import Model.Tripulante.Cargo;
import core.IRepository;

public interface ICargoRepository extends IRepository<Cargo, UUID> {
	public List<Cargo> GetAll();

    public Cargo Delete(Cargo cargo);

    public Cargo Update(Cargo cargo);
}
