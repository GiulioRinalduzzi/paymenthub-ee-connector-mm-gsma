package org.mifos.connector.gsma.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

/**
 * The {@code camel.*} settings this connector owns: the callback host it hands to the GSMA API, the port the Camel REST
 * endpoints listen on, and whether TLS verification is switched off.
 *
 * <p>
 * Only these three keys are bound. Everything else under {@code camel.} belongs to camel-spring-boot and is left alone.
 * The names are unchanged because the deployment sets them as environment variables.
 * </p>
 *
 * @param host
 *            callback URL the GSMA API is told to notify
 * @param serverPort
 *            port the Camel REST endpoints listen on
 * @param disableSsl
 *            when true, the https Camel component trusts any certificate
 */
@ConfigurationProperties(prefix = "camel")
public record ConnectorCamelProperties(String host, @DefaultValue("5000") int serverPort, @DefaultValue("false") boolean disableSsl) {
}
