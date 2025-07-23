package loja.view;

import java.util.Scanner;

import loja.controller.ClienteController;
import loja.controller.NotaController;
import loja.controller.ProdutoController;
import loja.service.ItemService;
import loja.service.NotaService;
import loja.service.ProdutoService;
import loja.model.Cliente;
import loja.model.Item;
import loja.model.Produto;


public class InterfaceNota {

    public static void exibir(ProdutoController pc, ClienteController cc, NotaController nc, Scanner scanner){

        System.out.println("----------------- Nota Fiscal -----------------\n\n");
        
        String cpf;
        do{
        System.out.println("Insira o CPF do cliente (ou 'sair' para cancelar).....\n");
            
        cpf = scanner.nextLine().trim();

        if(cpf.equalsIgnoreCase("sair")){

            System.out.println("Operação cancelada.....");
            return;

        }

        if(cc.buscarClientePorCpf(cpf) == null){
            
            System.out.println("Cpf inválido ou ainda não cadastrado, tente novamente... \n");
            cpf = scanner.nextLine().trim();

        }
        
        }while (cc.buscarClientePorCpf(cpf) == null);

        Cliente cliente = cc.buscarClientePorCpf(cpf);
        
        NotaService ns = new NotaService(cliente);
        
        Produto p1;

        if(cliente != null){

            while(true){
                
                System.out.println("Insira o codigo e a quatidade do produto (ou 'sair' para finalizar....)");
                
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
                
                p1 = pc.buscarProduto(codigo);
               
                if(pc.buscarProduto(codigo) != null){
                    
                    Item item = ItemService.criarItem(p1, quantidade);
                    ns.addItem(item);
    
                }else System.out.println("Produto não encontrado");
    
    
                
            }
            
            nc.addNota(ns.getNota());
            ns.getNota().exibir();
        }else System.out.println("saindo.....");

   }
   
   public static void main(String[] args){

        ClienteController cc = new ClienteController();

        ProdutoController pc = new ProdutoController();

        NotaController nc = new NotaController();

        cc.cadastrarCliente("07252974502", "Luiz Meneses", 
                            "Luiz@gmail.com", "79996383001");

        ProdutoService ps = new ProdutoService(null, null);
        Produto p1 = ps.criarProduto("cafe", 10, 10.5f);

        pc.addProduto(p1);

        

   }
}
