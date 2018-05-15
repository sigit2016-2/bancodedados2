/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escola.repositorio;

import escola.modelo.disciplina.Disciplina;
import escola.repositorio.util.FabricaConexao;
import javax.persistence.EntityManager;
import org.hibernate.Criteria;

/**
 *
 * @author iuryteixeira
 */
public class DisciplinaRepositorio extends RepositorioGenerico {

    public DisciplinaRepositorio() {
        super(Disciplina.class);
    }

    public void salvar(Disciplina disciplina) {

        EntityManager em = FabricaConexao.getEntityManager();
        //iniciando uma transação
        em.getTransaction().begin();

        em.persist(disciplina);

        em.getTransaction().commit();

        em.close();

    }

    public Disciplina buscar() {
        Criteria c = getCriteria();
        
        
        
        return null;
    }

}
