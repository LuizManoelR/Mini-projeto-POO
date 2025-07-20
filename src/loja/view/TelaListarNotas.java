package loja.view;

import javax.swing.*;
import manager.NotaManager;

public class TelaListarNotas extends JFrame {
    public TelaListarNotas(NotaManager nm) {
        setTitle("Notas Emitidas");
        setSize(400, 300);
        JTextArea area = new JTextArea();
        StringBuilder sb = new StringBuilder();

        for (var nota : nm.listarNotas()) {
            sb.append(nota.toString()).append("\n");
        }

        area.setText(sb.toString());
        add(new JScrollPane(area));
    }
}

