package TableModels;

import POO.Cliente;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ClienteTableModel extends AbstractTableModel {

    private String colunas[] = {"Nome","CPF","RG","DataNascimento","TipoConta","Cidade","Estado","Nacionalidade"};
    private List<Cliente> dados;
    
    @Override
    public int getRowCount() {
       if(dados == null){
           return 0;
       }
       return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int l, int c) {
        Cliente cliente = dados.get(l);
        switch(c){
            case 0:
                return cliente.getNome();
            case 1:
                return cliente.getCpf();
            case 2:
                return cliente.getDatanascimento();
            case 3:
                return cliente.getTipoconta();
            case 4:
                return cliente.getRg();
            case 5: 
                return cliente.getCidade();
            case 6: 
                return cliente.getEstado();
            case 7:
                return cliente.getNacionalidade();
            default:
                throw new IndexOutOfBoundsException("Coluna inexistente");
        }
    }
    
    @Override
    public String getColumnName(int c){
        return colunas[c];
    }
    
    @Override
    public boolean isCellEditable(int l, int c){
        return false;
    }
    
    public void setDados(List<Cliente> dados){
        this.dados = dados;
        fireTableDataChanged();
    }
    
    public Cliente getRowValue(int l){
        return dados.get(l);
    }
}

