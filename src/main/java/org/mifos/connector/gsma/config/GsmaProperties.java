package org.mifos.connector.gsma.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Everything this connector needs in order to talk to the GSMA Mobile Money API.
 *
 * <p>
 * The property names are the ones the deployment already sets as environment variables, so they must not be renamed. If
 * one of them is missing or empty the application fails to start and the message names the property, instead of the
 * connector starting and the call failing in the middle of a payment.
 * </p>
 */
@ConfigurationProperties(prefix = "gsma")
public class GsmaProperties {

    private Api api = new Api();

    private Auth auth = new Auth();

    public Api getApi() {
        return api;
    }

    public void setApi(Api api) {
        this.api = api;
    }

    public Auth getAuth() {
        return auth;
    }

    public void setAuth(Auth auth) {
        this.auth = auth;
    }

    /**
     * The GSMA Mobile Money API itself: {@code gsma.api.*}.
     */
    public static class Api {

        /** Base URL of the GSMA API, for example {@code https://sandbox.mobilemoneyapi.io/oauth/simulator/v1.1/mm}. */
        private String host;

        /** Path of the accounts resource under the base URL, for example {@code /accounts}. */
        private String account;

        /** Base URL of the channel connector this connector calls back into. */
        private String channel;

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public String getChannel() {
            return channel;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }
    }

    /**
     * The OAuth credentials used to fetch an access token: {@code gsma.auth.*}.
     */
    public static class Auth {

        /** Token endpoint of the GSMA API. */
        private String host;

        /** OAuth client key. */
        private String clientKey;

        /** OAuth client secret. */
        private String clientSecret;

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public String getClientKey() {
            return clientKey;
        }

        public void setClientKey(String clientKey) {
            this.clientKey = clientKey;
        }

        public String getClientSecret() {
            return clientSecret;
        }

        public void setClientSecret(String clientSecret) {
            this.clientSecret = clientSecret;
        }
    }
}
