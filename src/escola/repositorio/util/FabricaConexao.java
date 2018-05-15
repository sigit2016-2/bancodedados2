/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escola.repositorio.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Singleton
 *
 * @author iuryteixeira
 */
public class FabricaConexao {

    static private EntityManagerFactory factory
            = Persistence.createEntityManagerFactory("OrmPU");

    private FabricaConexao() {
    }

    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

    public static void close() {
        factory.close();
    }

}
