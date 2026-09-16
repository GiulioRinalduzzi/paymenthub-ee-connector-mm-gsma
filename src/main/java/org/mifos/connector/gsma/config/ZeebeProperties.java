package org.mifos.connector.gsma.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

/**
 * How this connector reaches the Zeebe broker: {@code zeebe.broker.*} and {@code zeebe.client.*}.
 *
 * <p>
 * {@code zeebe.client.evenly-allocated-max-jobs} is deliberately not here. Its value is a Spring expression
 * ({@code "#{...}"}) that only {@code @Value} evaluates, and some deployments override it with a plain number, so
 * moving it would either fail to start or quietly ignore the override. It stays on the worker classes that use it.
 * </p>
 *
 * @param broker
 *            the broker to connect to, {@code zeebe.broker.*}
 * @param client
 *            client settings, {@code zeebe.client.*}
 */
@ConfigurationProperties(prefix = "zeebe")
public record ZeebeProperties(@DefaultValue Broker broker, @DefaultValue Client client) {

    /**
     * The broker to connect to: {@code zeebe.broker.*}.
     *
     * @param contactpoint
     *            gateway address, as {@code host:port}
     */
    public record Broker(String contactpoint) {
    }

    /**
     * Client settings: {@code zeebe.client.*}.
     *
     * @param maxExecutionThreads
     *            size of the job worker execution thread pool
     * @param ttl
     *            how long, in milliseconds, a published message stays available for correlation
     */
    public record Client(@DefaultValue("100") int maxExecutionThreads, @DefaultValue("30000") int ttl) {
    }
}
