package Repository;

import java.util.List;
import java.util.UUID;

import Model.Tripulacion.Tripulacion;
import Model.Tripulante.Cargo;
import Repositories.ICargoRepository;
import Repositories.ITripulacionRepository;
import Context.IWriteDbContext;
import fourteam.db.DbSet;

public class TripulacionRepository implements ITripulacionRepository {

    private DbSet<Tripulacion> _tripulacion;

    public TripulacionRepository(IWriteDbContext database) {
        _tripulacion = database.Tripulacion;
    }

    @Override
    public Tripulacion FindByKey(UUID key) {
        return _tripulacion.Single(obj -> obj.key.toString().equals(key.toString()));
    }

    @Override
    public void Create(Tripulacion obj) {
        _tripulacion.Add(obj);
    }

    @Override
    public List<Tripulacion> GetAll() {
        return _tripulacion.All();
    }

    @Override
    public Tripulacion Delete(Tripulacion obj) {
        _tripulacion.Delete((it -> it.key.equals(obj.key)));
        return obj;

    }

    @Override
    public Tripulacion Update(Tripulacion obj) {
        _tripulacion.Update(obj, (it -> it.key.equals(obj.key)));
        return obj;
    }

}
