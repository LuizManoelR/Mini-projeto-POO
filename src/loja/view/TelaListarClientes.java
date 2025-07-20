package loja.view;

import javax.swing.*;
import loja.service.ClienteService;

public class TelaListarClientes extends JFrame {
    public TelaListarClientes(ClienteService cm) {
        setTitle("Lista de Clientes");
        setSize(300, 200);
        JTextArea area = new JTextArea();
        StringBuilder sb = new StringBuilder();

        for (var c : cm.listarClientes()) {
            sb.append(c.toString()).append("\n");
        }

        area.setText(sb.toString());
        add(new JScrollPane(area));
    }
}

