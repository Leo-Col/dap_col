
package fr.hoc.dap.server.service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.ListMessagesResponse;
import com.google.api.services.gmail.model.Message;

//TODO col by Djer |Audit Code| Prend en compte les remarques de CheckStyle !

/** Classe GmailService en "Service".*/
@Service
public final class GmailService extends GoogleService {


    /** Récupère le sercice Gmail
    * @throws GeneralSecurityException ///
    * @throws IOException ///
    * @return GeneralSecurityException ///
    * @param userKey get l'user
    */
  //TODO col by Djer |Java| Renome en "buildService" pourait clarifier
    protected Gmail getService(final String userKey) throws GeneralSecurityException, IOException {
     // Build a new authorized API client service.

        final NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        return new Gmail.Builder(httpTransport, getJsonFactory(), getCredentials(userKey))
                .setApplicationName(getConf().getApplicationName()).build();


    }

    /** Compte le nombre de messages non lus 
     * @param userKey get l'user.
     * @throws IOException ///
     * @throws GeneralSecurityException ///
     * @return au messages non lus
     */
    public Integer countNbUnreadMessages(final String userKey) throws IOException, GeneralSecurityException {
        Gmail service = getService(userKey);
        String userId = "me";
        String query = "is:unread";

        List<Message> unreadMessages = listMessagesMatchingQuery(service, userId, query);
        //getNextevent(args);

        return unreadMessages.size();

    }

    /** Récupère la liste des messages
     * @param service ///
     * @param userId ///
     * @param query ///
     * //TODO col by Djer |JavaDoc| Décidement tu es passionné par les voitures !
     * @return Ford ///
     * @throws IOException ///
     */
    //TODO col by Djer |Java| Devrait être privé, auncune autre classe n'en a besoin.
    public List<Message> listMessagesMatchingQuery(final Gmail service, final String userId, final String query)
            throws IOException {
        //TODO col by Djer |Log4J| Une petite Log ? "Searching for messages for user " + userId + " matching filter : " + query
        ListMessagesResponse response = service.users().messages().list(userId).setQ(query).execute();

        List<Message> messagesId = new ArrayList<Message>();
        while (response.getMessages() != null) {

            messagesId.addAll(response.getMessages());

            if (response.getNextPageToken() != null) {
                String pageToken = response.getNextPageToken();
                response = service.users().messages().list(userId).setQ(query).setPageToken(pageToken).execute();
            } else {
                break;
            }
        }

        //System.out.println(messagesId.size());

      //TODO col by Djer |Log4J| Une petite Log ? "Found + messagesId.size() + " message(s) for user " + userId +
        return messagesId;
    }



}
