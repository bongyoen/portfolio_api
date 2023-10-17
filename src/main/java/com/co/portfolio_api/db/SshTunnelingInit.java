package com.co.portfolio_api.db;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.annotation.PreDestroy;

import static java.lang.System.exit;

@Slf4j
@Component
@Validated
@Setter
@ConfigurationProperties(prefix = "spring.datasource.ssh")
public class SshTunnelingInit {
    private String host;
    @NotNull
    private String user;
    @NotNull
    private Integer port;
    @NotNull
    private String keyfile;
    @NotNull
    private Session session;

    @PreDestroy
    public void closeSSH() {
        if (session.isConnected())
            session.disconnect();
    }

    public Integer buildSshDbConnection(String dbEndpoint, Integer dbPort) {

        int forwardedPort;

        JSch jSch = new JSch();

        try {
            jSch.addIdentity(keyfile);  // 개인키
            session = jSch.getSession(user, host, port);  // 세션 설정
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();

            forwardedPort = session.setPortForwardingL(0, dbEndpoint, dbPort);

        } catch (JSchException e) {
            log.error("fail to make ssh tunneling");
            this.closeSSH();
            exit(1);
            return 0;
        }

        return forwardedPort;
    }
}
