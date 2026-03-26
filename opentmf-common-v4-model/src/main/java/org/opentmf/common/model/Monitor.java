package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Monitoring of resources.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-640: Service Activation Management API</li>
 *   <li>TMF-664: Resource Function Activation Management API</li>
 *   <li>TMF-702: Resource Activation Management API</li>
 *   <li>TMF-915: AI Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = Monitor.class
)
public class Monitor extends Entity implements IMonitor {

  /**
   * A response to a request.
   */
  private @Valid Request request;

  /**
   * A response to a request.
   */
  private @Valid Response response;

  /**
   * The monitored resource href.
   */
  private URI sourceHref;

  /**
   * The Monitor state of the resource. InProgress, InError, Completed.
   */
  private @SafeText String state;
}