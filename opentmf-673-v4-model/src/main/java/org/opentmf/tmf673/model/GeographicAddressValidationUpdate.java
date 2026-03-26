package org.opentmf.tmf673.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.general.model.GeographicAddress;

/**
 * This resource is used to manage address validation request and response
 * <br/>Skipped properties: id,href.
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
    defaultImpl = GeographicAddressValidationUpdate.class
)
public class GeographicAddressValidationUpdate extends GeographicAddressValidationCreate implements IGeographicAddressValidationUpdate {

  /**
   * List of: Structured textual way of describing how to find a Property in an
   * urban area (country properties are often defined differently).
   * <br/>Note : Address corresponds to SID UrbanPropertyAddress.
   */
  @JsonProperty("alternateGeographicAddress")
  private List<@Valid GeographicAddress> alternateGeographicAddresses;

  /**
   * Possible values for the state of a task
   * <br/><p>Recommended values: acknowledged, terminatedWithError, inProgress,
   * done.
   *
   * @see org.opentmf.common.model.TaskStateType
   */
  private @SafeText String state;

  /**
   * Structured textual way of describing how to find a Property in an urban area
   * (country properties are often defined differently).
   * <br/>Note : Address corresponds to SID UrbanPropertyAddress.
   */
  private @Valid GeographicAddress validGeographicAddress;

  /**
   * Date when the address validation is performed.
   */
  private OffsetDateTime validationDate;

  /**
   * Result of the address validation (success, partial, fails).
   */
  private @SafeText String validationResult;
}