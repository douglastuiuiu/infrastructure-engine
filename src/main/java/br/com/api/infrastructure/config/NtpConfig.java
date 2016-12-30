package br.com.api.infrastructure.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author douglasog87@gmail.com
 * @since 29/12/2016
 */
@Configuration
public class NtpConfig {

    @Value("${ntp.servers}")
    private String[] ntpServer;

    @Value("${ntp.timeoutLimit}")
    private Integer timeoutLimit;

    public String[] getNtpServer() {
        return ntpServer;
    }

    public void setNtpServer(String[] ntpServer) {
        this.ntpServer = ntpServer;
    }

    public Integer getTimeoutLimit() {
        return timeoutLimit;
    }

    public void setTimeoutLimit(Integer timeoutLimit) {
        this.timeoutLimit = timeoutLimit;
    }

}
