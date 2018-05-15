/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escola.repositorio;

import escola.modelo.professor.Professor;
import escola.repositorio.util.FabricaConexao;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author iuryteixeira
 */
public class ProfessorRepositorio extends RepositorioGenerico {

    public ProfessorRepositorio() {
        super(Professor.class);
    }

    public void salvar(Professor professor) {
        EntityManager em = FabricaConexao.getEntityManager();
        //iniciando uma transação
        em.getTransaction().begin();

        em.persist(professor);

        em.getTransaction().commit();

        em.close();

    }

    public void atualizar(Professor professor) {

        EntityManager em = FabricaConexao.getEntityManager();
        //iniciando uma transação
        em.getTransaction().begin();

        em.merge(professor);

        em.getTransaction().commit();

        em.close();

    }

    public List<Professor> buscar(String textoBuscado) {

        Criteria c = getCriteria();

        c.add(
                Restrictions.or(
                        Restrictions.ilike("nome", textoBuscado, MatchMode.ANYWHERE),
                        Restrictions.like("cpf", textoBuscado, MatchMode.START)
                ));

        return c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

    }

    public Professor buscarPorCPF(final String cpfBuscado) {

       
        Criteria c = getCriteria();

        c.add(Restrictions.eq("cpf", cpfBuscado));

        return (Professor) c.uniqueResult();

    }

    public Professor buscarPorCPFComJPQL(final String cpfBuscado) {

        EntityManager em = FabricaConexao.getEntityManager();

        return em.createQuery("select p from Professor p where p.cpf = :doc",
                Professor.class)
                .setParameter("doc", cpfBuscado)
                .getSingleResult();

    }

    /**
     * Busca todos os professores sem restrição
     *
     * @return
     */
    public List<Professor> listarTodos() {

        EntityManager em = FabricaConexao.getEntityManager();

        Session s = (Session) em.getDelegate();

        Criteria c = s.createCriteria(Professor.class);

        return c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

    }

    /**
     * Busca apenas no campo(<i>atributo da classe</i>) nome na entidade
     * raiz<br/>
     * <b>Professor</b>
     *
     * @param nomeBuscado
     * @return
     */
    public List<Professor> buscarPorNome(String nomeBuscado) {

        EntityManager em = FabricaConexao.getEntityManager();

        Session s = (Session) em.getDelegate();

        Criteria c = s.createCriteria(Professor.class);

        c.add(Restrictions.ilike("nome", nomeBuscado, MatchMode.ANYWHERE));

        return c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

}
