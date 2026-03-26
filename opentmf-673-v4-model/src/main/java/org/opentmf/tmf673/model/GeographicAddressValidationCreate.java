package org.opentmf.tmf673.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.general.model.GeographicAddress;

/**
 * This resource is used to manage address validation request and response
 * <br/>Skipped properties:
 * id,href,alternateGeographicAddress,validGeographicAddress,state,validationResult,validationDate.
 *
 * <p><br/>
 * <strong>Required:</strong> provideAlternative, submittedGeographicAddress<br/>
 * </p>
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
    defaultImpl = GeographicAddressValidationCreate.class
)
@Required(fields = {"provideAlternative", "submittedGeographicAddress"})
public class GeographicAddressValidationCreate extends Extensible implements IGeographicAddressValidationCreate {

  /**
   * Indicator provided by the requester to specify if alternate addresses must be
   * provided in case of partial or fail result.
   */
  private Boolean provideAlternative;

  /**
   * Structured textual way of describing how to find a Property in an urban area
   * (country properties are often defined differently).
   * <br/>Note : Address corresponds to SID UrbanPropertyAddress.
   */
  private @Valid GeographicAddress submittedGeographicAddress;
}