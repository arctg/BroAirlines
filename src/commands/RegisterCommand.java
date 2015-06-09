package commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import logic.LoginChecker;
import logic.MD5;
import dao.IDAOClient;
import entity.Client;
import manager.Config;
import manager.Message;

/**
 * Created by dennis on 24.05.2015.
 */
public class RegisterCommand extends Command {

    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Client client = new Client();
        String page = null;

        client.setfName(request.getParameter("fname"));
        client.setlName(request.getParameter("lname"));
        client.setPassword(MD5.getHash(request.getParameter("newpasswd"))); //convert password to MD5-sum
        if(!LoginChecker.check(request.getParameter("newemail"))) {
            request.setAttribute("error", Message.getInstance().getProperty(Message.EMAIL_ERROR));
            return Config.getInstance().getProperty(Config.ERROR);
        }
        client.setPhone(request.getParameter("phone"));
        client.setEmail(request.getParameter("newemail"));


        Command.setDAOFactory(DAOFactory.getDaoFactory(DAOFactory.Factories.MYSQL));
        IDAOClient idaoClient = daoFactory.getClientDAO();
        int dbClient = idaoClient.create(client);
        int result = dbClient;
        System.out.println(dbClient);
        page = Config.getInstance().getProperty(Config.LOGIN);
        System.out.println(page);

        if (result == -1) {
            request.setAttribute("clientNotCreated", true);
        }
        return page;
    }
}
