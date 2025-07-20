package loja.view;

import javax.swing.*;
import java.awt.*;
import loja.model.Cliente;
import loja.service.ClienteService;

public class TelaAlterarCliente extends JFrame {
    public TelaAlterarCliente(ClienteService cm) {
        setTitle("Alterar Cliente");
        setSize(300, 200);
        setLayout(new GridLayout(3, 2));

        JTextField txtCpf = new JTextField();
        JTextField txtNovoNome = new JTextField();
        JTextField txtNovoEmail = new JTextField();
        JTextField txtNovoTelefone = new JTextField();
        JButton btnAlterar = new JButton("Alterar");

        add(new JLabel("CPF do Cliente:"));
        add(txtCpf);
        add(new JLabel("Novo Nome:"));
        add(txtNovoNome);
        add(new JLabel("Novo email:"));
        add(txtNovoEmail);
        add(new JLabel("Novo telefone:"));
        add(txtNovoTelefone);
        add(new JLabel());
        add(btnAlterar);

        btnAlterar.addActionListener(e -> {
            String cpf = txtCpf.getText();
            Cliente novo = new Cliente(txtNovoNome.getText(), txtCpf.getText(), txtNovoEmail.getText(), txtNovoTelefone.getText());;
            cm.alterarCliente( cpf, cpf, cpf, cpf);
            JOptionPane.showMessageDialog(this, "Cliente alterado!");
            dispose();
        });
    }
}
