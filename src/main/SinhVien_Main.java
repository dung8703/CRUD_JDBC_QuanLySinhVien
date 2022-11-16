/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import dao_DieuKhienDaTa.SinhVienDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.SinhVien;
import service_NhapXuat.SinhVien_Service;

/**
 *
 * @author PC ACER
 */
public class SinhVien_Main {
    public static Scanner sc = new Scanner(System.in);
    
    public static void addSinhVien(){
        SinhVien sv = new SinhVien();
        SinhVienDao svDao = new SinhVienDao();
        SinhVien_Service sv_Service = new SinhVien_Service();
        sv_Service.inp(sv);
        try{
            svDao.add(sv);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public static void deleteSinhVien(){
        SinhVienDao svDao = new SinhVienDao();    
        System.out.println("Nhap vao ma sinh vien de delete sinh vien : ");
        String maSV = sc.nextLine();
        try{
            svDao.delete(maSV);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public static void updateSinhVien(){
        SinhVien sv = new SinhVien();
        SinhVienDao svDao = new SinhVienDao();
        SinhVien_Service sv_Service = new SinhVien_Service();
        sv_Service.inp(sv);
        try{
            svDao.update(sv);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public static void findAllSinhVien(){
        List<SinhVien> list = new ArrayList();
        SinhVienDao sinhVienDao = new SinhVienDao();
        SinhVien_Service lop_Service = new SinhVien_Service();
        try{
            list = sinhVienDao.findAll();
            for(SinhVien sv : list){
                lop_Service.info(sv);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void findSinhVien(){
        System.out.println("Nhap vao ma sinh vien de find sinh vien : ");
        String maSV = sc.nextLine();
        List<SinhVien> list = new ArrayList();
        SinhVienDao sinhVienDao = new SinhVienDao();
        SinhVien_Service lop_Service = new SinhVien_Service();
        try{
            list = sinhVienDao.find(maSV);
            for(SinhVien sv : list){
                lop_Service.info(sv);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        boolean check = true;
        while(check) {
            System.out.println("__MENU__");
            System.out.println("0. Exit");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Update");
            System.out.println("4. FindAll");
            System.out.println("5. Find");
            System.out.println("Please select!");
            try {
                int c = new Scanner(System.in).nextInt();
                switch (c) {
                        case 0: {
                                check = false;
                                break;
                        }
                        case 1: {
                                addSinhVien();
                                break;
                        }
                        case 2: {
                                deleteSinhVien();
                                break;
                        }
                        case 3: {
                                updateSinhVien();
                                break;
                        }
                        case 4: {
                                findAllSinhVien();
                                break;
                        }
                        case 5: {
                                findSinhVien();
                                break;
                        }
                        default:
                                System.out.println("Please select correct number !!!");
                    }
            } 
            catch (Exception e) {
                    System.out.println("Please select number !!!");
            }
        }
    }
}
