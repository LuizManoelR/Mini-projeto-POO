package loja.service;

import loja.model.Cliente;
import loja.model.Item;
import loja.model.Produto;

public class ItemService {
    //valida se os parametros para construir um item estão corretos e retorna um item
    public static Item criarItem(Produto Produto, int qtd){

        if(qtd > 0){

            if(qtd < Produto.getEstoque()){
                
                Produto.setEstoque(Produto.getEstoque() - qtd);
                return new Item(Produto, qtd);
            }else{
                qtd = Produto.getEstoque();
                System.out.printf("Estoque insuficiente, %s possui %d unidades\n",Produto.getNome(), Produto.getEstoque());
                Produto.setEstoque(0);
                return new Item(Produto, qtd); 

            }

        }else throw new IllegalArgumentException("Quantidade deve ser maior que zero");

    }
    //atualiza a quantidade de um item apos validar os parametros passados
    public static void atualizarQuantidade(Item item,int qtd){
        
        if(qtd > 0){

           
        if(item.getProduto().getEstoque() == 0){item.getProduto().setEstoque(item.getQuantidade());}
        
        if(qtd <= item.getProduto().getEstoque()){
                item.getProduto().setEstoque(item.getProduto().getEstoque() - qtd);
                item.setQuantidade(qtd);

            
        
        }else{

            item.setQuantidade(item.getProduto().getEstoque()); 
            item.getProduto().setEstoque(0);
            System.out.printf("Estoque insuficiente, %s possui %d unidades\n",
            item.getProduto().getNome(),item.getProduto().getEstoque());

        }

        }

        
    }

     public static void main(String [] args){

        ProdutoService ps = new ProdutoService(null, null);

        Produto p1 = ps.criarProduto("cafe", 10, 10.5f);
        Produto p2 = ps.criarProduto("arroz", 10, 25.5f);
        
        p1.exibir();
        //p2.exibir();

        Item i1 = ItemService.criarItem(p1,20);
        Item i2 = ItemService.criarItem(p2,2);
        i1.exibir();
       //i2.exibir();

        p1.exibir();
        //p2.exibir();


        ItemService.atualizarQuantidade(i1,8);

        i1.exibir();
        //i2.exibir();

        p1.exibir();
        //p2.exibir();

    }




}
