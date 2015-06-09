package servlet;

import commands.Command;
import manager.Message;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;

/**
 * Created by dennis on 24.05.2015.
 */
//@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {
    private static final Logger log = LogManager.getLogger(Controller.class);

    ControllerHelper controllerHelper = ControllerHelper.getInstance();

    public Controller(){
        super();
    }

    protected  void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page  = null;
        System.out.println("from Controller");


        try{
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");

            //request.setAttribute("locale",request.getLocale());
        }catch (UnsupportedEncodingException e){
            System.out.println(e);
            log.warn(e);
        }

        try {
            Command command = controllerHelper.getCommand(request);

            page = command.execute(request,response);
            System.out.println(page);
        } catch (ServletException e){
            e.printStackTrace();
            request.setAttribute("error", Message.getInstance().getProperty(Message.SERVLET_EXCEPTION));
            log.warn(e);
        }
         catch (IOException e) {
             e.printStackTrace();
             request.setAttribute("error", Message.getInstance().getProperty(Message.IO_EXCEPTION));
             log.warn(e);
         }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
