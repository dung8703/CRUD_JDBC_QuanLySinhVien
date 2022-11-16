/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service_NhapXuat;

import java.util.Scanner;
import model.MonHoc;

/**
 *
 * @author PC ACER
 */
public class MonHoc_Service {
    private Scanner sc = new Scanner(System.in);
    
    public void inp(MonHoc monHoc){
        System.out.println("Nhap ma mon hoc : ");
        monHoc.setMaMH(sc.nextLine());
        System.out.println("Nhap ten mon hoc : ");
        monHoc.setTenMH(sc.nextLine());
        System.out.println("Nhap so tiet hoc : ");
        monHoc.setSoTiet(sc.nextInt());
    }
    
    public void info(MonHoc monHoc) {
        System.out.println("MaMH: "+monHoc.getMaMH() + 
                        " /TenMH: " +monHoc.getTenMH()+ 
                        " /SoTiet: " +monHoc.getSoTiet());
	}
}
