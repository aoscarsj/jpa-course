package testes;

import dao.ProdutoDao;
import modelo.Categoria;
import modelo.Produto;
import util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class CadastroProduto {
    public static void main(String[] args) {
        Produto celular = new Produto("Iphone 11", "256 GB", new BigDecimal(4800), Categoria.CELULARES);

        EntityManager em = JpaUtil.getEntityManager();
        ProdutoDao dao = new ProdutoDao(em);

        em.getTransaction().begin();
        dao.cadastrar(celular);
        em.getTransaction().commit();
        em.close();
    }
}