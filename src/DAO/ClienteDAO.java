package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import POO.Cliente;



public class ClienteDAO implements IDAO<Cliente>{
     
    @Override
    public void inserir(Cliente cliente) throws Exception{
        Conexao c = new Conexao();
        String sql="INSERT INTO CLIENTE "
      + "(NOME, CPF, RG, DATANASCIMENTO, ESTADO, NACIONALIDADE, CIDADE, TIPOCONTA, SENHA) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ? )";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getCpf());
        ps.setString(3, cliente.getRg());
        ps.setDate(4, new Date(cliente.getDatanascimento().getTime()));
        ps.setString(5, cliente.getEstado());
        ps.setString(6, cliente.getNacionalidade());
        ps.setString(7, cliente.getCidade());
        ps.setString(8, cliente.getTipoconta());
        ps.setString(9, cliente.getSenha());
        ps.execute();
        c.confirmar();
    }
    
    @Override
    public void alterar(Cliente cliente) throws Exception{
        Conexao c = new Conexao();
        String sql="UPDATE CLIENTE SET "
     + "NOME=?, CPF=?, RG=?, DATANASCIMENTO=?, ESTADO=?, NACIONALIDADE=?, CIDADE=?, TIPOCONTA=?, SENHA=? WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
       ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getCpf());
        ps.setString(3, cliente.getRg());
        ps.setDate(4, new Date(cliente.getDatanascimento().getTime()));
        ps.setString(5, cliente.getEstado());
        ps.setString(6, cliente.getNacionalidade());
        ps.setString(7, cliente.getCidade());
        ps.setString(8, cliente.getTipoconta());
        ps.setString(9, cliente.getSenha());
        ps.execute();
        c.confirmar();
    }
    
 
    
    
    @Override
    public void excluir(Cliente cliente) throws Exception{
        Conexao c = new Conexao();
        String sql = "DELETE FROM CLIENTE WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, cliente.getCodigo());
        ps.execute();
        c.confirmar();
    }
    
    @Override
    public ArrayList<Cliente> listarTodos() throws Exception{
        Conexao c = new Conexao();
        String sql = "SELECT * FROM CLIENTE ORDER BY NOME";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        ArrayList listarClientes = new ArrayList();
        while(rs.next()){
            Cliente cliente = new Cliente();
            cliente.setCodigo(rs.getInt("CODIGO"));
            cliente.setNome(rs.getString("NOME"));
            cliente.setCpf(rs.getString("CPF"));
            cliente.setRg(rs.getString("RG"));
            cliente.setDatanascimento(rs.getDate("DATANASCIMENTO"));
            cliente.setEstado(rs.getString("ESTADO"));
            cliente.setNacionalidade(rs.getString("NACIONALIDADE"));
            cliente.setCidade(rs.getString("CIDADE"));
            cliente.setTipoconta(rs.getString("TIPOCONTA"));
            cliente.setSenha(rs.getString("SENHA"));
            listarClientes.add(cliente);
        }
        return listarClientes;
    }
    
    @Override
    public Cliente recuperar(int codigo) throws Exception{
        Conexao c = new Conexao();
        String sql = "SELECT * FROM CLIENTE WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();
       
        Cliente cliente = new Cliente();
        if(rs.next()){
            cliente.setCodigo(rs.getInt("CODIGO"));
            cliente.setNome(rs.getString("NOME"));
            cliente.setCpf(rs.getString("CPF"));
            cliente.setRg(rs.getString("RG"));
            cliente.setDatanascimento(rs.getDate("DATANASCIMENTO"));
            cliente.setEstado(rs.getString("ESTADO"));
            cliente.setNacionalidade(rs.getString("NACIONALIDADE"));
            cliente.setCidade(rs.getString("CIDADE"));
            cliente.setTipoconta(rs.getString("TIPOCONTA"));
            cliente.setSenha(rs.getString("SENHA"));
        }
        return cliente;
    }
    public boolean check(String cpf, String senha) throws Exception{
        Conexao c = new Conexao();
        String sql = "SELECT * FROM CLIENTE WHERE CPF=?and SENHA=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setString(1, cpf);
        ps.setString(2, senha);
        ResultSet rs = ps.executeQuery();
        
    boolean check = false;
        if(rs.next()){
           check = true;
        }
        return check;
    }
    
    public boolean encontrar (int codigo) throws Exception{
        Conexao c = new Conexao();
        String sql = "SELECT * FROM CLIENTE WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();
        
          boolean check = false;
        if(rs.next()){
           check = true;
        }
        return check;
    }
    
   
}
