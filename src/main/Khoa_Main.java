/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import dao_DieuKhienDaTa.KhoaDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Khoa;
import service_NhapXuat.Khoa_Service;

/**
 *
 * @author PC ACER
 */
public class Khoa_Main {
    public static Scanner sc = new Scanner(System.in);
    
    public static void addKhoa(){
        Khoa khoa = new Khoa();
        KhoaDao khoaDao = new KhoaDao();
        Khoa_Service khoa_Service = new Khoa_Service();
        khoa_Service.inp(khoa);
        try{
            khoaDao.add(khoa);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void deleteKhoa(){
        System.out.println("Please input MaKhoa to delete Khoa: ");
        KhoaDao khoaDao = new KhoaDao();
        try{
            khoaDao.delete(sc.nextLine());
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void updateKhoa(){
        Khoa khoa = new Khoa();
        KhoaDao khoaDao = new KhoaDao();
        Khoa_Service khoa_Service = new Khoa_Service();
        khoa_Service.inp(khoa);
        try{
            khoaDao.update(khoa);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void findAllKhoa(){
        List<Khoa> list = new ArrayList();
        KhoaDao khoaDao = new KhoaDao();
        Khoa_Service khoa_Service = new Khoa_Service();
        try{
            list = khoaDao.findAll();
            for( Khoa khoa : list){
                khoa_Service.info(khoa);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
    }
    public static void findKhoa(){
        System.out.println("Please input MaKhoa to find Khoa: ");
        List<Khoa> list = new ArrayList();
        KhoaDao khoaDao = new KhoaDao();
        Khoa_Service khoa_Service = new Khoa_Service();
        try{
            list = khoaDao.find(sc.nextLine());
            for( Khoa khoa : list){
                khoa_Service.info(khoa);
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
                                    addKhoa();
                                    break;
                            }
                            case 2: {
                                    deleteKhoa();
                                    break;
                            }
                            case 3: {
                                    updateKhoa();
                                    break;
                            }
                            case 4: {
                                    findAllKhoa();
                                    break;
                            }
                            case 5: {
                                    findKhoa();
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
