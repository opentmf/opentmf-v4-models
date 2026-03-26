package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Reason for eligibility result if the productOfferingQualification result is
 * no (meaning the productOffering or productSpec is not available).
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-679: Product Offering Qualification Management API</li>
 *   <li>TMF-714: Work Qualification Management</li>
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
    defaultImpl = EligibilityUnavailabilityReason.class
)
public class EligibilityUnavailabilityReason extends Entity implements IEligibilityUnavailabilityReason {

  /**
   * Unavailability reason code.
   */
  private @SafeText String code;

  /**
   * Unavailability reason label.
   */
  private @SafeText String label;
}