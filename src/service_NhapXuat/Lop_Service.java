/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service_NhapXuat;

import java.util.Scanner;
import model.Khoa;
import model.Lop;

/**
 *
 * @author PC ACER
 */
public class Lop_Service {
    private static Scanner sc = new Scanner(System.in);
    
    public void inp(Lop lop){
        System.out.println("Nhap ma lop : ");
        lop.setMaLop(sc.nextLine());
        System.out.println("Nhap ten lop : ");
        lop.setTenLop(sc.nextLine());
        
        //nhap Khoa
        Khoa khoa = new Khoa();
        System.out.println("Nhap ma_khoa: ");
        khoa.setMaKhoa(sc.nextLine());
        System.out.println("Nhap ten_khoa: ");
        khoa.setTenKhoa(sc.nextLine());
        lop.setKhoa(khoa);
    }
    
    public void info(Lop lop) {
        System.out.println("Ma_Lop: "+lop.getMaLop() + 
                        " /Ten_Lop: " +lop.getTenLop()+ 
                        " /Ma_khoa: " +lop.getKhoa().getMaKhoa()+
                           " /Ten_khoa: " +lop.getKhoa().getTenKhoa());
	}
}
