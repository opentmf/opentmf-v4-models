package org.opentmf.tmf908.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * #TODO.
 *
 * <p><br/>
 * <strong>Required:</strong> category, id<br/>
 * </p>
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
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = IotDevice.class
)
@Required(fields = {"id", "category"})
public class IotDevice extends IotDeviceUpdate implements IIotDevice {

  /**
   * The URI for the object itself.
   */
  private URI href;

  /**
   * Identifier of an instance of the resource. Required to be unique within the
   * resource type. Used in URIs as the identifier for specific instances of a
   * type.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}