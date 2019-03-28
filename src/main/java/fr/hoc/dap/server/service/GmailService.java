
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

/** Maintada.*/
@Service
public final class GmailService extends GoogleService {


    /**
    * @throws GeneralSecurityException dodo.
    * @throws IOException fdjçoj
    * @return GeneralSecurityException yes.
    * @param userKey get l'user
    */
    protected Gmail getService(final String userKey) throws GeneralSecurityException, IOException {
     // Build a new authorized API client service.

        final NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        return new Gmail.Builder(httpTransport, getJsonFactory(), getCredentials(userKey))
                .setApplicationName(getConf().getApplicationName()).build();


    }

    /**
     *
     * @param userKey get l'user.
     * @throws IOException dodo.
     * @throws GeneralSecurityException yes.
     * @return fjdkfl
     */
    public Integer countNbUnreadMessages(final String userKey) throws IOException, GeneralSecurityException {
        Gmail service = getService(userKey);
        String userId = "me";
        String query = "is:unread";

        List<Message> unreadMessages = listMessagesMatchingQuery(service, userId, query);
        //getNextevent(args);

        return unreadMessages.size();

    }

    /**
     *
     * @param service dada.
     * @param userId Yo.
     * @param query yes.
     * @return Ford.
     * @throws IOException souple.
     */
    public List<Message> listMessagesMatchingQuery(final Gmail service, final String userId, final String query)
            throws IOException {
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

        return messagesId;
    }



}
