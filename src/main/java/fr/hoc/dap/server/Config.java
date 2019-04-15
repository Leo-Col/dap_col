package fr.hoc.dap.server;

import org.springframework.beans.factory.annotation.Autowired;

/** Classe Config.*/
public class Config {

    /** Dossier ou sont les tokens.*/
    private static final String CREDENTIALS_FOLDER = System.getProperty("user.home") + "/dap/tokens";
    /** Dossier ou est enregisté le credentials.*/
    private static final String CLIENT_SECRET_DIR = System.getProperty("user.home") + "/dap/credentials.json";
    /** Définition du nom du projet*/
    private static final String APPLICATION_NAME = "Data Access Project";
    /**Nom de l'application*/
    private String applicationName;
    /** Dossier Credientials*/
    private String credentialFolder;

    //TODO col by Djer |JavaDoc| Pas très claire. "Emplacment du fichier d'authentification de l'application pour Google Dev" serait mieux.
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

    //TODO col by Djer |JavaDoc| CheckStyle t'indique que ta méthode n'a plus de valeur de retour.
    /** Etablir le client secret file.
     * @return Retourne au dossier credential
     * @param clientSecretFile1 /// */

    public void setClientSecretFile(final String clientSecretFile1) {
        this.clientSecretFile = clientSecretFile1;
    }

    ////TODO col by Djer |JavaDoc| "bouhou" est une ville de Gironde et s'écrit avec une Majuscule. Es-tu sur que cette méthode renvoie vers cette ville ? 
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

    //TODO col by Djer |JavaDoc| Cette méthode, renvoie un String (chaine de caractères), elle ne renvoie pas "vraiment" VERS quelque-chose. Pour la JavaDoc des getter, la description et la valeur de retour ont souvent une description très simillaire.
    /** Récupérer le nom de l'application.
     * @return vers le nom de l'application*/

    public String getApplicationName() {
        return applicationName;
    }

    /** Etablie le nom de l'application.
     * @param applicationName1 /// */

    public void setApplicationName(final String applicationName1) {
        this.applicationName = applicationName1;
    }

    //TODO col by Djer |JavaDoc| Ici OAuth2CallBack est l'URL sur laquelle Google va pulbier le Tken SI l'utilsiateur accepte des scopes demandé.
    /** Récuperer l'authentification de l'utilisateur .
     * @return à l'authentification */
    public String getoAuth2CallbackUrl() {
        //TODO refactorer en utilisant ZeroConf
        return "/oAuth2Callback";
    }
}
