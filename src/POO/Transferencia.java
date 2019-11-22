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
public class Transferencia {
    
    private int codigo;
    private float saldo;
    private int contacliente;
    
    public Transferencia(){
        this.codigo = 0;
        this.saldo = 0;
   }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public float getSaldo() {
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
    
    
}
