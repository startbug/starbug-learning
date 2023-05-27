package com.ggs.starbugcron.config;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronExpression;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class DynamicCronTask implements InitializingBean {

    @Autowired
    private ThreadPoolTaskScheduler taskScheduler;

    private ScheduledFuture<?> scheduledFuture;

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("注册定时任务");

        scheduledFuture = register("* * * * * ?");
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                log.info("取消调度");
                scheduledFuture.cancel(false);
                log.info("取消结果:" + scheduledFuture.isCancelled());
                log.info("重新注册一个定时任务:每2秒执行一次");
                register("0/2 * * * * ?");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private ScheduledFuture<?> register(String cron) {
        boolean validExpression = CronExpression.isValidExpression(cron);
        log.info("cron:[{}]是否合法:[{}]", cron, validExpression);

        CronExpression expression = CronExpression.parse(cron);

        LocalDateTime nextExecTime = expression.next(LocalDateTime.now());
        if (Objects.isNull(nextExecTime)) {
            log.info("定时任务下次执行的时间未:[{}]", nextExecTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }
        return taskScheduler.schedule(new Runnable() {
            @Override
            public void run() {
                log.info("执行啦----");
            }
        }, new CronTrigger(cron));
    }

}
