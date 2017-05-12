package no.homo.controller;

import no.homo.domain.DataBaas;
import no.homo.domain.User;
import org.jooby.mvc.GET;
import org.jooby.mvc.POST;
import org.jooby.mvc.Path;

/**
 *
 * @author Loek, Stan & Ramòn
 */
@Path("/")
public class MessageController {

    @GET
    public String getMessages() {
        return "hey jooby";
    }

    @POST
    public void postUser(String userName, String password) {
        DataBaas.getInstance().addUser(new User(userName, password));
        System.out.println(DataBaas.getInstance().getUsers().toString());
    }
}
