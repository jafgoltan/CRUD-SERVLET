package controller;

import model.entity.Person;
import model.service.PersonServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/person/save.do")
public class Save extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PersonServiceImpl.getInstance().save(new Person()
                    .setName(req.getParameter("name"))
                    .setFamily(req.getParameter("family")));
            resp.sendRedirect("/person/findAll.do");
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(701);
        }
    }
}
