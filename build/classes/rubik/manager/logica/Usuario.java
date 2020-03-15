/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rubik.manager.logica;

/**
 *
 * @author Wz
 */
public class Usuario {
        private String login, senha, nome, tipo, idade, telefone, cidade, email, wca, cubo, categoriaFiscalizada ;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCubo() {
        return cubo;
    }

    public void setCubo(String cubo) {
        this.cubo = cubo;
    }

    public String getCategoriaFiscalizada() {
        return categoriaFiscalizada;
    }

    public void setCategoriaFiscalizada(String categoriaFiscalizada) {
        this.categoriaFiscalizada = categoriaFiscalizada;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getWca() {
        return wca;
    }

    public void setWca(String wca) {
        this.wca = wca;
    }
    
}
