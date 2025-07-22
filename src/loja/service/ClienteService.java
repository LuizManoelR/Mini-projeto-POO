package loja.service;

// Importa a classe Cliente do pacote loja.model
import loja.model.Cliente;

// Importa as classes necessárias para usar listas
import java.util.ArrayList;
import java.util.List;

// Classe responsável pela lógica de serviço para gerenciar clientes
public class ClienteService {

    // Lista privada que armazena todos os clientes cadastrados em memória
    private List<Cliente> clientes = new ArrayList<>();

    // Método para cadastrar um novo cliente
    public boolean cadastrarCliente(Cliente cliente) {
        // Verifica se já existe um cliente com o mesmo CPF
        if (buscarPorCpf(cliente.getCpf()) != null) {
            return false; // Se já existir, não cadastra e retorna false
        }
        // Se o CPF for único, adiciona o cliente à lista
        clientes.add(cliente);
        return true; // Cadastro realizado com sucesso
    }

    // Método para retornar a lista de todos os clientes cadastrados
    public List<Cliente> listarClientes() {
        return clientes;
    }

    // Método para buscar um cliente pelo CPF
    public Cliente buscarPorCpf(String cpf) {
        // Percorre a lista de clientes
        for (Cliente cliente : clientes) {
            // Compara o CPF do cliente atual com o CPF procurado
            if (cliente.getCpf().equals(cpf)) {
                return cliente; // Retorna o cliente encontrado
            }
        }
        return null; // Se não encontrar, retorna null
    }
    // Método para alterar os dados de um cliente existente com base no CPF
    public boolean alterarCliente(String cpf, String novoNome, String novoEmail, String novoTelefone) {
        // Busca o cliente pelo CPF
        Cliente clienteExistente = buscarPorCpf(cpf);
        // Se o cliente for encontrado
        if (clienteExistente != null) {
            // Atualiza os dados do cliente
            clienteExistente.setNome(novoNome);
            clienteExistente.setEmail(novoEmail);
            clienteExistente.setTelefone(novoTelefone);
            return true; // Alteração realizada com sucesso
        }
        return false; // Se o cliente não for encontrado, retorna false
    }
}


