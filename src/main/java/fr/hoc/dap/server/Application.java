package fr.hoc.dap.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/** Classe application en "SpringBoot".*/
@SpringBootApplication
public class Application {
    /** Récupérer le LOG.*/
    private static final Logger LOG = LogManager.getLogger();

    /** Classe Main.
     * @param args Paramètre de la ligne de commande */
    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /** Création de config.
     * @return Retourne à la conf*/
    @Bean
    public Config createConf() {

        Config conf = new Config();
        String nom = "App";
        conf.setClientSecretFile(System.getProperty("user.home") + "/dap/credentials_web.json");
        conf.setApplicationName(nom);
        return conf;

    }

    //TODO col by Djer |Audit Code| Ton plugin CheckStyle n'était pas activé/configuré (il manque un . (point) sur la description de ta Javadoc).
    /** Afficher les configs
     * @param ctx ///
     * @return Retourne vers les arguments
     */
    @Bean
    public CommandLineRunner commandLineRunner(final ApplicationContext ctx) {
        return args -> {

            //TODO col by Djer |IOC| Attention, ce que tu affiches est "faux". Tu affiches des données de la config par defaut; Ta "vrai" config est produite par createConf();
            //Si tu souhaite aficher les infos de la config, fait-le là ou elle sont modifiée/produite (dans le createConf())
            Config myConfig = new Config();

            //GmailQuickstart myGmail = GmailQuickstart.getInstance();
            //            CalendarQuickstart myCalendar = CalendarQuickstart.getInstance();

            //TODO col by Djer |Java| Ne pas faire de SysOut sur un composant "serveur". utilise une LOG si besoin.
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
