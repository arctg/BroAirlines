package tags;

import dao.DAOFactory;
import dao.IDAOClient;
import entity.Client;

import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Created by dennis on 03.06.2015.
 */
public class AdminPanelButton extends TagSupport {
    private boolean admin;
    private boolean isAdmin;
    Client client = null;
//    static DAOFactory daoFactory;
//
//    public static void setDAOFactory(DAOFactory factory) {
//        daoFactory = factory;
//    }

    public void setAdmin(boolean admin) {

//        setDAOFactory(DAOFactory.getDaoFactory(DAOFactory.Factories.MYSQL));
//        IDAOClient idaoClient = daoFactory.getClientDAO();
//        client = idaoClient.findByEmail(email);
//        isAdmin = client.isAdmin();

        this.admin = admin;
    }

    public int doStartTag() {
        try {
            if (admin){
                pageContext.getOut().write("        <div id=\"line\">\n" +
                        "            <form name=\"registerForm\" method=\"POST\" action=\"Controller\" id=\"form\">\n" +
                        "                <input type=\"hidden\" name=\"command\" value=\"gotoadminpanel\" s/>\n" +
                        "                <input name=\"submit\" type=\"submit\" value=\"Admin panel\" id=\"link\"/>\n" +
                        "            </form>\n" +
                        "        </div>");
            }else pageContext.getOut().write("");

        } catch (IOException e) {
            System.out.println(e);
        }
        return SKIP_BODY;
    }


}
