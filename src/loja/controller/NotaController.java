package loja.controller;

import loja.model.Cliente;
import loja.model.Item;
import loja.model.Nota;
import loja.model.Produto;
import loja.service.ItemService;
import loja.service.NotaService;
import loja.service.ProdutoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class NotaController {
        
        // atributos

        private List<Nota> notas;

        // construtor;
        public NotaController(){notas = new ArrayList<>();}
            
        //Cria uma Nota
        public Nota criarNota(Cliente cliente){
            
            return new Nota(cliente);
            
        }
        
        //Busca a nota nas notas registradas e a retorna
        public Optional<Nota> buscarNotaPorCodigo(String codigo){

            if (codigo == null || codigo.trim().isEmpty()) {
            System.out.println("Erro: Código não pode ser nulo ou vazio");
            
                return Optional.empty();

            }

            for (Nota nota : notas){
                if (nota.getCodigo().equals(codigo.trim())){
                    return Optional.of(nota); // se encontrar, retorna o produto
                }
            }
            return Optional.empty();
        }

        public void exibirNota(String codigo){

            buscarNotaPorCodigo(codigo).ifPresentOrElse(nota -> nota.exibir(),
                                                        () -> System.out
                                                        .println("Nota fiscal não encontrada...."));


        }

        public void exibirNotasRegistradas(){

            for(int i = 0; i < notas.size(); i++ ){

                notas.get(i).exibir();

            }

        }

        // add nota
        public void addNota(Nota nota){
            
            notas.add(nota);
        }


        public boolean removeNota(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            System.out.println("Erro: Código não pode ser nulo ou vazio");
            return false;
        }

        // Percorre a lista procurando o produto
        for (int i = 0; i < notas.size(); i++) {
            if (notas.get(i).getCodigo().equals(codigo.trim())) {
                Nota notaRemovida = notas.get(i);
                notas.remove(i);
                System.out.println("Produto removido com sucesso: " + notaRemovida.getCodigo()+"\n");
                return true;
            }
        }

        System.out.println("Produto com ID " + codigo + " não encontrado");
        return false;
    }



        public static void main(String[] args){

        ProdutoService ps = new ProdutoService(null, null);

        Produto p1 = ps.criarProduto("cafe", 10, 10.5f);
        Produto p2 = ps.criarProduto("arroz", 10, 25.5f);
        
        Cliente c1 = new Cliente(  
                                "07252974502", 
                                "Nathalie Calixto", 
                                "luiznmeneses@gmail.com", 
                                "79996383001");

        p1.exibir();
        p2.exibir();

        Item i1 = ItemService.criarItem(p1,20);
        Item i2 = ItemService.criarItem(p2,2);

        i1.exibir();
        i2.exibir();

        Nota n1 = new Nota(c1);

        NotaService ns = new NotaService(n1);

        ns.addItem(i1);
        ns.addItem(i2);
       

        n1.exibir();

        NotaController nc = new NotaController();

        nc.addNota(n1);

        nc.exibirNota("NF0001");
        
        nc.removeNota("NF0001");
        
        nc.exibirNota("NF0001");
        }
    
}
