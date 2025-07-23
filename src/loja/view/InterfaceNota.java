package loja.view;

import java.util.Scanner;

import loja.controller.ClienteController;
import loja.controller.NotaController;
import loja.controller.ProdutoController;
import loja.service.ItemService;
import loja.service.NotaService;
import loja.model.Cliente;
import loja.model.Item;
import loja.model.Nota;


public class InterfaceNota {

    public static void iniciar(ProdutoController pc, ClienteController cc, NotaController nc){

        System.out.println("------- Nota Fiscal -------\n\n");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira o CPF do cliente .....\n");

        String cpf = scanner.nextLine().trim();

        Cliente cliente = cc.buscarClientePorCpf(cpf);

        NotaService ns = new NotaService(cliente);
        
        while(true){
            
            System.out.println("Insira o codigo e a quatidade (ou sair para finalizar)");
            
            String linha = scanner.nextLine().trim();

            if(linha.equalsIgnoreCase("sair")){break;}

            String[] partes = linha.split(" ");
            
            if(partes.length != 2){System.out.println("Entrada inválida, use <codigo> e quantidade...");continue;}
                
            String codigo = partes[0];
            int quantidade;

            try {
                quantidade = Integer.parseInt(partes[1]);
            } catch (NumberFormatException e) {
                System.out.println("Quantidade inválida.");
                continue;
            }
            

            Item item = ItemService.criarItem(pc.buscarProduto(codigo), quantidade);

            ns.addItem(item);
            
        }
        
        scanner.close();
        nc.addNota(ns.getNota());

   }
    
}
