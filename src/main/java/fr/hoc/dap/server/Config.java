package fr.hoc.dap.server;

import org.springframework.beans.factory.annotation.Autowired;

/** tatata.*/
public class Config {

    /** tatata.*/
    private static final String CREDENTIALS_FOLDER = System.getProperty("user.home") + "/tokens";
    /** tatata.*/
    private static final String CLIENT_SECRET_DIR = System.getProperty("user.home") + "/dap/credentials.json";
    /** tatata.*/
    private static final  String APPLICATION_NAME = "Data Access Project";
    /** tatata.*/
    private String applicationName;
    /** tatata.*/
    private String credentialFolder;

    /** tatata.*/
    private String clientSecretFile;

    /** tatata.
     * @return*/
    @Autowired
    public Config() {
        applicationName = APPLICATION_NAME;
        credentialFolder = CREDENTIALS_FOLDER;
        clientSecretFile = CLIENT_SECRET_DIR;
    }

    /** tatata.
     * @return blalb.*/

    public String getClientSecretFile() {
        return clientSecretFile;
    }

    /** tatata.
     * @return
     * @param clientSecretFile1 patatae */

    public void setClientSecretFile(final String clientSecretFile1) {
        this.clientSecretFile = clientSecretFile1;
    }

    /** tatata.
     * @return boubou.*/

    public String getCredentialFolder() {
        return credentialFolder;
    }

    /** tatata.
     * @return
     * @param credentialFolder1 patatae */
    public void setCredentialFolder(final String credentialFolder1) {
        this.credentialFolder = credentialFolder1;
    }

    /** tatata.
     * @return balal*/

    public String getApplicationName() {
        return applicationName;
    }

    /** tatata.
     * @return
     * @param applicationName1 patatae */

    public  void setApplicationName(final String applicationName1) {
        this.applicationName = applicationName1;
    }
    /** Avoir le credential.
     * @return dkfi*/
    public String getoAuth2CallbackUrl() {
        //TODO refactoer en utilisant ZeroConf
        return "/oAuth2Callback";
    }
}
