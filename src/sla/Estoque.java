
package sla;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author ydebo
 */
//**************************************************QUESTÃO 01**************************************************
public class Estoque {
//**************************************************QUESTÃO 09**************************************************
    List<Produto> listadeProdutos = new ArrayList<>();
/**
 * 
 * @param produto 
 */
    public void cadastrarProduto(Produto produto) {
        listadeProdutos.add(produto);
    }
/**
 * 
 * @param a 
 */
    public void removerProdutos(Produto a) {
        listadeProdutos.remove(a);
    }
/**
 * 
 * @return 
 */
    public List<Produto> getListadeProdutos() {
        return listadeProdutos;
    }
/**
 * 
 * @param listadeProdutos 
 */
    public void setListadeProdutos(List<Produto> listadeProdutos) {
        this.listadeProdutos = listadeProdutos;
    }
    /**
     * 
     * @param novoProduto 
     */
    
    public void adicionarProduto(Produto novoProduto) {
        listadeProdutos.add(novoProduto);
    }
/**
 * Q13
 * @param id
 * @return 
 */
    public Produto getProdutoId(int id) {
        return listadeProdutos.get(id);
    }
//**************************************************QUESTÃO 13**************************************************
//**************************************************QUESTÃO 16**************************************************
    public void comparaPreco(){

        Collections.sort(listadeProdutos, new Comparator<Produto>() {
            @Override
            public int compare(Produto produto1, Produto produto2) {
                return Double.compare(produto1.getPreco(), produto2.getPreco());
            }
        });
    }

//**************************************************QUESTÃO 03**************************************************

    @Override
    public String toString() {
        return "Estoque{" + "listadeProdutos=" + listadeProdutos + '}';
    }

}
