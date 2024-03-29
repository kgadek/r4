package server;

import implemented.laboratory.LaboratoryFactoryI;

import java.io.IOException;

import Ice.Application;
import evictor.ServantEvictor;

public class Server extends Application {

  @Override
  public int run(String[] args) {
    try {
      Ice.ObjectAdapter adapter = communicator().createObjectAdapter("LaboratoryFactory");
//      Ice.PluginManager pluginMgr = communicator().getPluginManager();
//      Ice.Plugin plugin = pluginMgr.getPlugin("IceSSL");
//      IceSSL.Plugin sslPlugin = (IceSSL.Plugin)plugin;
//      sslPlugin.setCertificateVerifier(new CertVerifier());

      ServantEvictor evictor = new ServantEvictor(2);

      adapter.add(new LaboratoryFactoryI(this, adapter, evictor), communicator().stringToIdentity("laboratoryFactory"));

      adapter.addServantLocator(evictor, "");
      adapter.activate();
      communicator().waitForShutdown();
    } catch (IOException e) {
      System.out.println("IOException");
    }
    return 0;
  }

  public static void main(String[] args) {
    Server app = new Server();
    int status = app.main("Server", args, "config.server");
    System.exit(status);
  }
}
