package loja.service;

import loja.model.Item;
import loja.model.Produto;

public class ItemService {
    //valida se os parametros para construir um item estão corretos e retorna um item
    public static Item criarItem(Produto Produto, int qtd){

        if(qtd > 0){

            if(qtd <= Produto.getEstoque()){
            
                return new Item(Produto, qtd);
            }else{

                System.out.printf("Estoque insuficiente, %s possui %d unidades\n",Produto.getNome(), Produto.getEstoque());
                return new Item(Produto, Produto.getEstoque()); 

            }

        }else throw new IllegalArgumentException("Quantidade deve ser maior que zero");

    }
    //atualiza a quantidade de um item apos validar os parametros passados
    public static void atualizarQuantidade(Item item,int qtd){
        
        if(qtd > 0){

           
        if(qtd <= item.getProduto().getEstoque()){
           
            item.setQuantidade(qtd);
        
        }else{

            item.setQuantidade(item.getProduto().getEstoque()); 
            System.out.printf("Estoque insuficiente, %s possui %d unidades\n",item.getProduto().getNome(),item.getProduto().getEstoque());

        }

        }
        
    }

     public static void main(String [] args){

  

    }




}
