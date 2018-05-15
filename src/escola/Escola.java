/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escola;

import escola.modelo.professor.Professor;
import escola.modelo.professor.Titulo;
import escola.repositorio.ProfessorRepositorio;
import escola.repositorio.util.FabricaConexao;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author iuryteixeira
 */
public class Escola {

    static private ProfessorRepositorio professorRepositorio
            = new ProfessorRepositorio();
    static String nomes = "";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final String search = "And";
        List<Professor> professores
                = professorRepositorio.buscarPorNome(search);

        professores.forEach((prof) -> {
            nomes += " - " + prof.getNome().replace(search, 
                    "<b>"+search+"</b>") + "\n";
            for (Titulo titulo : prof.getTitulos()) {
                nomes += " -- " + titulo.getNivel() + "\n";
            }
        });

        JOptionPane.showMessageDialog(null, nomes);

        FabricaConexao.close();
    }

    /*
        Professor professor = new Professor();

        professor.setCodigo(new Integer(
                JOptionPane.showInputDialog("Codigo")));
        professor.setNome(JOptionPane.showInputDialog("Nome"));
        professor.setCpf(JOptionPane.showInputDialog("CPF"));

        List<Titulo> titulos = new ArrayList<>();

        Titulo titulo = new Titulo();
        titulo.setCurso(JOptionPane.showInputDialog("Curso"));

        switch (JOptionPane.showInputDialog("Nivel")) {
            case "G":
                titulo.setNivel(Nivel.GRADUADO);
                break;
            case "E":
                titulo.setNivel(Nivel.ESPECIALISTA);
                break;
            case "M":
                titulo.setNivel(Nivel.MESTRE);
                break;
            case "D":
                titulo.setNivel(Nivel.DOUTOR);
                break;
            case "P":
                titulo.setNivel(Nivel.PHD);
                break;
        }

        titulos.add(titulo);
        professor.setTitulos(titulos);
        salvarProfessor(professor);
        JOptionPane.showMessageDialog(null, "Funfou!");
     */
    //factory.close();
    /*
    public static void buscarPorIdAtualizando(Integer id) {

        EntityManager em = factory.createEntityManager();

        Professor p = em.find(Professor.class, id);

        em.close();

        if (p.getTitulos() == null) {
            p.setTitulos(new ArrayList<>());
        }

        Titulo titulo = new Titulo();
        titulo.setCurso(JOptionPane.showInputDialog("Curso"));

        switch (JOptionPane.showInputDialog("Nivel")) {
            case "G":
                titulo.setNivel(Nivel.GRADUADO);
                break;
            case "E":
                titulo.setNivel(Nivel.ESPECIALISTA);
                break;
            case "M":
                titulo.setNivel(Nivel.MESTRE);
                break;
            case "D":
                titulo.setNivel(Nivel.DOUTOR);
                break;
            case "P":
                titulo.setNivel(Nivel.PHD);
                break;
        }
        p.getTitulos().add(titulo);

        titulo = new Titulo();
        titulo.setCurso(JOptionPane.showInputDialog("Curso"));

        switch (JOptionPane.showInputDialog("Nivel")) {
            case "G":
                titulo.setNivel(Nivel.GRADUADO);
                break;
            case "E":
                titulo.setNivel(Nivel.ESPECIALISTA);
                break;
            case "M":
                titulo.setNivel(Nivel.MESTRE);
                break;
            case "D":
                titulo.setNivel(Nivel.DOUTOR);
                break;
            case "P":
                titulo.setNivel(Nivel.PHD);
                break;
        }
        p.getTitulos().add(titulo);

    }
     */
}
