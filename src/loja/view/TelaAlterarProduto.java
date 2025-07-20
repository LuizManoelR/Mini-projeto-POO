package loja.view;

import javax.swing.*;
import java.awt.*;
import loja.model.Produto;
import loja.service.ProdutoService;

public class TelaAlterarProduto extends JFrame {
    public TelaAlterarProduto(ProdutoService pm) {
        setTitle("Alterar Produto");
        setSize(300, 200);
        setLayout(new GridLayout(4, 2));

        JTextField txtCodigo = new JTextField();
        JTextField txtNovoNome = new JTextField();
        JTextField txtNovoPreco = new JTextField();
        JButton btnSalvar = new JButton("Alterar");

        add(new JLabel("Código do Produto:"));
        add(txtCodigo);
        add(new JLabel("Novo Nome:"));
        add(txtNovoNome);
        add(new JLabel("Novo Preço:"));
        add(txtNovoPreco);
        add(new JLabel());
        add(btnSalvar);

        btnSalvar.addActionListener(e -> {
            String codigo = txtCodigo.getText();
            Produto novo = new Produto(codigo, ABORT, null, null, null);
            pm.alterarProduto(codigo, novo);
            JOptionPane.showMessageDialog(this, "Produto alterado!");
            dispose();
        });
    }
}
