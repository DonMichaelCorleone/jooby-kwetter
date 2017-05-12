package no.homo;

import java.util.List;
import javafx.application.Application;
import org.jooby.Jooby;
import no.homo.controller.MessageController;
import no.homo.domain.DataBaas;
import no.homo.domain.User;
import org.jooby.Results;
import org.jooby.Session;

/**
 * @author jooby generator
 */
public class App extends Jooby {

    private MessageController messageController;

    {
        onStart(() -> {
            messageController = new MessageController();
        });
    }

//    {
//        cookieSession();
//
//        get("/login", req -> {
//            String userName = req.param("username").value();
//            String password = req.param("password").value();
//            Session session = req.session();
//            session.set("session", userName);
////            for (User user : DataBaas.getInstance().getUsers()) {
////                if (user.getUserName() == userName && user.getPassword() == password) {
////                    session.set("session", user.getUserName().hashCode());
////                    return session.get(userName).value();
////                }
////            }
//            return session;
//        });
//    }
    {
        get("/", () -> messageController.getMessages());
    }
    
    {
        get("/message", () -> messageController.getMessages());
    }

    {
        post("/user/:username/:password", req -> {
            String userName = req.param("username").value();
            String password = req.param("password").value();
            messageController.postUser(userName, password);
            return Results.redirect("/");
        });
    }

    public static void main(final String[] args) {
        run(App::new, args);
    }

}
