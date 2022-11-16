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
import model.Khoa;
import model.Lop;

/**
 *
 * @author PC ACER
 */
public class LopDao {
    public void add(Lop lop) throws SQLException{
        String sql = "INSERT INTO lop VALUES(?,?,?)";
        PreparedStatement ps = JDBC_Connect.getCon().prepareStatement(sql);
        ps.setString(1, lop.getMaLop());
        ps.setString(2, lop.getTenLop());
        ps.setString(3, lop.getKhoa().getMaKhoa());
        ps.execute();
    }
    
    public void delete(String maLop) throws SQLException{
        String sql = "DELETE FROM lop WHERE maLop = ?";
        PreparedStatement ps = JDBC_Connect.getCon().prepareStatement(sql);
        ps.setString(1, maLop);
        ps.execute();
    }
    
    public void update(Lop lop) throws SQLException{
        String sql = "UPDATE lop SET tenLop = ?, maKhoa = ? WHERE maLop = ?";
        PreparedStatement ps = JDBC_Connect.getCon().prepareStatement(sql);
        ps.setString(1, lop.getMaLop());
        ps.setString(2, lop.getTenLop());
        ps.setString(3, lop.getKhoa().getMaKhoa());
        ps.execute();
    }
    //Tra ve thong tin cua cac lop
    public List<Lop> findAll() throws SQLException{
        List<Lop> list = new ArrayList(); 
        String sql = "SELECT * FROM lop INNER JOIN khoa ON lop.MaKhoa = khoa.MaKhoa";
        PreparedStatement ps = JDBC_Connect.getCon().prepareStatement(sql);
        ResultSet res = ps.executeQuery();
        while(res.next()){
            Khoa khoa = new Khoa();
            khoa.setTenKhoa(res.getString("tenKhoa"));
            khoa.setMaKhoa(res.getString("maKhoa"));
            
            Lop lop = new Lop();
            lop.setMaLop(res.getString("maLop"));
            lop.setTenLop(res.getString("tenLop"));    
            lop.setKhoa(khoa);
            list.add(lop);
        }
        return list;
    }    
    //Tra ve thong tin cua 1 lop duoc tim kiem theo maLop
    public List<Lop> find(String s) throws SQLException{
        List<Lop> list = new ArrayList(); 
        String sql = "SELECT * FROM lop INNER JOIN khoa ON lop.MaKhoa = khoa.MaKhoa WHERE maLop = ?";
        PreparedStatement ps = JDBC_Connect.getCon().prepareStatement(sql);
        ps.setString(1, s );
        ResultSet res = ps.executeQuery();
        while(res.next()){
            //set Khoa
            Khoa khoa = new Khoa();
            khoa.setTenKhoa(res.getString("tenKhoa"));
            khoa.setMaKhoa(res.getString("maKhoa"));
            //sau đó mới set cho Lop vì trong Lop có thuộc tính Khoa với quan hệ has-A
            Lop lop = new Lop();
            lop.setMaLop(res.getString("maLop"));
            lop.setTenLop(res.getString("tenLop"));    
            lop.setKhoa(khoa);
            //thêm thằng lop vào list
            list.add(lop);
        }
        return list;
    }
}
