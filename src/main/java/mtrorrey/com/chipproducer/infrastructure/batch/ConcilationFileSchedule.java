package mtrorrey.com.chipproducer.infrastructure.batch;


import mtrorrey.com.chipproducer.infrastructure.util.TimeStampUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ConcilationFileSchedule {

  private static final Logger LOGGER = LoggerFactory.getLogger(ConcilationFileSchedule.class);

  @Scheduled(cron = "0 * * * * ?") // Ejecutar cada minuto
  public void myTask() {

    // Este proceso detonara el proceso batch para procesar el archivo de conciliación.

    LOGGER.info("[{}] Ejecución del proceso del archivo de conciliación: {}", TimeStampUtil.dateLogger(),"name.xml" );
    System.out.println("Ejecutando tarea cada minuto...");
  }
}
