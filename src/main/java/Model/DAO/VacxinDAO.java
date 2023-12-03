package Model.DAO;

import DB.ConnectDB;
import Model.BEAN.Vacxin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VacxinDAO {
    private Connection cnn;
    private static VacxinDAO instance;
    private VacxinDAO(Connection cnn) {
        this.cnn = cnn;
    }

    public static synchronized VacxinDAO getInstance() {
        if (instance == null) {
            instance = new VacxinDAO(ConnectDB.getCnn());
        }
        return instance;
    }

    public ArrayList<Vacxin> getAllVacxin() {
        ArrayList<Vacxin> vacxins = new ArrayList<>();
        String sql = "Select * FROM vacxin";
        try {
            PreparedStatement pre = this.cnn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();

            while (rs.next()) {
                Vacxin vacxin = new Vacxin();
                vacxin.setIdVacxin(rs.getString("MaVacxin"));
                vacxin.setNameVacxin(rs.getString("TenVacxin"));
                vacxin.setSoMui(rs.getInt("SoMui"));
                vacxin.setMoTa(rs.getString("MoTa"));
                vacxin.setGiaVacxin(rs.getInt("GiaVacXin"));
                vacxin.setTenHangSX(rs.getString("TenHangSX"));

                vacxins.add(vacxin);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(vacxins);
        return vacxins;
    }
    public ArrayList<Vacxin> getAllVacxin(String condition, String data) {
        ArrayList<Vacxin> vacxins = new ArrayList<>();
        String sql = "Select * FROM vacxin WHERE " + condition + " LIKE ?";
        try {
            PreparedStatement pre = this.cnn.prepareStatement(sql);
            pre.setString(1, "%" + data + "%");
            ResultSet rs = pre.executeQuery();

            while (rs.next()) {
                Vacxin vacxin = new Vacxin();
                vacxin.setIdVacxin(rs.getString("MaVacxin"));
                vacxin.setNameVacxin(rs.getString("TenVacxin"));
                vacxin.setSoMui(rs.getInt("SoMui"));
                vacxin.setMoTa(rs.getString("MoTa"));
                vacxin.setGiaVacxin(rs.getInt("GiaVacXin"));
                vacxin.setTenHangSX(rs.getString("TenHangSX"));

                vacxins.add(vacxin);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vacxins;
    }
    public Vacxin getVacxinById(String id) {
        Vacxin vacxin = new Vacxin();
        String sql = "SELECT * FROM vacxin WHERE MaVacxin = ?";

        try {
            PreparedStatement pre = this.cnn.prepareStatement(sql);
            pre.setString(1, id);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                vacxin.setIdVacxin(rs.getString("MaVacxin"));
                vacxin.setNameVacxin(rs.getString("TenVacxin"));
                vacxin.setSoMui(rs.getInt("SoMui"));
                vacxin.setMoTa(rs.getString("MoTa"));
                vacxin.setGiaVacxin(rs.getInt("GiaVacXin"));
                vacxin.setTenHangSX(rs.getString("TenHangSX"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return (vacxin.getIdVacxin() == null) ? null:vacxin;
    }

    public void addVacxin(String id, String name, int somui, String mota, int giatien, String tenhang) {
        String sql = "INSERT INTO vacxin (MaVacxin, TenVacxin, SoMui, MoTa, GiaVacxin, TenHangSX) VALUES (?, ?, ?, ?, ?, ?)";
        if (getVacxinById(id) != null) {
            System.out.println("Add");
            id = generateId();
        }

        try (PreparedStatement preparedStatement = cnn.prepareStatement(sql)) {
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, somui);
            preparedStatement.setString(4, mota);
            preparedStatement.setInt(5, giatien);
            preparedStatement.setString(6, tenhang);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void editVacxin(String id, String name, int somui, String mota, int giatien, String tenhang) {
        String sql = "UPDATE vacxin SET TenVacxin = ?, SoMui = ?, MoTa = ?, GiaVacxin = ?, TenHangSX = ? WHERE MaVacxin = ?";

        try (PreparedStatement preparedStatement = cnn.prepareStatement(sql)) {
            preparedStatement.setString(6, id);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, somui);
            preparedStatement.setString(3, mota);
            preparedStatement.setInt(4, giatien);
            preparedStatement.setString(5, tenhang);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Utilities
    public String generateId() {
        String sql = "SELECT CAST(SUBSTRING(MaVacxin, 2) AS UNSIGNED) AS xyz FROM vacxin ORDER BY MaVacxin DESC LIMIT 1";
        PreparedStatement pre = null;
        String idSuffix = "";
        try {
            pre = this.cnn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1) + 1;
                idSuffix = (count > 9) ? "VX" + count : "VX0" + count;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(idSuffix);
        return idSuffix;
    }
}
