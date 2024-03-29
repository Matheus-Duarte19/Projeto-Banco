package POO;
/**
 *
 * @author extra
 */
public class Saldo {
    
    private int codigo;
    private double saldo;
    private int contacliente;

    public Saldo(){
        this.codigo =0;
        this.contacliente =0;
        this.saldo = 0;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public int getContacliente() {
        return contacliente;
    }

    public void setContacliente(int contacliente) {
        this.contacliente = contacliente;
    }
    
    @Override
    public boolean equals(Object o){
        if(o instanceof Saldo){
            Saldo s = (Saldo) o;
            if(s.getCodigo() == this.getCodigo()){
                return true;
            }
        }
        return false;
    }
   
}

        
    

