package fr.hoc.dap.server.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.hoc.dap.server.service.CalendarService;
import fr.hoc.dap.server.service.GmailService;

/** ddfj. */
@RestController
public class HelloController {
    /** l'automobile.*/
    @Autowired
    private CalendarService calendarService = new CalendarService();

    /** l'automobile.*/
    @Autowired
    private GmailService gmService = new GmailService();

    /** ddfj.
     * @return dojf  */
    @RequestMapping("/hello")
    public String index() {
        return "Hello !";
    }

    /** fjfj.
     * @param theName course au peid de the name
     * @return xxx
     */
    @RequestMapping("/bonjour")
    public String direBonjour(@RequestParam("name") final String theName) {
        return "Bonjour " + theName;
    }

    /** faf.
     * @return fjsdds
     * @throws GeneralSecurityException fjsdds
     * @throws IOException dkfj
     * @param userKey get l'user */
    @RequestMapping("/email/nb")
    public Integer email(@RequestParam("userKey") final String userKey) throws IOException, GeneralSecurityException {
        return gmService.countNbUnreadMessages(userKey);
    }

    /** faf.
     * @return fjsdds
     * @throws GeneralSecurityException fjsdds
     * @throws IOException dkfj
     * @param userKey get l'user*/
    @RequestMapping("/event/next")
    public String calandar(@RequestParam("userKey") final String userKey) throws IOException, GeneralSecurityException {
        return calendarService.calendrier(userKey);
    }

}
