/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import dao_DieuKhienDaTa.MonHocDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.MonHoc;
import service_NhapXuat.MonHoc_Service;

/**
 *
 * @author PC ACER
 */
public class MonHoc_Main {
    public static Scanner sc = new Scanner(System.in);
    public static void addMonHoc(){
        MonHoc mh = new MonHoc();
        MonHocDao mhDao = new MonHocDao();
        MonHoc_Service mh_Service = new MonHoc_Service();
        mh_Service.inp(mh);
        try{
            mhDao.add(mh);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void deleteMonHoc(){
        System.out.println("Please input MaMonHoc to delete MonHoc: ");
        MonHocDao mhDao = new MonHocDao();
        String maMH = sc.nextLine();
        try{
            mhDao.delete(maMH);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void updateMonHoc(){
        MonHoc mh = new MonHoc();
        MonHocDao mhDao = new MonHocDao();
        MonHoc_Service mh_Service = new MonHoc_Service();
        mh_Service.inp(mh);
        try{
            mhDao.update(mh);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void findAllMonHoc(){
        List<MonHoc> list = new ArrayList();
        MonHocDao lopDao = new MonHocDao();
        MonHoc_Service lop_Service = new MonHoc_Service();
        try{
            list = lopDao.findAll();
            for(MonHoc mh : list){
                lop_Service.info(mh);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void findMonHoc(){
        System.out.println("Please input MaMonHoc to find MonHoc: ");
        String maMH = sc.nextLine();
        List<MonHoc> list = new ArrayList();
        MonHocDao lopDao = new MonHocDao();
        MonHoc_Service lop_Service = new MonHoc_Service();
        try{
            list = lopDao.find(maMH);
            for(MonHoc mh : list){
                lop_Service.info(mh);
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
                                addMonHoc();
                                break;
                        }
                        case 2: {
                                deleteMonHoc();
                                break;
                        }
                        case 3: {
                                updateMonHoc();
                                break;
                        }
                        case 4: {
                                findAllMonHoc();
                                break;
                        }
                        case 5: {
                                findMonHoc();
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
