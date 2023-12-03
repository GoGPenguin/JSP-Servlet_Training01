package Model.BO;

import Model.BEAN.ClientFinance;
import Model.DAO.ClientDAO;

import java.util.ArrayList;

public class  ClientBO {
    private static ClientBO instance;
    private ClientDAO clientDAO = null;
    private ClientBO() {
        clientDAO = ClientDAO.getInstance();
    }
    public static synchronized ClientBO getInstance() {
        if (instance == null) {
            instance = new ClientBO();
        }
        return instance;
    }

    public ArrayList<ClientFinance> getAllClient() {
        return clientDAO.getAllClient();
    }
}
