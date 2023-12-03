package Controller;

import Model.BEAN.Vacxin;
import Model.BO.VacxinBO;
import Model.DAO.VacxinDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/manageVacxin")
public class FilterVacxin extends HttpServlet {
    private VacxinBO vacxinBO = VacxinBO.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cond = req.getParameter("option");
        String data = req.getParameter("data");
        if (cond != null) {
            req.setAttribute("listVacxin", vacxinBO.getAllVacxin(cond, data));
        }
        else {
            req.setAttribute("listVacxin", vacxinBO.getAllVacxin());
        }
        RequestDispatcher rd = req.getRequestDispatcher("ViewManageVacxin.jsp");
        rd.forward(req, resp);
    }
}
