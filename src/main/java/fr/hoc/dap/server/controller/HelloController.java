package fr.hoc.dap.server.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.hoc.dap.server.service.CalendarService;
import fr.hoc.dap.server.service.GmailService;

/** Classe en "RestController". */
@RestController
public class HelloController {
    /** l'automobile.*/
    @Autowired
    private CalendarService calendarService;

    /** l'automobile.*/
    @Autowired
    private GmailService gmService;

    /** Test Hello.
     * @return Retourne en hello  */
    @RequestMapping("/hello")
    public String index() {
        return "Hello !";
    }

    /** Récuperer un bonjour.
     * @param theName Demande le nom
     * @return Retourne à bonjour + le nom
     */
    @RequestMapping("/bonjour")
    public String direBonjour(@RequestParam("name") final String theName) {
        return "Bonjour " + theName;
    }

    /** Récuperer les mails.
     * @return retourne au gmService
     * @throws GeneralSecurityException ///
     * @throws IOException ///
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
