package fr.hoc.dap.server.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

/** Héritage.*/

public abstract class GoogleService {

    /**  des classes.*/
    @Autowired
    private Config conf;
    //    private Config conf;

    /** Identity.*/
    // protected static final String APPLICATION_NAME = "Data Access Project";
    /** Identity.*/
    private static JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
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
     * @return fvff
     * @throws IOException fgfg
     * @throws GeneralSecurityException zd
     * @param userKey get l'user
     */
    protected Credential getCredentials(final String userKey) throws IOException, GeneralSecurityException {
        GoogleAuthorizationCodeFlow flow = getFlow();
        return flow.loadCredential(userKey);
    }

    // Build flow and trigger user authorization request.

    /** Avoir le credential.
     * @return fkg
     * @throws IOException ojfo
     * @throws GeneralSecurityException ffkj*/
    public GoogleAuthorizationCodeFlow getFlow() throws IOException, GeneralSecurityException {
        NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        InputStream in = CalendarService.class.getResourceAsStream(conf.getClientSecretFile());
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(jsonFactory, new InputStreamReader(in));
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(httpTransport, jsonFactory,
                clientSecrets, scopes)
                        .setDataStoreFactory(
                                new FileDataStoreFactory(new java.io.File(conf.getCredentialFolder())))
                        .setAccessType("offline").build();

        return flow;
    }

    /** Identity.
     *@param cnf baoof */
    public void setConf(final Config cnf) {
        this.conf = cnf;
    }

    /** Identity.
     * @return ddad */
    protected JsonFactory getJsonFactory() {
        return jsonFactory;
    }

    /** Identity.
     *@param jsnf dad*/
    protected void setJsonFactory(final JsonFactory jsnf) {
        GoogleService.jsonFactory = jsnf;
    }

    /** Identity.
     *@return cnf baoof */
    protected Config getConf() {
        return conf;
    }
}
