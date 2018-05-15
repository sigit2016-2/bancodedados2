/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escola.repositorio;

import escola.modelo.disciplina.Disciplina;
import escola.repositorio.util.FabricaConexao;
import javax.persistence.EntityManager;

/**
 *
 * @author iuryteixeira
 */
public class DisciplinaRepositorio {

    public void salvar(Disciplina disciplina) {

        EntityManager em = FabricaConexao.getEntityManager();
        //iniciando uma transação
        em.getTransaction().begin();

        em.persist(disciplina);

        em.getTransaction().commit();

        em.close();

    }

}
