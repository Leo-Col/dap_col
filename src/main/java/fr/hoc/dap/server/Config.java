package fr.hoc.dap.server;

import org.springframework.beans.factory.annotation.Autowired;

/** Classe Config.*/
public class Config {

    /** Dossier ou sont les tokens.*/
    private static final String CREDENTIALS_FOLDER = System.getProperty("user.home") + "/dap/tokens";
    /** Dossier ou est enregisté le credentials.*/
    private static final String CLIENT_SECRET_DIR = System.getProperty("user.home") + "/dap/credentials.json";
    /** Définition du nom du projet*/
    private static final  String APPLICATION_NAME = "Data Access Project";
    /**Nom de l'application*/
    private String applicationName;
    /** Dossier Credientials*/
    private String credentialFolder;

    /** Credientials.*/
    private String clientSecretFile;

    /** Config
     * @return*/
    @Autowired
    public Config() {
        applicationName = APPLICATION_NAME;
        credentialFolder = CREDENTIALS_FOLDER;
        clientSecretFile = CLIENT_SECRET_DIR;
    }

    /** Récuperer le secret file.
     * @return Retourne au client secret.*/

    public String getClientSecretFile() {
        return clientSecretFile;
    }

    /** Etablir le client secret file.
     * @return Retourne au dossier credential
     * @param clientSecretFile1 /// */

    public void setClientSecretFile(final String clientSecretFile1) {
        this.clientSecretFile = clientSecretFile1;
    }

    /** Récupere le dossier Credential.
     * @return boubou.*/

    public String getCredentialFolder() {
        return credentialFolder;
    }

    /** Etablie le credentialfolder.
     * @return au nom de l'application
     * @param credentialFolder1 /// */
    public void setCredentialFolder(final String credentialFolder1) {
        this.credentialFolder = credentialFolder1;
    }

    /** Récupérer le nom de l'application.
     * @return vers le nom de l'application*/

    public String getApplicationName() {
        return applicationName;
    }

    /** Etablie le nom de l'application.
     * @param applicationName1 /// */

    public  void setApplicationName(final String applicationName1) {
        this.applicationName = applicationName1;
    }
    /** Récuperer l'authentification de l'utilisateur .
     * @return à l'authentification */
    public String getoAuth2CallbackUrl() {
        //TODO refactoer en utilisant ZeroConf
        return "/oAuth2Callback";
    }
}
