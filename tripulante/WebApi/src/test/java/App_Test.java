import org.junit.Assert;
import org.junit.Test;

public class App_Test {

    @Test
    public void App_Ok() {

        App AppTest = new App();
        App.main(null);
        Assert.assertNotNull(AppTest);
    }

}