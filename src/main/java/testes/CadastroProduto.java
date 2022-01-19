package testes;

import dao.CategoriaDao;
import dao.ProdutoDao;
import modelo.Categoria;
import modelo.Produto;
import util.JpaUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;


public class CadastroProduto {

    public static void main(String[] args) {

        Categoria celulares = new Categoria("Celulares");
        Produto celular = new Produto("Iphone 11", "256 GB", new BigDecimal(4800), celulares);

        EntityManager em = JpaUtil.getEntityManager();

        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);

        em.getTransaction().begin();
        categoriaDao.cadastrar(celulares);
        produtoDao.cadastrar(celular);
        em.getTransaction().commit();
        em.close();
    }
}