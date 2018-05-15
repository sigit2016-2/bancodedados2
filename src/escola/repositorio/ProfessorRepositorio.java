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
public class ProfessorRepositorio {

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

    public List<Professor> buscarPorNome(String nomeBuscado) {

        EntityManager em = FabricaConexao.getEntityManager();

        Session s = (Session) em.getDelegate();

        Criteria c = s.createCriteria(Professor.class);

        c.add(Restrictions.ilike("nome", nomeBuscado, MatchMode.ANYWHERE));

        return c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

}
