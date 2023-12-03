package Model.BO;

import Model.BEAN.Vacxin;
import Model.DAO.VacxinDAO;

import java.util.ArrayList;

public class VacxinBO {
    private static VacxinBO instance;
    private Model.DAO.VacxinDAO vacxinDAO = null;
    private VacxinBO() {
        vacxinDAO = VacxinDAO.getInstance();
    }
    public static synchronized VacxinBO getInstance() {
        if (instance == null) {
            instance = new VacxinBO();
        }
        return instance;
    }

    public ArrayList<Vacxin> getAllVacxin() {
        return vacxinDAO.getAllVacxin();
    }
    public ArrayList<Vacxin> getAllVacxin(String condition, String data) {
        return vacxinDAO.getAllVacxin(condition, data);
    }

    public Vacxin getVacxinById(String id) {
        return vacxinDAO.getVacxinById(id);
    }

    public void addVacxin(String id, String name, int somui, String mota, int giatien, String hangsx){
        vacxinDAO.addVacxin(id, name, somui, mota, giatien, hangsx);
    }
    public void editVacxin(String id, String name, int somui, String mota, int giatien, String hangsx){
        vacxinDAO.editVacxin(id, name, somui, mota, giatien, hangsx);
    }

    public String generateId() {
        return vacxinDAO.generateId();
    }

}
