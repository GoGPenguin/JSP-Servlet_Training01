package Model.DAO;

import DB.ConnectDB;
import Model.BEAN.History;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HistoryDAO {
    private Connection cnn;
    private static HistoryDAO instance;
    private HistoryDAO(Connection cnn) {
        this.cnn = cnn;
    }

    public static synchronized HistoryDAO getInstance() {
        if (instance == null) {
            instance = new HistoryDAO(ConnectDB.getCnn());
        }
        return instance;
    }

    public ArrayList<History> getHistoryById(String id) {
        ArrayList<History> histories = new ArrayList<>();
        String sql = "SELECT\n" +
                "    khachhang.MaKH,\n" +
                "    khachhang.HoTenKH,\n" +
                "    vacxin.MaVacxin,\n" +
                "    vacxin.TenVacxin,\n" +
                "    vacxin.SoMui - lichsutiemphong.STTMui AS SoMuiCanTiem,\n" +
                "    GROUP_CONCAT(DISTINCT benh.TenBenh SEPARATOR ', ') AS DanhSachBenh\n" +
                "FROM\n" +
                "    khachhang\n" +
                "JOIN\n" +
                "    lichsutiemphong ON khachhang.MaKH = lichsutiemphong.MaKH\n" +
                "JOIN\n" +
                "    vacxin ON vacxin.MaVacxin = lichsutiemphong.MaVacxin\n" +
                "JOIN\n" +
                "    phongbenh ON vacxin.MaVacxin = phongbenh.MaVacxin\n" +
                "JOIN\n" +
                "    benh ON phongbenh.MaBenh = benh.MaBenh\n" +
                "WHERE\n" +
                "    khachhang.MaKH = ?\n" +
                "GROUP BY\n" +
                "    khachhang.MaKH, khachhang.HoTenKH, vacxin.MaVacxin, vacxin.TenVacxin, vacxin.SoMui, lichsutiemphong.STTMui;\n";
        try {
            PreparedStatement pre = this.cnn.prepareStatement(sql);
            pre.setString(1, id);
            ResultSet rs = pre.executeQuery();

            while(rs.next()) {
                History history = new History();
                history.setIdClient(rs.getString("MaKH"));
                history.setIdVacxin(rs.getString("MaVacxin"));
                history.setNameClient(rs.getString("HoTenKH"));
                history.setNameDisease(rs.getString("DanhSachBenh"));
                history.setNameVacxin(rs.getString("TenVacxin"));
                history.setSummaryDose(rs.getInt("SoMuiCanTiem"));

                histories.add(history);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return histories;
    }
}
