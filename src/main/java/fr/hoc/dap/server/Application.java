package fr.hoc.dap.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/** fçjfjioj.*/
@SpringBootApplication
public class Application {
    /** fkfkg.*/
    private static final Logger LOG = LogManager.getLogger();

    /** fçjfjioj.
     * @param args jfj */
    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /** fçjfjioj.
     * @return fkfo*/
    @Bean
    public Config createConf() {

        Config conf = new Config();
        String nom = "App";
        //conf.setClientSecretFile("/crediantals_web.json");
        conf.setApplicationName(nom);
        return conf;

    }

    /** ffjd.
     * @param ctx course de v en ciboulette
     * @return fjf
     */
    @Bean
    public CommandLineRunner commandLineRunner(final ApplicationContext ctx) {
        return args -> {

            Config myConfig = new Config();

            //GmailQuickstart myGmail = GmailQuickstart.getInstance();
            //            CalendarQuickstart myCalendar = CalendarQuickstart.getInstance();

            System.out.println(myConfig.getApplicationName());

            //myGmail.setConf(myConfig);
            //myGmail.countNbUnreadMessages();

            //set conf myGmail
            //            myCalendar.setConf(myConfig);
            //            myCalendar.calendrier();
            LOG.info("Dossier du Credentials : " + myConfig.getClientSecretFile());
            LOG.info("Le nom de l'application : " + myConfig.getApplicationName());

        };
    }
}
