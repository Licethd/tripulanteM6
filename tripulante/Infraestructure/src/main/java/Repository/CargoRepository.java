package Repository;

import java.util.List;
import java.util.UUID;

import Model.Tripulante.Cargo;
import Repositories.ICargoRepository;
import Context.IWriteDbContext;
import fourteam.db.DbSet;

public class CargoRepository implements ICargoRepository {

    private DbSet<Cargo> _cargo;

    public CargoRepository(IWriteDbContext database) {
        _cargo = database.Cargo;
    }

    @Override
    public Cargo FindByKey(UUID key) {
        return _cargo.Single(obj -> obj.key.toString().equals(key.toString()));
    }

    @Override
    public void Create(Cargo obj) {
        _cargo.Add(obj);
    }

    @Override
    public List<Cargo> GetAll() {
        return _cargo.All();
    }

    @Override
    public Cargo Delete(Cargo obj) {
        _cargo.Delete((it -> it.key.equals(obj.key)));
        return obj;

    }

    @Override
    public Cargo Update(Cargo obj) {
        _cargo.Update(obj, (it -> it.key.equals(obj.key)));
        return obj;
    }

}
