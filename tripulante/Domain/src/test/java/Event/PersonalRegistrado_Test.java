package Event;

import java.util.UUID;
import org.junit.Before;
import org.junit.Test;

import fourteam.http.Exception.HttpException;

public class PersonalRegistrado_Test {

    @Before
    public void setup() {

    }

    @Test
    public void HandlePersonalRegistrado_Ok() throws HttpException {
        // creando tripulante
        UUID keyTest = UUID.randomUUID();
        String nombreTest = "Jose";
        String nombreTest2 = "Juana";

        PersonalRegistrado personalRegistradoTest = new PersonalRegistrado(keyTest, nombreTest);

        personalRegistradoTest.setNombre(nombreTest2);
        String nombreReturn = personalRegistradoTest.getNombre();

    }
}
