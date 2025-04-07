package org.opentmf.v4.tmf673.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.v4.common.model.Extensible;
import org.opentmf.v4.common.model.GeographicAddress;

/**
 * This resource is used to manage address validation request and response
 * <br/>Skipped properties:
 * id,href,alternateGeographicAddress,validGeographicAddress,state,validationResult,validationDate.
 *
 * <p><br/>
 * <strong>Required:</strong> submittedGeographicAddress, provideAlternative<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-673: Geographic Address Management API</li>
 * </ul>
 * </p>
 *
 * @author Gokhan Demir
 */
@Getter
@Setter
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = GeographicAddressValidationCreate.class
)
@Required(fields = {"provideAlternative", "submittedGeographicAddress"})
public class GeographicAddressValidationCreate extends Extensible {

  /**
   * Indicator provided by the requester to specify if alternate addresses must be
   * provided in case of partial or fail result.
   */
  private Boolean provideAlternative;

  /**
   * the address as submitted to validation.
   */
  private @Valid GeographicAddress submittedGeographicAddress;
}