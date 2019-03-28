
package fr.hoc.dap.server;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/** .*/
abstract class Start {

    /**
    *
    * @param args j'argumente.
    * @throws IOException c'est exept.
    * @throws GeneralSecurityException boug ons.
    */
   private static final Logger LOG = LogManager.getLogger();

   /**
   *
   * @param args j'argumente.
   * @throws IOException c'est exept.
   * @throws GeneralSecurityException boug ons.
   */
    public static void main(final String[] args) throws IOException, GeneralSecurityException {

        LOG.info("Pain de mie");
        LOG.error("Ceci est une escarmouche");
        Config myConfig = new Config();

        System.out.println(myConfig.getApplicationName());


        LOG.info("Dossier du Credentials : " + myConfig.getClientSecretFile());
        LOG.info("Le nom de l'application : " + myConfig.getApplicationName());
    }

}
