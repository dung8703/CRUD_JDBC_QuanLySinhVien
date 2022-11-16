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
import model.Lop;
import model.SinhVien;

/**
 *
 * @author PC ACER
 */
public class SinhVienDao {
    
    public void add(SinhVien sv) throws SQLException{
        String sql = "INSERT INTO sinhvien VALUES (?,?,?,?,?,?)";
        PreparedStatement ps = JDBC_Connect.getCon().prepareStatement(sql);
        ps.setString(1, sv.getMaSV());
        ps.setString(2, sv.getHoTen());
        ps.setString(3, sv.getGioiTinh());
        ps.setString(4, sv.getNgaySinh());
        ps.setString(5, sv.getLop().getMaLop());
        ps.setString(6, sv.getHocBong());
        ps.executeUpdate();
    }
    
    public void delete(String maSV) throws SQLException {
        String sql = "DELETE FROM sinhvien WHERE maSV = ?";
        PreparedStatement ps = JDBC_Connect.getCon().prepareStatement(sql);
        ps.setString(1, maSV);
        ps.executeUpdate();	
	}
	
	public void update(SinhVien sv) throws SQLException {
		String sql = "UPDATE sinhvien SET hoten = ?, gioitinh = ?, ngaysinh = ?, malop = ?, hocbong = ? WHERE maSV = ?";
		PreparedStatement ps = JDBC_Connect.getCon().prepareStatement(sql);
		ps.setString(1, sv.getHoTen());
		ps.setString(2, sv.getGioiTinh());
		ps.setString(3, sv.getNgaySinh());
		ps.setString(4, sv.getLop().getMaLop());
		ps.setString(5, sv.getHocBong());
		ps.setString(6, sv.getMaSV());
		
		ps.executeUpdate();	
	}
	
	public List<SinhVien> findAll() throws SQLException {
		List<SinhVien> list = new ArrayList<>();
		String sql = "SELECT sinhvien.* , lop.tenlop FROM sinhvien INNER JOIN lop ON sinhvien.MaLop = lop.MaLop";
		PreparedStatement ps = JDBC_Connect.getCon().prepareStatement(sql);
		ResultSet res = ps.executeQuery();
		while(res.next()) {
                    SinhVien sv = new SinhVien();
                    sv.setMaSV(res.getString("masv"));
                    sv.setHoTen(res.getString("hoten"));
                    sv.setGioiTinh(res.getString("gioitinh"));
                    sv.setNgaySinh(res.getString("ngaysinh"));
                    sv.setHocBong(res.getString("hocbong"));

                    Lop lop = new Lop();
                    lop.setMaLop(res.getString("malop"));
                    lop.setTenLop(res.getString("tenlop"));
                    sv.setLop(lop);
                    list.add(sv);
		}
		return list;
	}
	
	public List<SinhVien> find(String s) throws SQLException {
		List<SinhVien> list = new ArrayList<>();
		String sql = "SELECT sinhvien.* , lop.tenlop FROM sinhvien INNER JOIN lop ON sinhvien.MaLop = lop.MaLop WHERE maSV = ?";
		PreparedStatement ps = JDBC_Connect.getCon().prepareStatement(sql);
		ps.setString(1, s);
		ResultSet res = ps.executeQuery();
		while(res.next()) {
                    //set cho Lop
                    Lop lop = new Lop();
                    lop.setMaLop(res.getString("malop"));
                    lop.setTenLop(res.getString("tenlop"));
                    //sau đó set cho SinhVien vì trong SinhVien có thuộc tính maLop của Lop, quan hệ has-A
                    SinhVien sv = new SinhVien();
                    sv.setMaSV(res.getString("masv"));
                    sv.setHoTen(res.getString("hoten"));
                    sv.setGioiTinh(res.getString("gioitinh"));
                    sv.setNgaySinh(res.getString("ngaysinh"));
                    sv.setHocBong(res.getString("hocbong"));
                    sv.setLop(lop);

                    list.add(sv);
		}
		return list;
	}
}
