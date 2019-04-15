package fr.hoc.dap.server.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.gmail.GmailScopes;
import com.google.api.services.people.v1.PeopleServiceScopes;

import fr.hoc.dap.server.Config;

//TODO col by Djer |Audit Code| Prend en compte les remarques de CheckStyle !
/** Class google Service.*/
public abstract class GoogleService {

  //TODO col by Djer |JavaDoc| Cette Javadoc devrait documenter la l'ATTRIBUT, pas l'annotation.
    /**  Méthode config en "Autowired"*/
    @Autowired
    private Config conf;
  //TODO col by Djer |JavaDoc| Non ! juste un "fabrique a JSON"
     /** Identity.*/
    private static JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
  //TODO col by Djer |JavaDoc| Les token vont toujours du haut vers le bas. "directory" se traduit par "dossier"
    /** Direction Token.*/
    // private static  String tokesDirectory = "tokens";
    /** Authorisation.*/
    private static List<String> scopes;

    /**
     * Default constructor with scope initialisation.
     */
    public GoogleService() {
        /** Avoir le credential.*/
        scopes = new ArrayList<String>();
        scopes.add(GmailScopes.GMAIL_READONLY);
        scopes.add(GmailScopes.GMAIL_LABELS);
        scopes.add(CalendarScopes.CALENDAR_READONLY);
        scopes.add(PeopleServiceScopes.CONTACTS_READONLY);
    }

    /**
     *
     * @return au flow.loadCredential //TODO col by Djer |JavaDoc| Cette méthode renvoie la **valeur de retour** de la méthode getCredentials()
     * @throws IOException ///
     * @throws GeneralSecurityException ///
     * @param userKey get l'user
     */
    protected Credential getCredentials(final String userKey) throws IOException, GeneralSecurityException {
        GoogleAuthorizationCodeFlow flow = getFlow();
        
        return flow.loadCredential(userKey);
    }
    
    // Build flow and trigger user authorization request.

    /** Récuper le Flow.
     * @return au flow
     * @throws IOException ///
     * @throws GeneralSecurityException ///*/
    public GoogleAuthorizationCodeFlow getFlow() throws IOException, GeneralSecurityException {
        NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        //InputStream in = CalendarService.class.getResourceAsStream(conf.getClientSecretFile());
        File in = new java.io.File(conf.getClientSecretFile());
        InputStream targetStream = new FileInputStream(in);
        Reader targetReader = new InputStreamReader(targetStream);
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(jsonFactory, targetReader);
        
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(httpTransport, jsonFactory,
                clientSecrets, scopes)
                        .setDataStoreFactory(
                                new FileDataStoreFactory(new java.io.File(conf.getCredentialFolder())))
                        .setAccessType("offline").build();

        return flow;
    }

    /** Etablie la conf. 
     *@param cnf /// */
    public void setConf(final Config cnf) {
        this.conf = cnf;
    }

    /** Récupère le JsonFactory.
     * @return JsonFactory */
    protected JsonFactory getJsonFactory() {
        return jsonFactory;
    }

    /** Etablie le JsonFactory.
     *@param /// */
    protected void setJsonFactory(final JsonFactory jsnf) {
        GoogleService.jsonFactory = jsnf;
    }

    /** Récupère la Conf
     *@return à la conf */
    protected Config getConf() {
        return conf;
    }
}
