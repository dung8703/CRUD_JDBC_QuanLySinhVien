/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import dao_DieuKhienDaTa.LopDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Lop;
import service_NhapXuat.Lop_Service;

/**
 *
 * @author PC ACER
 */
public class Lop_Main {
    public static Scanner sc = new Scanner(System.in);
    
    public static void addLop(){
        Lop lop = new Lop();
        LopDao lopDao = new LopDao();
        Lop_Service lop_Service = new Lop_Service();
        lop_Service.inp(lop);
        try{
            lopDao.add(lop);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public static void deleteLop(){
        System.out.println("Please input MaLop to delete Lop: ");
        String maLop = sc.nextLine();
        LopDao lopDao = new LopDao();
        try{
            lopDao.delete(maLop);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public static void updateLop(){
        Lop lop = new Lop();
        LopDao lopDao = new LopDao();
        Lop_Service lop_Service = new Lop_Service();
        lop_Service.inp(lop);
        try{
            lopDao.update(lop);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public static void findAllLop(){
        List<Lop> list = new ArrayList();
        LopDao lopDao = new LopDao();
        Lop_Service lop_Service = new Lop_Service();
        try{
            list = lopDao.findAll();
            for(Lop lop : list){
                lop_Service.info(lop);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public static void findLop(){
        System.out.println("Please input MaLop to find Lop: ");
        String maLop = sc.nextLine();
        List<Lop> list = new ArrayList();
        LopDao lopDao = new LopDao();
        Lop_Service lop_Service = new Lop_Service();
        try{
            list = lopDao.find(maLop);
            for(Lop lop : list){
                lop_Service.info(lop);
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
                                    addLop();
                                    break;
                            }
                            case 2: {
                                    deleteLop();
                                    break;
                            }
                            case 3: {
                                    updateLop();
                                    break;
                            }
                            case 4: {
                                    findAllLop();
                                    break;
                            }
                            case 5: {
                                    findLop();
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
