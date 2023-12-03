package Model.BO;

import Model.BEAN.History;
import Model.DAO.HistoryDAO;

import java.util.ArrayList;

public class HistoryBO {
    private static HistoryBO instance;
    private Model.DAO.HistoryDAO HistoryDAO = null;
    private HistoryBO() {
        HistoryDAO = HistoryDAO.getInstance();
    }
    public static synchronized HistoryBO getInstance() {
        if (instance == null) {
            instance = new HistoryBO();
        }
        return instance;
    }

    public ArrayList<History> getHistoryById(String id) {
        return HistoryDAO.getHistoryById(id);
    }

}
