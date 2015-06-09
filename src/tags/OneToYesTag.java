package tags;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Created by dennis on 07.06.2015.
 */
public class OneToYesTag extends TagSupport {
    private static final Logger log = LogManager.getLogger(OneToYesTag.class);
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
            log.warn(e);
        }
        return SKIP_BODY;
    }
}
