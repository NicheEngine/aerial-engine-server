package io.github.nicheengine.aerial.error;

/**
 * <code>AerialErrorCode</code>
 * <p>The aerial error code interface.</p>
 * @author Cyan (snow22314@outlook.com)
 * @since Jdk1.8
 */
public interface AerialErrorCode {

    /**
     * <code>getMessage</code>
     * <p>The get message getter method.</p>
     * @return {@link java.lang.String} <p>The get message return object is <code>String</code> type.</p>
     * @see java.lang.String
     */
    String getMessage();

    /**
     * <code>getCode</code>
     * <p>The get code getter method.</p>
     * @return {@link java.lang.Integer} <p>The get code return object is <code>Integer</code> type.</p>
     * @see java.lang.Integer
     */
    Integer getCode();

}
