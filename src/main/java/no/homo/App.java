package no.homo;

import java.util.List;
import org.jooby.Jooby;
import no.homo.controller.MessageController;
import no.homo.domain.DataBaas;
import no.homo.domain.User;
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

    {
        cookieSession();

        get("/login", req -> {
            String userName = req.param("username").value();
            String password = req.param("password").value();
            User u = null;
            Session session;
            for (User user : DataBaas.getInstance().getUsers()) {
                if (user.getUserName() == userName && user.getPassword() == password) {
                    u = user;
                    break;
                }
            }
            session = req.session();
            session.set(u.getUserName(), u.getPassword());
            return session.get(userName).value();
        });
    }

    {
        get("/message", () -> messageController.getMessages());
    }

    public static void main(final String[] args) {
        run(App::new, args);
    }

}
