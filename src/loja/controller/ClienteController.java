package loja.controller;

// Importa a classe Cliente do pacote loja.model
import loja.model.Cliente;
// Importa a classe ClienteService, que contém a lógica de negócios
import loja.service.ClienteService;

// Importa a interface List para manipular listas de clientes
import java.util.List;

// Classe responsável por controlar as operações relacionadas a clientes (camada de controle)
public class ClienteController {

    // Instancia o serviço que gerencia os clientes (camada de serviço)
    private ClienteService clienteService = new ClienteService();

    // Método para cadastrar um novo cliente a partir dos dados fornecidos
    public boolean cadastrarCliente(String cpf, String nome, String email, String telefone) {
        // Cria um novo objeto Cliente com os dados recebidos
        Cliente cliente = new Cliente(cpf, nome, email, telefone);
        // Chama o método do serviço para cadastrar o cliente
        return clienteService.cadastrarCliente(cliente);
    }

    // Método para retornar a lista de todos os clientes cadastrados
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes(); // Chama o serviço e retorna a lista
    }

    // Método para buscar um cliente pelo CPF
    public Cliente buscarClientePorCpf(String cpf) {
        return clienteService.buscarPorCpf(cpf); // Chama o serviço e retorna o cliente (se encontrado)
    }

    // Método para alterar os dados de um cliente existente
    public boolean alterarCliente(String cpf, String nome, String email, String telefone) {
        // Chama o serviço passando os novos dados para atualizar o cliente com o CPF informado
        return clienteService.alterarCliente(cpf, nome, email, telefone);
}
}
