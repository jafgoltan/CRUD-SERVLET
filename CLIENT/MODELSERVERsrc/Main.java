import model.service.PersonServiceImpl;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Main {
    public static void main(String[] args)throws Exception {
        LocateRegistry.createRegistry(1099);
        Naming.rebind("personService", PersonServiceImpl.getInstance());
    }
}
