package cl.ripley.GestionTV.plugin;

import java.util.Date;

import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerUtils;
import org.quartz.impl.StdSchedulerFactory;

import cl.ripley.GestionTV.plugin.jobs.HelloJob;
import cl.ripley.GestionTV.plugin.jobs.SimpleJob;


public class QuartzPlugin implements PlugIn  {

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init(ActionServlet arg0, ModuleConfig arg1)
			throws ServletException {

		try {		
			
	        Logger log = Logger.getLogger(QuartzPlugin.class);

	        // First we must get a reference to a scheduler
	        SchedulerFactory sf = new StdSchedulerFactory();
	        Scheduler sched = sf.getScheduler();

	        log.info("------- Initialization Complete --------");

	        log.info("------- Scheduling Jobs ----------------");

	        // jobs can be scheduled before sched.start() has been called

	        // job 1 will run every 20 seconds
	        JobDetail job = new JobDetail("job1", "group1", SimpleJob.class);
	        CronTrigger trigger = new CronTrigger("trigger1", "group1", "job1",
	                "group1", "0/20 * * * * ?");
	        sched.addJob(job, true);
	        Date ft = sched.scheduleJob(trigger);
	        log.info(job.getFullName() + " has been scheduled to run at: " + ft
	                + " and repeat based on expression: "
	                + trigger.getCronExpression());



	        log.info("------- Starting Scheduler ----------------");

	        // All of the jobs have been added to the scheduler, but none of the
	        // jobs
	        // will run until the scheduler has been started
	        sched.start();
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}				
	}

}
