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
import model.KetQua;
import model.MonHoc;
import model.SinhVien;

/**
 *
 * @author PC ACER
 */
public class KetQuaDao {
    
    public void add(KetQua kq) throws SQLException{
        String sql = "INSERT INTO ketqua VALUES (?, ?, ?)";
        PreparedStatement ps = JDBC_Connect.getCon().prepareStatement(sql);
        ps.setString(1, kq.getSinhVien().getMaSV());
        ps.setString(2, kq.getMonHoc().getMaMH());
        ps.setFloat(3, kq.getDiemThi());
        ps.execute();
    }
    
    public void delete(String maSV,String maMH) throws SQLException{
        String sql = "DELETE FROM ketqua WHERE maSV = ? AND maMH = ?";
        PreparedStatement ps = JDBC_Connect.getCon().prepareStatement(sql);
        ps.setString(1, maSV);
        ps.setString(2, maMH);
        ps.execute();
    }

    public void update(KetQua kq) throws SQLException{
        String sql = "UPDATE ketqua SET maMH = ?, diemThi = ? WHERE maSV = ?";
        PreparedStatement ps = JDBC_Connect.getCon().prepareStatement(sql);     
        ps.setString(1, kq.getMonHoc().getMaMH());
        ps.setFloat(2, kq.getDiemThi());
        ps.setString(3, kq.getSinhVien().getMaSV());
        ps.execute();
    }
    
    public List<KetQua> findAll() throws SQLException{
        String sql = "SELECT sinhvien.maSV, sinhvien.hoTen, monhoc.maMH, monhoc.tenMH, diemThi FROM ketqua INNER JOIN monhoc ON ketqua.maMH = monhoc.maMH INNER JOIN sinhvien ON sinhvien.maSV = ketqua.maSV";
        List<KetQua> list = new ArrayList();
        PreparedStatement ps = JDBC_Connect.getCon().prepareStatement(sql);
        ResultSet res = ps.executeQuery();
        while(res.next()){
            //set cho Sinh Vien
            SinhVien sv = new SinhVien();
            sv.setMaSV(res.getString("maSV"));
            sv.setMaSV(res.getString("hoTen"));
            //set cho Mon Hoc
            MonHoc mh = new MonHoc();
            mh.setMaMH(res.getString("maMH"));
            mh.setTenMH("tenMH");
            //sau đó mới set cho KetQua vì trong Ket Qua có thuộc tính SinhVien và Monhoc với quan hệ là has-A
            KetQua kq = new KetQua();
            kq.setSinhVien(sv);
            kq.setMonHoc(mh);
            kq.setDiemThi(res.getFloat("diemThi"));
            //thêm Ket Qua vào list
            list.add(kq);
        }
        return list;
    }
    
    public List<KetQua> find(String s) throws SQLException{
        String sql = "SELECT sinhvien.maSV, sinhvien.hoTen, monhoc.maMH, monhoc.tenMH, diemThi FROM ketqua INNER JOIN monhoc ON ketqua.maMH = monhoc.maMH INNER JOIN sinhvien ON sinhvien.maSV = ketqua.maSV WHERE maSV = ?";
        List<KetQua> list = new ArrayList();
        PreparedStatement ps = JDBC_Connect.getCon().prepareStatement(sql);
        ps.setString(1, s);
        ResultSet res = ps.executeQuery();
        while(res.next()){
            
            SinhVien sv = new SinhVien();
            sv.setMaSV(res.getString("maSV"));
            sv.setMaSV(res.getString("hoTen"));
            
            MonHoc mh = new MonHoc();
            mh.setMaMH(res.getString("maMH"));
            mh.setTenMH("tenMH");
            
            KetQua kq = new KetQua();
            kq.setSinhVien(sv);
            kq.setMonHoc(mh);
            kq.setDiemThi(res.getFloat("diemThi"));
            
            list.add(kq);
        }
        return list;
    }
}
