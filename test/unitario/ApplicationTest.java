package unitario;

import models.SolucaoDoExercicio;
import org.junit.*;
import play.mvc.*;
<<<<<<< HEAD
import static org.hamcrest.CoreMatchers.is;
=======

>>>>>>> ea6003d1a395ad24f8fe4742fef4c5ceb61ebfd7
import static org.junit.Assert.*;
import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;


/**
*
* Simple (JUnit) tests that can call all parts of a play app.
* If you are interested in mocking a whole application, see the wiki for more details.
*
*/
public class ApplicationTest {

    @Test
    public void testandoSnapCI() {
        assertThat(true);
    }

    @Test
    public void SolucaoNaoPodeTerCorpoVazio() {
        SolucaoDoExercicio solucaoDoExercicio = new SolucaoDoExercicio("solucaoDoUsuario");
        assertNotNull(solucaoDoExercicio.solucaoDoUsuario);
    }

    @Test
    public void quandoChamaOMetodoIndexRetornaPositivo() {
        Result result = callAction(controllers.routes.ref.Application.index());
        assertThat(status(result)).isPositive();
    }

}
