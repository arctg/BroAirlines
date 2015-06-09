package servlet;

import commands.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * Created by dennis on 24.05.2015.
 */
public class ControllerHelper {
    private static ControllerHelper instance = null;
    HashMap<String, Command> commands = new HashMap<String, Command>();

    private ControllerHelper(){
        commands.put("register", new RegisterCommand());
        commands.put("login", new LoginCommand());
        commands.put("logout", new LogoutCommand());
        commands.put("gotoregister", new GoToRegisterCommand());
        commands.put("gotologin", new GoToLoginCommand());
        commands.put("gotocabinet",new GoToCabinetCommand());
        commands.put("gotoadminpanel",new GoToAdminPanelCommand());
        commands.put("gotomain",new GoToMainCommand());
        commands.put("addflight", new AddFlightCommand());
        commands.put("findflight", new FindFlightCommand());
        commands.put("gotobook", new GoToBookCommand());
        commands.put("pay", new PayCommand());
        commands.put("deleterder", new DeleteOrderCommand());
    }

    public Command getCommand(HttpServletRequest request) {
        Command command = commands.get(request.getParameter("command"));
        System.out.println("from ControllerHelper");
        if(command==null){
            command = new MissingCommand();
        }
        return command;
    }

    public static ControllerHelper getInstance() {
        if (instance == null) {
            instance = new ControllerHelper();
        }
        return instance;
    }
}
