/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableModel;
import POO.Gerente;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author extra
 */
public class GerenteTableModel extends AbstractTableModel{
    
    private String colunas[] = {"Nome", "Taxa"};
    private List<Gerente> dados;
    
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
        Gerente g = dados.get(l);
        switch(c){
            case 0:
                return g.getNome();
            case 1:
                return g.getTaxa();
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
    
    public void setDados(List<Gerente> dados){
        this.dados = dados;
        fireTableDataChanged();
    }
    
    public Gerente getRowValue(int l){
        return dados.get(l);
    }
}
