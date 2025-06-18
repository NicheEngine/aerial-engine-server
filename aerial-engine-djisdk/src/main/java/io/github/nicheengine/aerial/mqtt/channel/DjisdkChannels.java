package io.github.nicheengine.aerial.mqtt.channel;

/**
 * <code>DjisdkChannels</code>
 * <p>The djisdk channels interface.</p>
 * @author Cyan (snow22314@outlook.com)
 * @since Jdk1.8
 */
public interface DjisdkChannels {
    /**
     * <code>INBOUND_STATUS</code>
     * {@link java.lang.String} <p>The constant <code>INBOUND_STATUS</code> field.</p>
     * @see java.lang.String
     */
    // status
    String INBOUND_STATUS = "inboundStatus";

    /**
     * <code>OUTBOUND_STATUS</code>
     * {@link java.lang.String} <p>The constant <code>OUTBOUND_STATUS</code> field.</p>
     * @see java.lang.String
     */
    String OUTBOUND_STATUS = "outboundStatus";

    /**
     * <code>INBOUND_STATE</code>
     * {@link java.lang.String} <p>The constant <code>INBOUND_STATE</code> field.</p>
     * @see java.lang.String
     */
    // state
    String INBOUND_STATE = "inboundState";
    /**
     * <code>OUTBOUND_STATE</code>
     * {@link java.lang.String} <p>The constant <code>OUTBOUND_STATE</code> field.</p>
     * @see java.lang.String
     */
    String OUTBOUND_STATE = "outboundState";

    /**
     * <code>INBOUND_SERVICES_REPLY</code>
     * {@link java.lang.String} <p>The constant <code>INBOUND_SERVICES_REPLY</code> field.</p>
     * @see java.lang.String
     */
    // services_reply
    String INBOUND_SERVICES_REPLY = "inboundServicesReply";

    /**
     * <code>INBOUND_OSD</code>
     * {@link java.lang.String} <p>The constant <code>INBOUND_OSD</code> field.</p>
     * @see java.lang.String
     */
    // osd
    String INBOUND_OSD = "inboundOsd";

    /**
     * <code>INBOUND_REQUESTS</code>
     * {@link java.lang.String} <p>The constant <code>INBOUND_REQUESTS</code> field.</p>
     * @see java.lang.String
     */
    // requests
    String INBOUND_REQUESTS = "inboundRequests";
    /**
     * <code>OUTBOUND_REQUESTS</code>
     * {@link java.lang.String} <p>The constant <code>OUTBOUND_REQUESTS</code> field.</p>
     * @see java.lang.String
     */
    String OUTBOUND_REQUESTS = "outboundRequests";

    /**
     * <code>INBOUND_EVENTS</code>
     * {@link java.lang.String} <p>The constant <code>INBOUND_EVENTS</code> field.</p>
     * @see java.lang.String
     */
    // events
    String INBOUND_EVENTS = "inboundEvents";

    /**
     * <code>OUTBOUND_EVENTS</code>
     * {@link java.lang.String} <p>The constant <code>OUTBOUND_EVENTS</code> field.</p>
     * @see java.lang.String
     */
    String OUTBOUND_EVENTS = "outboundEvents";

    /**
     * <code>INBOUND_PROPERTY_SET_REPLY</code>
     * {@link java.lang.String} <p>The constant <code>INBOUND_PROPERTY_SET_REPLY</code> field.</p>
     * @see java.lang.String
     */
    // property
    String INBOUND_PROPERTY_SET_REPLY = "inboundPropertySetReply";

    /**
     * <code>INBOUND_DRC_UP</code>
     * {@link java.lang.String} <p>The constant <code>INBOUND_DRC_UP</code> field.</p>
     * @see java.lang.String
     */
    // drc/up
    String INBOUND_DRC_UP = "inboundDrcUp";

}
