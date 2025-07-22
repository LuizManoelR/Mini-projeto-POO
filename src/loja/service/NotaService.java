package loja.service;

import loja.model.Cliente;
import loja.model.Item;
import loja.model.Produto;
import loja.model.Nota;

public class NotaService {
    
    private Nota nota;

    public NotaService(Nota nota){

        this.nota = nota;
    }

    private int procurarIndexItem(Item item){
        
        for(int i = 0; i < nota.getTamanho(); i++){

            if(nota.getCarrinho()[i].equals(item)){
                
                return i;

            }
            
        }

        return -1;

    }

    private void redimensionarCarrinho(){

        Item[] aux = new Item[nota.getTamanho() + 10];

        for(int i = 0; i < nota.getCarrinho().length ; i++){

            aux[i] = nota.getCarrinho()[i];

        }

        nota.setCarrinho(aux);

    }

    public void addItem(Item item){

        if(item.getProduto().getEstoque() > 0){
           
            int index = procurarIndexItem(item);

            if(nota.getTamanho() == nota.getCarrinho().length){

                redimensionarCarrinho();

            }

            if(index == -1){

                nota.getCarrinho()[nota.getTamanho()] = item;

                nota.setTamanho(nota.getTamanho()+1);

        }else{

            ItemService.atualizarQuantidade(nota.getCarrinho()[index],
                                            nota.getCarrinho()[index].getQuantidade() + 
                                            item.getQuantidade());

            }
        
        }else{

            System.out.println("Produto sem estoque");

        }


    }

    public void addItem(Produto produto, int qtd){

        Item item = ItemService.criarItem(produto, qtd);

        addItem(item);


    }

    public void addItem(Item[] itens){

        for(int i = 0; i < itens.length; i++){

            addItem(itens[i]);

        }

    }

    public void removeItem(Item item){

        for(int i = 0; i < nota.getTamanho(); i++){

            if(nota.getCarrinho()[i].equals(item)){
                
                if(nota.getCarrinho()[i].getQuantidade() - item.getQuantidade() > 0){

                    ItemService.atualizarQuantidade(nota.getCarrinho()[i],
                                                    nota.getCarrinho()[i].getQuantidade()
                                                    -item.getQuantidade());
                    return;

                }else{

                    for(int j = i; j < nota.getTamanho(); j++){

                        nota.setCarrinho(j ,nota.getCarrinho()[j+1]);

                    }

                    nota.setTamanho(nota.getTamanho()-1);
                    return;

                }

            } 

        }

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

        Item i1 = ItemService.criarItem(p1,2);
        Item i2 = ItemService.criarItem(p2,2);

        i1.exibir();
        i2.exibir();

        Nota n1 = new Nota(c1);

        NotaService ns = new NotaService(n1);

        ns.addItem(i1);
        ns.addItem(i2);
       

        n1.exibir();


    }

}
