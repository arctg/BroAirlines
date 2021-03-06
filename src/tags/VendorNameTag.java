package tags;

/**
 * Created by dennis on 03.06.2015.
 */

import dao.DAOFactory;
import dao.IDAOAirplane;
import entity.Airplane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class VendorNameTag extends TagSupport {
    private static final Logger log = LogManager.getLogger(VendorNameTag.class);
    private String vendorName;
    Airplane airplane = null;
    static DAOFactory daoFactory;

    public static void setDAOFactory(DAOFactory factory) {
        daoFactory = factory;
    }

    public void setVendorName(String id) {

        setDAOFactory(DAOFactory.getDaoFactory(DAOFactory.Factories.MYSQL));
        IDAOAirplane idaoAirplane = daoFactory.getAirplaneDAO();
        airplane = idaoAirplane.findAirplaneById(Integer.parseInt(id));

        this.vendorName = airplane.getVendorName();
    }

    public int doStartTag() {
        try {
            pageContext.getOut().write(vendorName);
        } catch (IOException e) {
            System.out.println(e);
            log.warn(e);
        }
        return SKIP_BODY;
    }
}
