package loja.view;

import javax.swing.*;
import java.awt.*;
import loja.model.Produto;

public class TelaCadastroProduto extends JFrame {
    private Produto produto;

    public TelaCadastroProduto(Produto pm) {
        this.produto = pm;

        setTitle("Cadastrar Produto");
        setSize(300, 200);
        setLayout(new GridLayout(4, 2));

        JTextField txtNome = new JTextField();
        JTextField txtCodigo = new JTextField();
        JTextField txtPreco = new JTextField();
        JButton btnSalvar = new JButton("Salvar");

        add(new JLabel("Nome:"));
        add(txtNome);
        add(new JLabel("Código:"));
        add(txtCodigo);
        add(new JLabel("Preço:"));
        add(txtPreco);
        add(new JLabel());
        add(btnSalvar);

        btnSalvar.addActionListener(e -> {
            String nome = txtNome.getText();
            String codigo = txtCodigo.getText();
            double preco = Double.parseDouble(txtPreco.getText());

            Produto p = new Produto(nome, codigo, preco);
            produto.adicionarProduto(p);

            JOptionPane.showMessageDialog(this, "Produto cadastrado!");
            dispose();
        });
    }
}

