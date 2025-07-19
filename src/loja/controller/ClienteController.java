package loja.controller;

import loja.model.Cliente;
import loja.service.ClienteService;

import java.util.List;

public class ClienteController {

    private ClienteService clienteService = new ClienteService();

    public boolean cadastrarCliente(String cpf, String nome, String email, String telefone) {
        Cliente cliente = new Cliente(cpf, nome, email, telefone);
        return clienteService.cadastrarCliente(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }

    public Cliente buscarClientePorCpf(String cpf) {
        return clienteService.buscarPorCpf(cpf);
    }
    public boolean alterarCliente(String cpf, String nome, String email, String telefone) {
    return clienteService.alterarCliente(cpf, nome, email, telefone);
}
}
