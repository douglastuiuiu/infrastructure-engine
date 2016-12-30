package br.com.api.infrastructure.service;

import br.com.api.infrastructure.config.NtpConfig;
import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.util.Date;

/**
 * @author douglasog87@gmail.com
 * @since 29/12/2016
 */
@Service
public class InfrastructureService {

    private static final Logger logger = LoggerFactory.getLogger(InfrastructureService.class);

    @Autowired
    private NtpConfig ntpConfig;

    /**
     * Obtem um LocalDateTime
     *
     * @return LocalDateTime
     */
    public Long getDateTime() {
        NTPUDPClient client = new NTPUDPClient();
        try {
            client.setDefaultTimeout(ntpConfig.getTimeoutLimit());
            for (String host : ntpConfig.getNtpServer()) {
                InetAddress hostAddr = InetAddress.getByName(host);
                logger.info("> " + hostAddr.getHostName() + "/" + hostAddr.getHostAddress());
                TimeInfo info = client.getTime(hostAddr);
                return info.getReturnTime();
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            client.close();
        }
        return new Date().getTime();
    }

}
