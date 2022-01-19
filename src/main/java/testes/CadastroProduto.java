package testes;

import dao.ProdutoDao;
import modelo.Produto;
import util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class CadastroProduto {
    public static void main(String[] args) {
        Produto celular = new Produto();

        celular.setNome("Iphone 11");
        celular.setDescricao("256 GB");
        celular.setPreco(new BigDecimal(4800));

        EntityManager em = JpaUtil.getEntityManager();
        ProdutoDao dao = new ProdutoDao(em);

        em.getTransaction().begin();
        dao.cadastrar(celular);
        em.getTransaction().commit();
        em.close();
    }
}