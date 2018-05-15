/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escola.repositorio;

import escola.modelo.professor.Professor;
import escola.repositorio.util.FabricaConexao;
import javax.persistence.EntityManager;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author iuryteixeira
 */
public abstract class RepositorioGenerico {

    private Class type;

    public RepositorioGenerico(Class type) {
        this.type = type;
    }

    protected Criteria getCriteria() {
        EntityManager em = FabricaConexao.getEntityManager();

        Session s = (Session) em.getDelegate();

        Criteria c = s.createCriteria(type);
        return c;
    }

}
