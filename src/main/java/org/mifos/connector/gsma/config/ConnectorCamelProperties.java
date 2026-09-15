package org.mifos.connector.gsma.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * The {@code camel.*} settings this connector owns: the callback host it hands to the GSMA API, the port the Camel REST
 * endpoints listen on, and whether TLS verification is switched off.
 *
 * <p>
 * Only these three keys are bound. Everything else under {@code camel.} belongs to camel-spring-boot and is left alone.
 * The names are unchanged because the deployment sets them as environment variables.
 * </p>
 */
@ConfigurationProperties(prefix = "camel")
public class ConnectorCamelProperties {

    /** Callback URL the GSMA API is told to notify. */
    private String host;

    /** Port the Camel REST endpoints listen on. */
    private int serverPort;

    /** When true, the https Camel component trusts any certificate. */
    private boolean disableSsl;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getServerPort() {
        return serverPort;
    }

    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }

    public boolean isDisableSsl() {
        return disableSsl;
    }

    public void setDisableSsl(boolean disableSsl) {
        this.disableSsl = disableSsl;
    }
}
