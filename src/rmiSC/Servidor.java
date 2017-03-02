package rmiSC;
import java.net.URL;
import java.rmi.RMISecurityManager;
import java.rmi.registry.Registry;

public class Servidor  {
     public void  test (){


        try{

//            System.setProperty ("java.rmi.server.codebase", "file:C:/Users/Ernesto/Desktop/RMI/");

            URL url = getClass().getResource("security.policy");
            System.setProperty("java.security.policy", url.toString());
            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new RMISecurityManager());
            }
            
            
            Registry r = java.rmi.registry.LocateRegistry.createRegistry(1099);
            //ServiciosMetodos obj = new ServiciosMetodos(); 

            r.rebind("ObjetoRemoto", new ServiciosMetodos());

               
               //Naming.rebind("//localhost/ObjetoRemoto", objetoRemoto);

        }catch(Exception e){
            System.out.println("Algo fallo en el Servidor :'v");
        }
    
    }
}

