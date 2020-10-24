/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.congnghephanmem.DAO;

/**
 *
 * @author Vu
 */

import com.congnghephanmem.model.Nhankhau;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class NhankhauDAO {
    Connection con = DBConnection.getConnection();
    PreparedStatement s;
    SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
    public static String id;
    public static String ten;
    public void setId(String id) {
        this.id = id;
    }
    
    public void setTen(String ten) {
        this.ten = ten;
    }
    
    public List<Nhankhau> xuatnhankhau(){
        List<Nhankhau> nhankhau = new ArrayList<Nhankhau>();
        String sql = "Select * from nhankhautable;";
        try{
            s=con.prepareCall(sql);
            ResultSet rs=s.executeQuery();
            while(rs.next()){
                if(id.equals(rs.getString("sohokhau"))){
                    Nhankhau nk = new Nhankhau();
                    nk.setSohokhau(id);
                    nk.setMadinhdanh(rs.getString("madinhdanh"));
                    nk.setHoten(rs.getString("hoten"));
                    nk.setBidanh((rs.getString("bidanh")));
                    nk.setNgaysinh(rs.getDate("ngaysinh"));
                    nk.setNoisinh(rs.getString("noisinh"));
                    nk.setNguyenquan(rs.getString("nguyenquan"));
                    nk.setDantoc(rs.getString("dantoc"));
                    nk.setNghenghiep(rs.getString("nghenghiep"));
                    nk.setNoilamviec(rs.getString("noilamviec"));
                    nk.setCmnd(rs.getString("cmnd"));
                    nk.setNgaycap(rs.getDate("ngaycap"));
                    nk.setNoicap(rs.getString("noicap"));
                    nk.setQuanhe(rs.getString("quanhe"));
                    nk.setDiachicu(rs.getString("diachicu"));
                    nk.setNgaydkthuongtru(rs.getDate("ngaydkthuongtru"));
                    nk.setGhichu(rs.getString("ghichu"));
                    nk.setNoichuyen(rs.getString("noichuyen"));
                    nk.setNgaychuyendi(rs.getDate("ngaychuyendi"));
                    nhankhau.add(nk);
                }
            }
        }catch (SQLException ex) {
              ex.printStackTrace();
        }   
        return nhankhau;
    }
    
     public int themnhankhau(Nhankhau nk) {
        try{
            s=con.prepareStatement("insert into nhankhautable(sohokhau, madinhdanh, hoten, bidanh, ngaysinh, noisinh, nguyenquan, dantoc, nghenghiep, noilamviec, cmnd, ngaycap, noicap, quanhe, diachicu, ngaydkthuongtru, ghichu, ngaychuyendi, noichuyen) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            s.setString(1, id);
            s.setString(2, nk.getMadinhdanh());
            s.setString(3, nk.getHoten());
            s.setString(4, nk.getBidanh());
            s.setString(5, fmt.format(nk.getNgaysinh()));
            s.setString(6, nk.getNoisinh());
            s.setString(7, nk.getNguyenquan());
            s.setString(8, nk.getDantoc());
            s.setString(9, nk.getNghenghiep());
            s.setString(10,nk.getNoilamviec());
            s.setString(11, nk.getCmnd());
            s.setString(12, fmt.format(nk.getNgaycap()));
            s.setString(13, nk.getNoicap());
            s.setString(14, nk.getQuanhe());
            s.setString(15, nk.getDiachicu());
            s.setString(16, fmt.format(nk.getNgaydkthuongtru()));
            s.setString(17, nk.getGhichu());
            s.setString(18, fmt.format(nk.getNgaychuyendi()));
            s.setString(19, nk.getNoichuyen());
            s.executeUpdate();
            return 1;
        }catch (SQLException ex) {
              ex.printStackTrace();
              return 0;
        }   
    }
     
    public int xoanhankhau (String madinhdanh){
        try{
            s = con.prepareStatement("delete from nhankhautable where madinhdanh = ? and sohokhau = ?");
            s.setString(1, madinhdanh);
            s.setString(2, id);
            s.executeUpdate();
            return 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    } 
    
    public int capnhatnhankhau(Nhankhau nk){
        try{
            s=con.prepareStatement("update nhankhautable set hoten=?, bidanh=?, ngaysinh=?, noisinh=?, nguyenquan=?, dantoc=?, nghenghiep=?, noilamviec=?, cmnd=?, ngaycap=?, noicap=?, quanhe=?, diachicu=?, ngaydkthuongtru=?, ghichu=?, ngaychuyendi=?, noichuyen=? where sohokhau=? and madinhdanh=?");
            
            s.setString(1, nk.getHoten());
            s.setString(2, nk.getBidanh());
            s.setString(3, fmt.format(nk.getNgaysinh()));
            s.setString(4, nk.getNoisinh());
            s.setString(5, nk.getNguyenquan());
            s.setString(6, nk.getDantoc());
            s.setString(7, nk.getNghenghiep());
            s.setString(8,nk.getNoilamviec());
            s.setString(9, nk.getCmnd());
            s.setString(10, fmt.format(nk.getNgaycap()));
            s.setString(11, nk.getNoicap());
            s.setString(12, nk.getQuanhe());
            s.setString(13, nk.getDiachicu());
            s.setString(14, fmt.format(nk.getNgaydkthuongtru()));
            s.setString(15, nk.getGhichu());
            s.setString(16, fmt.format(nk.getNgaychuyendi()));
            s.setString(17, nk.getNoichuyen());
            s.setString(18, id);
            s.setString(19, nk.getMadinhdanh());
            s.executeUpdate();
            return 1;
        }catch(SQLException ex){
            ex.printStackTrace();
            return 0;
        }
    }
}
