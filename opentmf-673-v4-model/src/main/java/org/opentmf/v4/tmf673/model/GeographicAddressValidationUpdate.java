package org.opentmf.v4.tmf673.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.GeographicAddress;

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
 * @author Gokhan Demir
 */
@Getter
@Setter
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = GeographicAddressValidationUpdate.class
)
public class GeographicAddressValidationUpdate extends GeographicAddressValidationCreate {

  /**
   * Date when the address validation is performed.
   */
  private OffsetDateTime validationDate;

  /**
   * Result of the address validation (success, partial, fails).
   */
  private @SafeText String validationResult;

  /**
   * List of: Structured textual way of describing how to find a Property in an
   * urban area (country properties are often defined differently).
   * <br/>Note : Address corresponds to SID UrbanPropertyAddress.
   */
  @JsonProperty("alternateGeographicAddress")
  private List<@Valid GeographicAddress> alternateGeographicAddresses;

  /**
   * Possible values for the state of a task.
   *
   * @see org.opentmf.v4.common.model.TaskStateType
   */
  private @SafeText String state;

  /**
   * the correct form of the validated address in case of validation success.
   */
  private @Valid GeographicAddress validGeographicAddress;
}