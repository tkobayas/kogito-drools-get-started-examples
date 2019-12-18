package org.kie.kogito.quickstart;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.kie.api.runtime.KieSession;
import org.kie.kogito.rules.KieRuntimeBuilder;

@Path("/candrink")
public class CanDrinkResource {

    @Inject
    KieRuntimeBuilder runtimeBuilder;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String canDrink(Person person) {
        KieSession ksession = runtimeBuilder.newKieSession("canDrinkKS");

        Result result = new Result();
        ksession.insert(result);
        ksession.insert(person);

        ksession.fireAllRules();

        return result.toString();
    }
}
