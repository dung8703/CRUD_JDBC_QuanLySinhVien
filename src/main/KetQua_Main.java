/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import dao_DieuKhienDaTa.KetQuaDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.KetQua;
import service_NhapXuat.KetQua_Service;

/**
 *
 * @author PC ACER
 */
public class KetQua_Main {
    public static Scanner sc = new Scanner(System.in);
    
    public static void addKetQua(){
        KetQua kq = new KetQua();
        KetQuaDao kqDao = new KetQuaDao();
        KetQua_Service kq_Service = new KetQua_Service();
        kq_Service.inp(kq);
        try{
            kqDao.add(kq);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public static void deleteKetQua(){
        System.out.println("Please input MaSV va MaMH to delete Ket qua: ");
        KetQuaDao kqDao = new KetQuaDao();
        try{
            kqDao.delete(sc.nextLine(),sc.nextLine());
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public static void updateKetQua(){
        KetQua kq = new KetQua();
        KetQuaDao kqDao = new KetQuaDao();
        KetQua_Service kq_Service = new KetQua_Service();
        kq_Service.inp(kq);
        try{
            kqDao.update(kq);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public static void findAllKetQua(){
        List<KetQua> list = new ArrayList();
        KetQuaDao kqDao = new KetQuaDao();
        KetQua_Service kq_Service = new KetQua_Service();
        try{
            list = kqDao.findAll();
            for( KetQua kq : list){
                kq_Service.info(kq);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void findKetQua(){
        
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
                                addKetQua();
                                break;
                        }
                        case 2: {
                                deleteKetQua();
                                break;
                        }
                        case 3: {
                                updateKetQua();
                                break;
                        }
                        case 4: {
                                findAllKetQua();
                                break;
                        }
                        case 5: {
                                findKetQua();
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
