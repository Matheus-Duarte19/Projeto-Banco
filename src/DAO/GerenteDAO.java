/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POO.Gerente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author extra
 */
public class GerenteDAO implements IDAO<Gerente> {

    @Override
    public void inserir(Gerente taxa) throws Exception {
         Conexao c = new Conexao();
        String sql="INSERT INTO GERENTE "
      + "(NOMEGERENTE,TAXA) VALUES (?, ?)";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setString(1, taxa.getNome());
        ps.setDouble(2, taxa.getTaxa());
        c.confirmar();
    }

    @Override
    public void alterar(Gerente taxa) throws Exception{
        Conexao c = new Conexao();
        String sql="UPDATE GERENTE SET "
     + "NOMEGERENTE=?, TAXA=? WHERE IDGERENTE=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setString(1, taxa.getNome());
        ps.setDouble(2, taxa.getTaxa());
        ps.setInt(3, taxa.getCodigo());
        ps.execute();
        c.confirmar();
    }
    
 
    
    
    @Override
    public void excluir(Gerente taxa) throws Exception{
        Conexao c = new Conexao();
        String sql = "DELETE FROM GERENTE WHERE IDGERENTE=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, taxa.getCodigo());
        ps.execute();
        c.confirmar();
    }
    
    @Override
    public ArrayList<Gerente> listarTodos() throws Exception{
        Conexao c = new Conexao();
        String sql = "SELECT * FROM GERENTE ORDER BY NOME";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        ArrayList listarGerente = new ArrayList();
        while(rs.next()){
            Gerente taxa = new  Gerente();
            taxa.setCodigo(rs.getInt("IDGERENTE"));
            taxa.setNome(rs.getString("NOMEGERENTE"));
            taxa.setTaxa(rs.getDouble("TAXA"));
        }
        return listarGerente;
    }
    
    @Override
    public Gerente recuperar(int codigo) throws Exception{
        Conexao c = new Conexao();
        String sql = "SELECT * FROM TRANSFERENCIA WHERE IDGERENTE=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();
       
        Gerente taxa = new  Gerente();
        if(rs.next()){
            taxa.setCodigo(rs.getInt("IDGERENTE"));
            taxa.setNome(rs.getString("NOMEGERENTE"));
            taxa.setTaxa(rs.getDouble("TAXA"));
        }
        return taxa;
    }
}
