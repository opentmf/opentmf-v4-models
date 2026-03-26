package org.opentmf.tmf645.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Reason for eligibility result if the ServiceQualification result is no
 * (meaning the Service is not available).
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-645: Service Qualification Management API</li>
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
    defaultImpl = ServiceEligibilityUnavailabilityReason.class
)
public class ServiceEligibilityUnavailabilityReason extends Extensible implements IServiceEligibilityUnavailabilityReason {

  /**
   * Unavailability reason code.
   */
  private @SafeText String code;

  /**
   * Unavailability reason label.
   */
  private @SafeText String label;
}