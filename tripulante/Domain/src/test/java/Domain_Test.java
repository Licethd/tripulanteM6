import org.junit.Assert;
import org.junit.Test;

public class Domain_Test {

    @Test
    public void DomainTest_Ok() {

        Domain Dom = new Domain();
        Domain.addDomain();
        Assert.assertNotNull(Dom);
    }
}
