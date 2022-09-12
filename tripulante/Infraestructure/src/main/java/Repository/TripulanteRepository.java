package Repository;

import java.util.List;
import java.util.UUID;

import Model.Tripulante.Tripulante;
import Repositories.ITripulanteRepository;
import Context.IWriteDbContext;
import fourteam.db.DbSet;

public class TripulanteRepository implements ITripulanteRepository {

    private DbSet<Tripulante> _tripulantes;

    public TripulanteRepository(IWriteDbContext database) {
        _tripulantes = database.Tripulante;
    }

    @Override
    public Tripulante FindByKey(UUID key) {
        return _tripulantes.Single(obj -> obj.key.toString().equals(key.toString()));
    }

    @Override
    public void Create(Tripulante obj) {
        _tripulantes.Add(obj);
    }

    @Override
    public List<Tripulante> GetAll() {
        return _tripulantes.All();
    }

    @Override
    public Tripulante Delete(Tripulante obj) {
        _tripulantes.Delete((it -> it.key.equals(obj.key)));
        return obj;

    }

    @Override
    public Tripulante Update(Tripulante obj) {
        _tripulantes.Update(obj, (it -> it.key.equals(obj.key)));
        return obj;
    }

}
