package org.opentmf.tmf908.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.EventBase;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Generic IotManagementEvent structure used to define commonalities between sub
 * concepts of PartyIotManagementEvent and Financial IotManagementEvent.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-908: IoT Agent and Device Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class IotManagementEvent extends EventBase implements IIotManagementEvent {

  /**
   * When subclassing, this defines the super-class.
   */
  @JsonProperty("@baseType")
  private @SafeText String atBaseType;

  /**
   * A URI to a JSON-Schema file that defines additional attributes and
   * relationships.
   */
  @JsonProperty("@schemaLocation")
  private URI atSchemaLocation;

  /**
   * When subclassing, this defines the subclass entity name.
   */
  @JsonProperty("@type")
  private @SafeText String atType;

  private Object event;
}