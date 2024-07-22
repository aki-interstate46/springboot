package com.jobcommon.startup;

import java.util.Date;

import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.jobcommon.spring.service.JobService;
import com.systemcommon.enums.SystemExit;
import com.systemcommon.spring.component.EnvironmentOperation;
import com.systemcommon.spring.component.EnvironmentOperationList;
import com.systemcommon.spring.component.MessageSourceOperation;
import com.systemcommon.spring.component.MessageSourceOperationList;
import com.systemcommon.spring.component.SystemLog;

@Service
public abstract class JobRunner {

	static long startTime;
	static SystemExit systemExit;

	final static String JOB_SERVICE = "job.service";
	final static String JOB_PACKAGE = JOB_SERVICE + ".package";
	
	static EnvironmentOperationList eo;
	static MessageSourceOperationList mso;
	static SystemLog systemLog;
	protected static void start(SpringApplication application, String[] args) {
		startTime = System.currentTimeMillis();
		application.setBannerMode(Banner.Mode.OFF);
		application.setLogStartupInfo(false);
		application.setWebApplicationType(WebApplicationType.NONE); // 除外設定
	}

	protected static void end(SpringApplication application, String[] args) {
		final long endTime = System.currentTimeMillis();
		systemLog.info("#JOB_ID            :{}", args[1]);
		LoggerFactory.getLogger(JobRunner.class).info("#SYSTEM_EXIT       :{}", systemExit.name());
		LoggerFactory.getLogger(JobRunner.class).info("#SYSTEM_EXIT_VALUE :{}", systemExit.getValue());
		LoggerFactory.getLogger(JobRunner.class).info("#START_POINT_TIME  :{}", new Date(startTime));
		LoggerFactory.getLogger(JobRunner.class).info("#END_POINT_TIME    :{}", new Date(endTime));
		LoggerFactory.getLogger(JobRunner.class).info("#DELTA_MILLISECOND :{}", (endTime - startTime));
	}

	protected static void run(SpringApplication application, String[] args) {
		systemExit = jobRunner(application, args);
	}

	public static SystemExit jobRunner(SpringApplication application, String[] args) {
		try {
			ApplicationContext context = application.run(args);

			eo = context.getBean(EnvironmentOperationList.class);
			mso = context.getBean(MessageSourceOperationList.class);
			systemLog = context.getBean(SystemLog.class);

			final String jobId = args[1];
			String jobInfo = JOB_PACKAGE + "." + jobId;
			if (!eo.isContainsProperty(jobInfo)) {
				return SystemExit.FAILED;
			}
			JobService baseJob = (JobService) Class.forName(eo.getProperty(jobInfo)).getDeclaredConstructor().newInstance();
			JobService service = (JobService) context.getBean(baseJob.getClass());
			service.processer();
			return SystemExit.COMPLETED;
		} catch (Exception e) {
			LoggerFactory.getLogger(JobRunner.class).error("", e);
			return SystemExit.FAILED;
		}

	}

}
