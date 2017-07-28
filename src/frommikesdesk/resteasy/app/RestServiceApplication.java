package frommikesdesk.resteasy.app;

import frommikesdesk.rest.service.GetStatusResource;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;

import javax.ws.rs.core.Application;
import org.apache.log4j.*;

/**
 *
 * @author Michael Silveus <michaelsilveus@gmail.com>
 */
public class RestServiceApplication extends Application {
	
    static final long MAX_FILE_SIZE = 10000000;
    static final int MAX_FILE_BKUP = 10;
    static final String SYSTEM_PATH="resteasy";
    static final String LOG_FILE_NAME = "resteasy.log";
    static final String auditLogFileName = "resteasy_audit.log";
    static final int tasksPoolSize=1;
    static final Logger log = Logger.getLogger(RestServiceApplication.class);

    public static ExecutorService executorSvc=null;
    private Set<Object> webservices = new HashSet<Object>();

    public RestServiceApplication() {
        initializeRestService(Level.DEBUG);
        webservices.add(new GetStatusResource());
   }

    @Override
    public Set<Object> getSingletons() {
            return webservices;
    }

    private static void initializeRestService(Level logLevel) {
        try {
            String path = Helper.getSystemFolder(SYSTEM_PATH, "log");
            SimpleLayout layout = new SimpleLayout();    
            RollingFileAppender appender = new RollingFileAppender(layout,path + LOG_FILE_NAME,true);    
            appender.setMaximumFileSize(MAX_FILE_SIZE);
            appender.setMaxBackupIndex(MAX_FILE_BKUP);
            appender.setLayout(new PatternLayout("%d [%t] %-5p %c- %m%n"));
            log.addAppender(appender);

            log.setLevel(logLevel);
            log("Initializing Rest Service");
        } catch (Exception ex) {
            System.out.println("initializeRestService.contextInitialized: error setting up logger. " + ex.getMessage());
        }
    }

    protected static void log(String message) {
        log(log.getLevel(), message);
    }
    protected static void log(Level level, String message) {
        if (level.equals(Level.DEBUG)) {
            log.debug(message);
        }
        if (level.equals(Level.ERROR)) {
            log.error(message);
        }
        if (level.equals(Level.FATAL)) {
            log.fatal(message);
        }
        if (level.equals(Level.TRACE)) {
            log.trace(message);
        }
        if (level.equals(Level.WARN)) {
            log.warn(message);
        }
        if (level.equals(Level.INFO)) {
            log.info(message);
        }
    }
}
