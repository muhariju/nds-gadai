package id.co.nds.gadai.scheduler;

import java.util.Calendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import id.co.nds.gadai.services.TransaksiService;

@Component
public class CronScheduler {
    static final Logger logger = LogManager.getLogger(CronScheduler.class);
   
    @Autowired
    TransaksiService transaksiService;

    //@Scheduled(cron = "0/10 * * * * ?") //every 10 seconds
    @Scheduled(cron = "0 0 * * * ?") //every day at 12 AM
    public void cronSchedule() throws Exception {


        transaksiService.doUpdateCicilan();
        logger.debug("Start Cron at " + Calendar.getInstance().getTime());
        logger.info("Data Status Cicilan & Denda Updated");

        Thread.sleep(15000);
    }
}
