package Controller;

import Model.BEAN.Vacxin;
import Model.BO.VacxinBO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/addOrUpdate")
public class AddOrUpdate extends HttpServlet {
    private VacxinBO vacxinBO = VacxinBO.getInstance();
    private Vacxin emptyVacxin = new Vacxin("-1");
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        req.setAttribute("data", emptyVacxin);
        if (!id.equals("-1")) req.setAttribute("data", vacxinBO.getVacxinById(id));
        req.getRequestDispatcher("ViewAddOrUpdateVacxin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("MaVacxin");
        String name = req.getParameter("TenVacxin");
        int somui = Integer.parseInt(req.getParameter("SoMui"));
        String mota = req.getParameter("MoTa");
        int giatien = Integer.parseInt(req.getParameter("GiaVacxin"));
        String hangsx = req.getParameter("TenHangSX");
        if(vacxinBO.getVacxinById(id) == null) {
            vacxinBO.addVacxin(id, name, somui, mota, giatien, hangsx);
        }
        else vacxinBO.editVacxin(id, name, somui, mota, giatien, hangsx);
        req.setAttribute("listVacxin", vacxinBO.getAllVacxin());
        req.getRequestDispatcher("ViewManageVacxin.jsp").forward(req, resp);
    }
}
