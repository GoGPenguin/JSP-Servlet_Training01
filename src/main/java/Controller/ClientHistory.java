package Controller;

import Model.BO.HistoryBO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/manageHistory")
public class ClientHistory extends HttpServlet {
    private HistoryBO historyBO = HistoryBO.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        req.setAttribute("dataHistory", historyBO.getHistoryById(id));
        req.getRequestDispatcher("ViewHistoryClient.jsp").forward(req, resp);
    }
}
