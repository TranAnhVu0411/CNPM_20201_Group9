/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.congnghephanmem.DAO;

import com.congnghephanmem.model.Hokhau;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vu
 */
public class HokhauDAO {
    Connection con = DBConnection.getConnection();
    PreparedStatement s;
    public List<Hokhau> xuathokhau(){
        List<Hokhau> hokhau = new ArrayList<Hokhau>();
        String sql = "Select * from hokhautable;";
        try{
            s=con.prepareCall(sql);
            ResultSet rs=s.executeQuery();
            while(rs.next()){
                Hokhau hk = new Hokhau();
                hk.setDiachi(rs.getString("diachi"));
                hk.setHotenchuho(rs.getString("tenchuho"));
                hk.setSohokhau((rs.getString("sohokhau")));
                hokhau.add(hk);
            }
            rs.close();
        }catch (SQLException ex) {
              ex.printStackTrace();
        }   
        return hokhau;
    }
    
    public int themhokhau(Hokhau hk) {
        try{
            s=con.prepareStatement("insert into hokhautable(sohokhau, tenchuho, diachi) values (?,?,?)");
            s.setString(1, hk.getSohokhau());
            s.setString(2, hk.getHotenchuho());
            s.setString(3, hk.getDiachi());
            s.executeUpdate();
            return 1;
        }catch (SQLException ex) {
              ex.printStackTrace();
              return 0;
        }   
    }
    
    public int capnhathokhau (Hokhau hk){
        try{
            s=con.prepareStatement("update hokhautable set tenchuho=?, diachi=? where sohokhau=?");
            s.setString(1, hk.getHotenchuho());
            s.setString(2, hk.getDiachi());
            s.setString(3, hk.getSohokhau());
            s.executeUpdate();
            return 1;
        }catch (SQLException ex) {
              ex.printStackTrace();
              return 0;
        }   
    }
    
    public void xoahokhau (String sohokhau) {
        try {
            s = con.prepareStatement("delete from hokhautable where sohokhau = ?");
            s.setString(1, sohokhau);
            s.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }    
    
    public Hokhau timhokhau(String sohokhau) {
        HokhauDAO hokhaudao = new HokhauDAO();
        List<Hokhau> hokhau = hokhaudao.xuathokhau();
        for (Hokhau i : hokhau) {
            if ( sohokhau.equals(i.getSohokhau())) {
                return i;
            }
        }
        return null;
    }        
}