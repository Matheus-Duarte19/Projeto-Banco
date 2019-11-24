
package POO;

/**
 *
 * @author extra
 */
public class Transicao {
    
    private int codigo;
    private float valor;
    private int conta;

    public Transicao(){
        this.codigo = 0;
        this.valor = 0;
   }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    
    @Override
    public boolean equals(Object o){
        if(o instanceof Transicao){
            Transicao t = (Transicao) o;
            if(t.getCodigo() == this.getCodigo()){
                return true;
            }
        }
        return false;
    }
}
