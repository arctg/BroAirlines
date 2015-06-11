package tags;

import logic.CurrentDate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Created by dennis on 09.06.2015.
 */
public class VersionTag extends TagSupport {
    private static final Logger log = LogManager.getLogger(VendorNameTag.class);
    public int doStartTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();
            out.write("<color=\"A0A0A0\">ver.004</color>");
        }catch (IOException e){
            log.warn(e);
            throw new JspException(e.getMessage());
        }
        return SKIP_BODY;
    }
}
