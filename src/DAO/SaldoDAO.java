/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POO.Saldo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author extra
 */
public class SaldoDAO implements IDAO<Saldo>{
    
     @Override
    public void inserir(Saldo saldo) throws Exception{
        Conexao c = new Conexao();
        String sql="INSERT INTO CONTAS "
      + "(SALDO,IDCLIENTE) VALUES (?, ?)";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setFloat(1, saldo.getSaldo());
        ps.setInt(2, saldo.getContacliente());
        c.confirmar();
    }
    
    @Override
    public void alterar(Saldo saldo) throws Exception{
        Conexao c = new Conexao();
        String sql="UPDATE CONTAS SET "
     + "SALDO=?, IDCLIENTE=? WHERE IDCONTA=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setFloat(1, saldo.getSaldo());
        ps.setInt(2, saldo.getContacliente());
        ps.setInt(3, saldo.getCodigo());
        ps.execute();
        c.confirmar();
    }
    
 
    
    
    @Override
    public void excluir(Saldo saldo) throws Exception{
        Conexao c = new Conexao();
        String sql = "DELETE FROM CONTAS WHERE IDCONTA=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, saldo.getCodigo());
        ps.execute();
        c.confirmar();
    }
    
    @Override
    public ArrayList<Saldo> listarTodos() throws Exception{
        Conexao c = new Conexao();
        String sql = "SELECT * FROM CONTAS ORDER BY NOME";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        ArrayList listarSaldo = new ArrayList();
        while(rs.next()){
            Saldo saldo = new Saldo();
            saldo.setCodigo(rs.getInt("CODIGO"));
            saldo.setSaldo(rs.getFloat("SALDO"));
            saldo.setContacliente(rs.getInt("IDCLIENTE"));
        }
        return listarSaldo;
    }
    
    @Override
    public Saldo recuperar(int codigo) throws Exception{
        Conexao c = new Conexao();
        String sql = "SELECT * FROM CONTAS WHERE IDCONTA=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();
       
        Saldo saldo = new Saldo();
        if(rs.next()){
            saldo.setCodigo(rs.getInt("CODIGO"));
            saldo.setSaldo(rs.getFloat("SALDO"));
            saldo.setContacliente(rs.getInt("IDCLIENTE"));
        }
        return saldo;
    }


}
