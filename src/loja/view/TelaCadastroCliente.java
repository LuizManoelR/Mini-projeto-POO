package loja.view;

import javax.swing.*;
import java.awt.*;
import loja.model.Cliente;
import loja.service.ClienteService;

public class TelaCadastroCliente extends JFrame {
    public TelaCadastroCliente(ClienteService cm) {
        setTitle("Cadastrar Cliente");
        setSize(300, 200);
        setLayout(new GridLayout(3, 2));

        JTextField txtNome = new JTextField();
        JTextField txtCPF = new JTextField();
        JTextField txtemail = new JTextField();
        JTextField txttelefone = new JTextField();
        JButton btnSalvar = new JButton("Salvar");

        add(new JLabel("Nome:"));
        add(txtNome);
        add(new JLabel("CPF:"));
        add(txtCPF);
        add(new JLabel("email:"));
        add(txtemail);
        add(new JLabel("telefone:"));
        add(txttelefone);
        add(new JLabel());
        add(btnSalvar);

        btnSalvar.addActionListener(e -> {
            Cliente c = new Cliente(txtNome.getText(), txtCPF.getText(), txtemail.getText(), txttelefone.getText());
            cm.cadastrarCliente(c);
            JOptionPane.showMessageDialog(this, "Cliente cadastrado!");
            dispose();
        });
    }
}
