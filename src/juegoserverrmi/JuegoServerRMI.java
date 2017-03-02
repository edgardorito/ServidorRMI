/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegoserverrmi;

import hibernate.Preguntas;
import hibernate.Score;
import hibernate.Usuario;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import persistencia.DAOPreguntas;
import persistencia.DAOUsuarios;

/**
 *
 * @author UPChiapas
 */
public class JuegoServerRMI extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*DAOUsuarios usuariosDAO = new DAOUsuarios(); 
        Usuario usuario1 = new Usuario("Usuarios 6", "uno"); 
        
        try {
            usuariosDAO.guardaUsuarios(usuario1);
        } catch (Exception e) {
            System.out.println("El usuario: "+e.getMessage());
        }
*/

        /*
        DAOUsuarios usuariosDAO = new DAOUsuarios(); 
        Usuario usuario = new Usuario();
        
        
        Score score1 = new Score("Usuarios 1", 10); 
        Score score2 = new Score("Usuarios 2", 20); 
        Score score3 = new Score("Usuarios 3", 30);  
 
        
        //Modificamos el contacto 2 y lo actualizamos 
        usuario.setUsuario("Nuevo nombre del usuario 2 "); 
        usuariosDAO.actualizaContacto(usuario);  

       Creamos tes instancias de Usuarios 
        Usuario usuario1 = new Usuario("Usuarios 1", "uno"); 
        Usuario usuario2 = new Usuario("Usuarios 2", "dos"); 
        Usuario usuario3 = new Usuario("Usuarios 3", "tres");  

        //Guardamos las tres instancias, guardamos el id del contacto1 para usarlo posteriormente 
        usuariosDAO.guardaUsuarios(usuario1); 
        usuariosDAO.guardaUsuarios(usuario2); 
        usuariosDAO.guardaUsuarios(usuario3);  
        
        //Obtenemos la lista de contactos que quedan en la base de datos y la mostramos 
        List<Usuario> listaUsuarios = usuariosDAO.obtenListaUsuarios();
        //System.out.println("Hay " + listaUsuarios.size() + "contactos en la base de datos");

        for (Usuario c : listaUsuarios) {
            System.out.println("-> " + c.getUsuario());
        }
        */
        launch(args);
    }
    
}
