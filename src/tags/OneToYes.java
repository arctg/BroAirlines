package tags;

import dao.DAOFactory;
import dao.IDAOCity;
import dao.IDAOFlight;
import entity.City;
import entity.Flight;

import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Created by dennis on 07.06.2015.
 */
public class OneToYes extends TagSupport {
    private String one;

    public void setOne(String one) {
        this.one = one;
    }

    public int doStartTag() {
        try {
            if (one.equals("true")) pageContext.getOut().write("yes");
            if (one.equals("false")) pageContext.getOut().write("no");

        } catch (IOException e) {
            System.out.println(e);
        }
        return SKIP_BODY;
    }
}
