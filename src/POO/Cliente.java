
package POO;
import java.util.Date;
/**
 *
 * @author extra
 */
public class Cliente {
    
    private int codigo;
    private String nome;
    private String cpf;
    private String rg;
    private String tipoconta;
    private Date datanascimento;
    private String cidade;
    private String estado;
    private String nacionalidade;
    private String senha;

    public Cliente(){
        this.codigo = 0;
        this.nome = "";
        this.cpf = "";
        this.rg ="";
        this.tipoconta = "";
        this.datanascimento = new Date();
        this.cidade = "";
        this.estado = "";
        this.nacionalidade = "";
        this.senha = "";
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getTipoconta() {
        return tipoconta;
    }

    public void setTipoconta(String tipoconta) {
        this.tipoconta = tipoconta;
    }

    public Date getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
}
