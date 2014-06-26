package controllers;

import play.data.Form;
import play.mvc.*;
import models.*;

public class Application extends Controller {

    static Form<SolucaoDoExercicio> solucaoDoExercicioForm = Form.form(SolucaoDoExercicio.class);

    public static Result index() {

        return redirect(routes.Application.solucoes());
    }

    public static Result solucoes(){
        return ok(views.html.index.render(SolucaoDoExercicio.all(), solucaoDoExercicioForm));
    }


    public static Result  novaSolucao(){
        Form<SolucaoDoExercicio> formPreenchido = solucaoDoExercicioForm.bindFromRequest();

        if(formPreenchido.hasErrors()){
            return badRequest(views.html.index.render(SolucaoDoExercicio.all(), formPreenchido));
        } else{
            SolucaoDoExercicio.create(formPreenchido.get());
            return redirect(routes.Application.solucoes());
        }

    }

    public static Result deletaSolucao(int id){
        SolucaoDoExercicio.delete(id);
        return redirect(routes.Application.solucoes());
    }

}