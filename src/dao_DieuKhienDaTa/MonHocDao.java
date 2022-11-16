/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao_DieuKhienDaTa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.MonHoc;

/**
 *
 * @author PC ACER
 */
public class MonHocDao {
    public void add(MonHoc mh) throws SQLException{
        String sql = "INSERT INTO monhoc VALUES (?,?,?)";
        PreparedStatement ps = JDBC_Connect.getCon().prepareStatement(sql);
        ps.setString(1, mh.getMaMH());
        ps.setString(2, mh.getTenMH());
        ps.setInt(3, mh.getSoTiet());
        ps.execute();
    }
    
    public void delete(String maMH) throws SQLException{
        String sql = "DELETE FROM monhoc WHERE maMH = ?";
        PreparedStatement ps = JDBC_Connect.getCon().prepareStatement(sql);
        ps.setString(1, maMH);
        ps.execute();
    }
    
    public void update(MonHoc mh) throws SQLException{
        String sql = "UPDATE monhoc SET tenMH = ?, soTiet = ? WHERE maMH = ?";
        PreparedStatement ps = JDBC_Connect.getCon().prepareStatement(sql);      
        ps.setString(1, mh.getTenMH());
        ps.setInt(2, mh.getSoTiet());
        ps.setString(3, mh.getMaMH());
        ps.execute();
    }
    
    
    public List<MonHoc> findAll() throws SQLException {
            List<MonHoc> list = new ArrayList<>();
            String sql = "SELECT * FROM monhoc";
            PreparedStatement ps = JDBC_Connect.getCon().prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            while(result.next()) {
                    MonHoc p = new MonHoc();
                    p.setMaMH(result.getString("mamh"));
                    p.setTenMH(result.getString("tenmh"));
                    p.setSoTiet(result.getInt("sotiet"));

                    list.add(p);
            }
            return list;
    }

    public List<MonHoc> find(String s) throws SQLException {
            List<MonHoc> list = new ArrayList<>();
            String sql = "SELECT * FROM monhoc WHERE mamh LIKE ?";
            PreparedStatement ps = JDBC_Connect.getCon().prepareStatement(sql);
            ps.setString(1, s );
            ResultSet result = ps.executeQuery();
            while(result.next()) {
                    MonHoc p = new MonHoc();
                    p.setMaMH(result.getString("mamh"));
                    p.setTenMH(result.getString("tenmh"));
                    p.setSoTiet(result.getInt("sotiet"));

                    list.add(p);
            }
            return list;
    }
}
