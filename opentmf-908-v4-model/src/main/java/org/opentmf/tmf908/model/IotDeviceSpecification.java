package org.opentmf.tmf908.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * #TODO.
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
    defaultImpl = IotDeviceSpecification.class
)
public class IotDeviceSpecification extends IotDeviceSpecificationCreate implements IIotDeviceSpecification {

  /**
   * Reference of the service specification.
   */
  private URI href;

  /**
   * Unique identifier of the service specification.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}