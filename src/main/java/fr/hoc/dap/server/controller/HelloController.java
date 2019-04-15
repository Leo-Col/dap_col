package fr.hoc.dap.server.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.hoc.dap.server.service.CalendarService;
import fr.hoc.dap.server.service.GmailService;

//TODO col by Djer |JavaDoc| Cette Javadoc devrait documenter la CLASSE, pas l'annotation.
/** Classe en "RestController". */
@RestController
public class HelloController {
  //TODO col by Djer |JavaDoc| "Acces to DaP Google Calendar Services" serait mieux
    /** l'automobile.*/
    @Autowired
    private CalendarService calendarService;

  //TODO col by Djer |JavaDoc| "Acces to DaP Google mail services" serait mieux
    /** l'automobile.*/
    @Autowired
    private GmailService gmService;

  //TODO col by Djer |JavaDoc| "Salut l'utilsiateur" serait mieux
  //TODO col by Djer |JavaDoc| Pour le return "Salutation en Anglais" serait mieux
    /** Test Hello.
     * @return Retourne en hello  */
    @RequestMapping("/hello")
    public String index() {
        return "Hello !";
    }

  //TODO col by Djer |JavaDoc| Pour le return "Salutation en Français" serait mieux
    /** Récuperer un bonjour.
     * @param theName Demande le nom //TODO col by Djer |JavaDoc| Ne fait pas de "demande", mais contient déja une "réponse" (préallablement demandé)
     * @return Retourne à bonjour + le nom
     */
    @RequestMapping("/bonjour")
    public String direBonjour(@RequestParam("name") final String theName) {
        return "Bonjour " + theName;
    }

  //TODO col by Djer |JavaDoc| "Affiche le nombre d'email non lus dans la boite principal." serait mieux
    /** Récuperer les mails.
     * //TODO col by Djer |JavaDoc| N'essaye de décrire ce que cela fait, cela est déja parfaitement décris en JAVA. Donne une indication sur "quoi faire" de ce se retour (ce que c'est)
     * @return retourne au gmService //TODO col by Djer |Java| Non ! Retourne la valeur de retour de la méthode "countNbUnreadMessages" appelé sur (une instance) du GmailService. 
     * @throws GeneralSecurityException ///
     * @throws IOException ///
     *  //TODO col by Djer |JavaDoc| "Identifiant de l'utilsiateur DaP pour lequel récupérer les informations" serait mieux.
     * @param userKey get l'user */
    @RequestMapping("/email/nb")
    public Integer email(@RequestParam("userKey") final String userKey) throws IOException, GeneralSecurityException {
        return gmService.countNbUnreadMessages(userKey);
    }

    /** Récuperer le next event.
     * @return retourne vers le calendarService
     * @throws GeneralSecurityException ///
     * @throws IOException ///
     * @param userKey get l'user*/
    @RequestMapping("/event/next")
    public String calandar(@RequestParam("userKey") final String userKey) throws IOException, GeneralSecurityException {
        return calendarService.calendrier(userKey);
    }

}
