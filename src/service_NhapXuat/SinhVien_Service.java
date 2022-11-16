/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service_NhapXuat;

import java.util.Scanner;
import model.Khoa;
import model.Lop;
import model.SinhVien;

/**
 *
 * @author PC ACER
 */
public class SinhVien_Service {
    private static Scanner sc = new Scanner(System.in);
    
    public void inp(SinhVien sv){
        System.out.println("Nhap maSV: ");
        sv.setMaSV(sc.nextLine());
        System.out.println("Nhap hoTen: ");
        sv.setHoTen(sc.nextLine());
        System.out.println("Nhap gioiTinh: ");
        sv.setGioiTinh(sc.nextLine());
        System.out.println("Nhap ngaySinh: ");
        sv.setNgaySinh(sc.nextLine());

        //nhap maLop
        Lop lop = new Lop();
        System.out.println("Nhap ma_lop: ");
        lop.setMaLop(sc.nextLine());
        System.out.println("Nhap tenLop: ");
        lop.setTenLop(sc.nextLine());
        sv.setLop(lop);

        System.out.println("Nhap hocBong: ");
        sv.setHocBong(sc.nextLine());
    }
    public void info(SinhVien sv) {
        System.out.println("MaSV: "+sv.getMaSV() + 
                        " /HoTen: " +sv.getHoTen()+ 
                        " /GioiTinh: " +sv.getGioiTinh()+
                        " /NgaySinh: " +sv.getNgaySinh()+
                        " /MaLop: " +sv.getLop().getMaLop()+
                        " /HocBong: " +sv.getHocBong());
    }
}
