package loja.view;

import javax.swing.*;

import loja.model.Cliente;
import loja.model.Produto;
import loja.service.ClienteService;

import java.awt.*;
import manager.*;
import model.*;
import java.util.ArrayList;

public class TelaNotaCompra extends JFrame {
    public TelaNotaCompra(ClienteService cm, Produto pm, NotaManager nm) {
        setTitle("Criar Nota de Compra");
        setSize(400, 300);
        setLayout(new BorderLayout());

        JComboBox<String> cbClientes = new JComboBox<>();
        for (Cliente c : cm.listarClientes()) {
            cbClientes.addItem(c.getCpf());
        }

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Produto p : pm.listarProdutos()) {
            listModel.addElement(p.getCodigo());
        }

        JList<String> listaProdutos = new JList<>(listModel);
        JButton btnCriar = new JButton("Criar Nota");

        add(new JLabel("Selecione o Cliente (CPF):"), BorderLayout.NORTH);
        add(cbClientes, BorderLayout.WEST);
        add(new JScrollPane(listaProdutos), BorderLayout.CENTER);
        add(btnCriar, BorderLayout.SOUTH);

        btnCriar.addActionListener(e -> {
            String cpfSelecionado = (String) cbClientes.getSelectedItem();
            Cliente cliente = cm.buscarPorCpf(cpfSelecionado);
            NotaCompra nota = new NotaCompra(nm.gerarNumeroNota(), cliente);

            for (String codigo : listaProdutos.getSelectedValuesList()) {
                Produto p = pm.buscarPorCodigo(codigo);
                nota.adicionarProduto(p);
            }

            nm.adicionarNota(nota);
            JOptionPane.showMessageDialog(this, "Nota criada!");
            dispose();
        });
    }
}