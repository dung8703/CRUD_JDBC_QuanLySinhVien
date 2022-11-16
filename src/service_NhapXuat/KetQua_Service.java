/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service_NhapXuat;

import java.util.Scanner;
import model.KetQua;
import model.MonHoc;
import model.SinhVien;

/**
 *
 * @author PC ACER
 */
public class KetQua_Service {
    
    public void inp(KetQua kq){
        SinhVien sv = new SinhVien();
        System.out.println("Nhap ma sinh vien: ");
        sv.setMaSV(new Scanner(System.in).nextLine());
        kq.setSinhVien(sv);

        MonHoc mh = new MonHoc();
        System.out.println("Nhap ma mon hoc: ");
        mh.setMaMH(new Scanner(System.in).nextLine());
        kq.setMonHoc(mh);

        System.out.println("Nhap diem Thi: ");
        kq.setDiemThi(new Scanner(System.in).nextFloat());
    }
    
    public void info(KetQua kq) {
		System.out.println("MaSV: " +kq.getSinhVien().getMaSV() + 
				" /MaMH: " +kq.getMonHoc().getMaMH()+ 
				" /DiemThi: " +kq.getDiemThi());
    }
}
