
package fr.hoc.dap.server.service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.Events;



//TODO col by Djer |Audit Code| Prend en compte les remarques de CheckStyle !
//TODO col by Djer |JavaDoc| Cette Javadoc devrait documenter la CLASSE, pas l'annotation.
/** Calendrier.*/
@Service
public final class CalendarService extends GoogleService {


    /** Récuperer le service Calendrier.
     * @return au service
     * @throws GeneralSecurityException  ///
     * @throws IOException ///
     * @param userKey get l'user */
    //TODO col by Djer |Java| Renome en "buildService" pourait clarifier
    protected Calendar getService(final String userKey) throws GeneralSecurityException, IOException {

        final NetHttpTransport httptransport = GoogleNetHttpTransport.newTrustedTransport();
        Calendar service = new Calendar.Builder(httptransport, getJsonFactory(), getCredentials(userKey))
                .setApplicationName(getConf().getApplicationName()).build();

        return service;
    }

    /** Calendar.*/
    /**
     * @param userKey get l'user.
     * @throws IOException ///.
     * @throws GeneralSecurityException ///.
     * @return ///
     */
  //TODO col by Djer |Java| "retrieveNextEvent" serait plus claire comme nom de de méthode.
    public String calendrier(final String userKey) throws IOException, GeneralSecurityException {
      //TODO col by Djer |Log4J| Une petite Log ? "Searching for next Event for user " + userkey
        // Build a new authorized API client service.
      //TODO col by Djer |Java| Nom de variable pas très claire.
        String toto = "";
        // List the next 10 events from the primary calendar.
        Calendar service = getService(userKey);
        DateTime now = new DateTime(System.currentTimeMillis());
        Events events = service.events().list("primary").setMaxResults(1).setTimeMin(now).setOrderBy("startTime")
                .setSingleEvents(true).execute();
        List<Event> items = events.getItems();
        if (items.isEmpty()) {
          //TODO col by Djer |Command Line| Pa de SysOut sur un serveur !
            System.out.println("Aucun évènement programmé.");
            toto = "Pas d'évènement";
        } else {
            for (Event event : items) {
                DateTime start = event.getStart().getDateTime();
                if (start == null) {
                    start = event.getStart().getDate();
                }
                System.out.println("Aucun évènement programmé.");
                System.out.printf("%s (%s)\n", event.getSummary(), start);
                toto = event.getSummary() + "" + start;
            }
        }

      //TODO col by Djer |Log4J| Une petite Log ? "Found event " + toto " for user : " + userkey

        return toto;
    }
}
