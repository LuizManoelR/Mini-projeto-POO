package loja.view;

import javax.swing.*;
import loja.model.Produto;
import loja.service.ProdutoService;

public class TelaPrincipal extends JFrame {
    private  Produto Produto = new Produto(getName(), WIDTH, null, null, null);

    public TelaPrincipal() {
        setTitle("Sistema de Vendas");
        setSize(800, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JButton btnCadastrarProduto = new JButton("Cadastrar Produto");
        JButton btnListarProdutos = new JButton("Listar Produtos");
        JButton btnSair = new JButton("Sair");

        add(btnCadastrarProduto);
        add(btnListarProdutos);
        add(btnSair);

        btnCadastrarProduto.addActionListener(e -> new TelaCadastroProduto(Produto).setVisible(true));

        btnListarProdutos.addActionListener(e -> {
            StringBuilder sb = new StringBuilder();
            for (var p : Produto.listarProdutos()) {
                sb.append(p).append("\n");
            }
            JOptionPane.showMessageDialog(this, sb.toString());
        });

        btnSair.addActionListener(e -> System.exit(0));
    }

    public static void main(String[] args) {
        new TelaPrincipal().setVisible(true);
    }
}