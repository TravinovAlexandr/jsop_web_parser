package alex.ru.statistic;

import alex.ru.rate.RateFacade;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;

public class StatWrapper implements Stat {

    private String pathToLog = System.getProperty("java.io.tmpdir");
    private String fileName = "rate.log";

    @Override
    public void compute(final RateFacade rateFacade) {
        boolean isOk = rateFacade.computeRate();
        if(isOk) {
            log(rateFacade);
        }
    }

    private void log(final RateFacade rateFacade) {
        PrintWriter printWriter = null;
        try {
            final Path pathToLogFile = Paths.get(pathToLog + File.separator + fileName);
            final String course = rateFacade.printRate();

            if (!Files.exists(pathToLogFile)) {
                Files.createFile(pathToLogFile);
            }
            printWriter = new PrintWriter(new FileWriter(new File(pathToLogFile.toString()), true));
            printWriter.append("#" +LocalDate.now() + "  " + LocalTime.now() + "\n");
            printWriter.append(course + "\n");
            System.out.println(course);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Log not work. Permissions denied: " + pathToLog);
        } finally {
            if(printWriter != null) {
                printWriter.flush();
                printWriter.close();
            }
        }
    }

    @Override
    public void compute(final RateFacade rateFacade, final String pathToLog) {
        this.pathToLog = pathToLog;
        compute(rateFacade);
    }

    @Override
    public void compute(final RateFacade rateFacade, final String pathToLog, final String fileName) {
        this.pathToLog = pathToLog;
        this.fileName = fileName;
        compute(rateFacade);
    }
}
