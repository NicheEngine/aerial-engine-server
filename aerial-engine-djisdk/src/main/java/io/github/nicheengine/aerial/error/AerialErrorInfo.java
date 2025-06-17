package io.github.nicheengine.aerial.error;

import io.github.nichetoolkit.rest.RestStatus;

/**
 * <code>ErrorInfo</code>
 * <p>The error info interface.</p>
 * @author Cyan (snow22314@outlook.com)
 * @see io.github.nichetoolkit.rest.RestStatus
 * @since Jdk1.8
 */
public interface AerialErrorInfo extends RestStatus {

    /**
     * <code>getCode</code>
     * <p>The get code getter method.</p>
     * @return {@link java.lang.Integer} <p>The get code return object is <code>Integer</code> type.</p>
     * @see java.lang.Integer
     */
    default Integer getCode() {
        return getStatus();
    }

}
