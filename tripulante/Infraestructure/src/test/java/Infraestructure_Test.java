import org.junit.Assert;
import org.junit.Test;

public class Infraestructure_Test {

    @Test
    public void Infraestructure_Ok() {

        Infraestructure Infraestruc = new Infraestructure();
        Infraestructure.AddInfraestructure();
        Assert.assertNotNull(Infraestruc);
    }

}