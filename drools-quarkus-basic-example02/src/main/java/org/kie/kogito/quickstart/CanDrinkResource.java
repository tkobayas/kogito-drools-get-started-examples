package org.kie.kogito.quickstart;

import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.kie.kogito.rules.impl.SessionData;
import org.kie.kogito.rules.impl.SessionUnit;

@Path("/candrink2")
public class CanDrinkResource {

    @Named("canDrink2KS")
    SessionUnit ruleUnit;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String canDrink(Person person) {

        Result result = new Result();

        SessionData data = new SessionData();
        data.add(result);
        data.add(person);

        ruleUnit.evaluate(data);

        return result.toString();
    }
}
