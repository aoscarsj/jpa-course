package testes;

import modelo.Produto;

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

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("loja");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        em.persist(celular);
        em.getTransaction().commit();
        em.close();
    }
}
