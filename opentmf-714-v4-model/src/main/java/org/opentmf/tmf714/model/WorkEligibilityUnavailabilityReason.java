package org.opentmf.tmf714.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Reason for eligibility result if the WorkQualification result is no (meaning
 * the Unit of Work is not valid).
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
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
    defaultImpl = WorkEligibilityUnavailabilityReason.class
)
public class WorkEligibilityUnavailabilityReason extends Extensible implements IWorkEligibilityUnavailabilityReason {

  /**
   * Unavailability reason code.
   */
  private @SafeText String code;

  /**
   * Unavailability reason label.
   */
  private @SafeText String label;
}