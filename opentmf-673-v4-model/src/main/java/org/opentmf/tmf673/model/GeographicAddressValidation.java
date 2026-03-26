package org.opentmf.tmf673.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * This resource is used to manage address validation request and response.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-673: Geographic Address Management API</li>
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
    defaultImpl = GeographicAddressValidation.class
)
public class GeographicAddressValidation extends GeographicAddressValidationUpdate implements IGeographicAddressValidation {

  /**
   * An URI used to access to the address validation resource.
   */
  private URI href;

  /**
   * Unique identifier of the Address Validation.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}