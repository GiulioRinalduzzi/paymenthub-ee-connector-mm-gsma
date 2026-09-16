package org.mifos.connector.gsma.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

/**
 * Everything this connector needs in order to talk to the GSMA Mobile Money API.
 *
 * <p>
 * The property names are the ones the deployment already sets as environment variables, so they must not be renamed.
 * </p>
 *
 * <p>
 * {@code @DefaultValue} on the two groups matters: without it, deleting a whole section from the configuration leaves
 * the group null, and the first use of it is a NullPointerException that names nothing.
 * </p>
 *
 * @param api
 *            the GSMA Mobile Money API itself, {@code gsma.api.*}
 * @param auth
 *            the OAuth credentials used to fetch an access token, {@code gsma.auth.*}
 */
@ConfigurationProperties(prefix = "gsma")
public record GsmaProperties(@DefaultValue Api api, @DefaultValue Auth auth) {

    /**
     * The GSMA Mobile Money API itself: {@code gsma.api.*}.
     *
     * @param host
     *            base URL of the GSMA API, for example
     *            {@code https://sandbox.mobilemoneyapi.io/oauth/simulator/v1.1/mm}
     * @param account
     *            path of the accounts resource under the base URL, for example {@code /accounts}
     * @param channel
     *            base URL of the channel connector this connector calls back into
     */
    public record Api(String host, String account, String channel) {
    }

    /**
     * The OAuth credentials used to fetch an access token: {@code gsma.auth.*}.
     *
     * @param host
     *            token endpoint of the GSMA API
     * @param clientKey
     *            OAuth client key
     * @param clientSecret
     *            OAuth client secret
     */
    public record Auth(String host, String clientKey, String clientSecret) {
    }
}
