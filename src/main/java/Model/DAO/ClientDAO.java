package Model.DAO;

import DB.ConnectDB;
import Model.BEAN.ClientFinance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientDAO {
    private Connection cnn;
    private static ClientDAO instance;
    private ClientDAO(Connection cnn) {
        this.cnn = cnn;
    }

    public static synchronized ClientDAO getInstance() {
        if (instance == null) {
            instance = new ClientDAO(ConnectDB.getCnn());
        }
        return instance;
    }

    public ArrayList<ClientFinance> getAllClient() {
        ArrayList<ClientFinance> clients = new ArrayList<>();
        String sql = "SELECT\n" +
                "    khachhang.MaKH,\n" +
                "    khachhang.HoTenKH,\n" +
                "    khachhang.DiaChiKH,\n" +
                "    SUM(vacxin.GiaVacxin) AS TongGiaTien\n" +
                "FROM\n" +
                "    khachhang\n" +
                "JOIN\n" +
                "    lichsutiemphong ON khachhang.MaKH = lichsutiemphong.MaKH\n" +
                "JOIN\n" +
                "    vacxin ON lichsutiemphong.MaVacxin = vacxin.MaVacxin\n" +
                "GROUP BY\n" +
                "    khachhang.MaKH, khachhang.HoTenKH, khachhang.DiaChiKH\n" +
                "ORDER BY\n" +
                "    TongGiaTien ASC;";

        try {
            PreparedStatement pre = this.cnn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while(rs.next()) {
                ClientFinance client = new ClientFinance();
                client.setIdClient(rs.getString("MaKH"));
                client.setNameClient(rs.getString("HoTenKH"));
                client.setAddressClient(rs.getString("DiaChiKH"));
                client.setSummaryMoney(rs.getInt("TongGiaTien"));
                clients.add(client);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clients;
    }
}
