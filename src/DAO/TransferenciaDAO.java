/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POO.Transicao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author extra
 */
public class TransferenciaDAO implements IDAO<Transicao> {
 
     @Override
    public void inserir(Transicao transferencia) throws Exception{
        Conexao c = new Conexao();
        String sql="INSERT INTO TRANSFERENCIA "
      + "(TRANSFERENCIA,IDCONTA) VALUES (?, ?)";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setFloat(1, transferencia.getValor());
        ps.setInt(2, transferencia.getConta());
        c.confirmar();
    }
    
    @Override
    public void alterar(Transicao transferencia) throws Exception{
        Conexao c = new Conexao();
        String sql="UPDATE TRANSFERENCIA SET "
     + "TRANSFERENCIA=?, IDCONTA=? WHERE IDTRANSFERENCIA=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setFloat(1, transferencia.getValor());
        ps.setInt(2, transferencia.getConta());
        ps.setInt(3, transferencia.getCodigo());
        ps.execute();
        c.confirmar();
    }
    
 
    
    
    @Override
    public void excluir(Transicao transferencia) throws Exception{
        Conexao c = new Conexao();
        String sql = "DELETE FROM TRANSFERENCIA WHERE IDTRANSFERENCIA=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, transferencia.getCodigo());
        ps.execute();
        c.confirmar();
    }
    
    @Override
    public ArrayList<Transicao> listarTodos() throws Exception{
        Conexao c = new Conexao();
        String sql = "SELECT * FROM TRANSFERENCIA ORDER BY NOME";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        ArrayList listarSaldo = new ArrayList();
        while(rs.next()){
            Transicao transferencia = new Transicao();
            transferencia.setCodigo(rs.getInt("IDTRANSFERENCIA"));
            transferencia.setValor(rs.getFloat("TRANSFERENCIA"));
            transferencia.setConta(rs.getInt("IDCONTA"));
        }
        return listarSaldo;
    }
    
    @Override
    public Transicao recuperar(int codigo) throws Exception{
        Conexao c = new Conexao();
        String sql = "SELECT * FROM TRANSFERENCIA WHERE IDCONTA=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();
       
        Transicao transferencia = new Transicao();
        if(rs.next()){
            transferencia.setCodigo(rs.getInt("IDTRANSFERENCIA"));
            transferencia.setValor(rs.getFloat("TRANSFERENCIA"));
            transferencia.setConta(rs.getInt("IDCONTA"));
        }
        return transferencia;
    }

}
