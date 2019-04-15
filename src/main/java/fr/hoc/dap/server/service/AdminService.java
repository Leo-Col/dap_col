/**
 * 
 */
package fr.hoc.dap.server.service;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.springframework.stereotype.Service;

import com.google.api.client.auth.oauth2.StoredCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.util.store.DataStore;

//TODO col by Djer |Audit Code| Prend en compte les remarques de CheckStyle !
//TODO col by Djer |JavaDoc| Cette Javadoc devrait documenter la CLASSE, pas l'annotation.
/** Classe AdminService en "Service"
 */
@Service
public class AdminService extends GoogleService {
    
    public DataStore<StoredCredential> getDataStore() throws IOException, GeneralSecurityException {
        GoogleAuthorizationCodeFlow flow = getFlow();
    
    return flow.getCredentialDataStore();
    
   
    }


}
