package org.mifos.connector.gsma.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * How this connector reaches the Zeebe broker: {@code zeebe.broker.*} and {@code zeebe.client.*}.
 *
 * <p>
 * {@code zeebe.client.evenly-allocated-max-jobs} is deliberately not here. Its value is a Spring expression
 * ({@code "#{...}"}) that only {@code @Value} evaluates, and some deployments override it with a plain number, so
 * moving it would either fail to start or quietly ignore the override. It stays on the worker classes that use it.
 * </p>
 */
@ConfigurationProperties(prefix = "zeebe")
public class ZeebeProperties {

    private Broker broker = new Broker();

    private Client client = new Client();

    public Broker getBroker() {
        return broker;
    }

    public void setBroker(Broker broker) {
        this.broker = broker;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * The broker to connect to: {@code zeebe.broker.*}.
     */
    public static class Broker {

        /** Gateway address, as {@code host:port}. */
        private String contactpoint;

        public String getContactpoint() {
            return contactpoint;
        }

        public void setContactpoint(String contactpoint) {
            this.contactpoint = contactpoint;
        }
    }

    /**
     * Client settings: {@code zeebe.client.*}.
     */
    public static class Client {

        /** Size of the job worker execution thread pool. */
        private int maxExecutionThreads;

        /** How long, in milliseconds, a published message stays available for correlation. */
        private int ttl;

        public int getMaxExecutionThreads() {
            return maxExecutionThreads;
        }

        public void setMaxExecutionThreads(int maxExecutionThreads) {
            this.maxExecutionThreads = maxExecutionThreads;
        }

        public int getTtl() {
            return ttl;
        }

        public void setTtl(int ttl) {
            this.ttl = ttl;
        }
    }
}
