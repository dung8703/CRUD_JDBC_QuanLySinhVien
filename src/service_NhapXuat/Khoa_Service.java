/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service_NhapXuat;

import java.util.Scanner;
import model.Khoa;

/**
 *
 * @author PC ACER
 */
public class Khoa_Service {
    private static Scanner sc = new Scanner(System.in);
    
    public void inp(Khoa khoa){
        System.out.println("Nhap ma khoa : ");
        khoa.setMaKhoa(sc.nextLine());
        System.out.println("Nhap ten khoa : ");
        khoa.setTenKhoa(sc.nextLine());
    }
    public void info(Khoa khoa){
        System.out.println("MaKhoa: " + khoa.getMaKhoa() + 
                        " /TenKhoa: " + khoa.getTenKhoa());
    }
    
}
