import org.junit.Assert;
import org.junit.Test;
public class Application_Test {
    @Test
    public void AddApplicationAccept() {
        // INFO:Usamos el IMediator del kernel en cambio del MediatR de Spring
        Application App= new Application();
        Application.AddApplication();
        Assert.assertNotNull(App);
        

    }
}
