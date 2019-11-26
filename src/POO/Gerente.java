/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POO;

/**
 *
 * @author extra
 */
public class Gerente {
    
    private int codigo;
    private String nome;
    private double taxa;
    
    public Gerente(){
        this.codigo = 0;
        this.nome = "";
        this.taxa = 0; 
}

    public Gerente(int codigo, String nome, double taxa) {
        this.codigo = codigo;
        this.nome = nome;
        this.taxa = taxa;
    }
   public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }
    
    
     @Override
    public String toString(){
        return getNome();
    }
      @Override
    public boolean equals(Object o){
        if(o instanceof Gerente){
            Gerente GT = (Gerente) o;
            if(GT.getCodigo() == this.getCodigo()){
                return true;
            }
        }
        return false;
    }

    
}
