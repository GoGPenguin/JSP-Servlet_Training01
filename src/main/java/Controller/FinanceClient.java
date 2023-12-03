package Controller;

import Model.BO.ClientBO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/manageClient")
public class FinanceClient extends HttpServlet {
    private ClientBO clientBO = ClientBO.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("dataClients", clientBO.getAllClient());
        req.getRequestDispatcher("ViewClient.jsp").forward(req, resp);
    }
}
