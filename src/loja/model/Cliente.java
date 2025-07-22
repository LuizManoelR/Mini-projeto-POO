package loja.model;

// Declaração da classe Cliente
public class Cliente {
    // Armazena o CPF do cliente
    private String cpf;
    // Armazena o nome do cliente
    private String nome;
    // Armazena o e-mail do cliente
    private String email;
    // Armazena o número de telefone do cliente
    private String telefone;

    // Construtor padrão (sem parâmetros)
    // Permite criar um objeto Cliente sem passar valores na criação
    public Cliente() {}

     // Construtor com parâmetros
    // Permite criar um objeto Cliente já definindo CPF, nome, email e telefone
    public Cliente(String cpf, String nome, String email, String telefone) {
        // Atribui o valor recebido ao atributo cpf
        this.cpf = cpf;
        // Atribui o valor recebido ao atributo nome
        this.nome = nome;
        // Atribui o valor recebido ao atributo email
        this.email = email;
        // Atribui o valor recebido ao atributo telefone
        this.telefone = telefone;
    }

    // Métodos "getter" para acessar os valores dos atributos (leitura)
    public String getCpf() {
        // Retorna o valor atual do CPF
        return cpf;
    }

     // Métodos "setter" para modificar os valores dos atributos (escrita)
    public void setCpf(String cpf) {
        // Atualiza o valor do CPF
        this.cpf = cpf;
    }

    public String getNome() {
        // Retorna o valor atual do nome
        return nome;
    }

     // Metodos "setter" para modificar os valores dos atributos (escrita)
    public void setNome(String nome) {
        // Atualiza o valor do nome
        this.nome = nome;
    }

    public String getEmail() {
        // Retorna o valor atual do email
        return email;
    }

     // Métodos "setter" para modificar os valores dos atributos (escrita)
    public void setEmail(String email) {
        // Atualiza o valor do email
        this.email = email;
    }

    public String getTelefone() {
        // Retorna o valor atual do telefone
        return telefone;
    }

     // Métodos "setter" para modificar os valores dos atributos (escrita)
    public void setTelefone(String telefone) {
        // Atualiza o valor do telefone
        this.telefone = telefone;
    }

}

