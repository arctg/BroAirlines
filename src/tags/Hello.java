package tags;

import dao.DAOFactory;
import dao.IDAOClient;
import entity.Client;


import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Created by dennis on 03.06.2015.
 */
public class Hello extends TagSupport {
    private String email;
    private boolean isAdmin;
    Client client = null;
    static DAOFactory daoFactory;

    public static void setDAOFactory(DAOFactory factory) {
        daoFactory = factory;
    }

    public void setEmail(String email) {

        setDAOFactory(DAOFactory.getDaoFactory(DAOFactory.Factories.MYSQL));
        IDAOClient idaoClient = daoFactory.getClientDAO();
        client = idaoClient.findByEmail(email);
        isAdmin = client.isAdmin();

        this.email = client.getEmail();
        System.out.println(client.getEmail());
    }

    public int doStartTag() {
        try {
            if (isAdmin){
            pageContext.getOut().write("<font color=\"#FF0000\"><b>" + email + "</b></font>");
            }else pageContext.getOut().write("<b>" + email + "</b>");

        } catch (IOException e) {
            System.out.println(e);
        }
        return SKIP_BODY;
    }

}
