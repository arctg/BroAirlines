package tags;

import logic.CurrentDate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * Created by dennis on 07.06.2015.
 */
public class TodayIsTag extends TagSupport {
    private static final Logger log = LogManager.getLogger(TodayIsTag.class);

    public int doStartTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();
            out.write(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(CurrentDate.getCurrentDate()));
        }catch (IOException e){
            log.warn(e);
            throw new JspException(e.getMessage());
        }
        return SKIP_BODY;
    }
}
