package org.opentmf.tmf645.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.TerminationError;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A ServiceQualificationItem relates to a specific service being checked in a
 * qualification operation.
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
    defaultImpl = CheckServiceQualificationItem.class
)
public class CheckServiceQualificationItem extends ServiceQualificationItem implements ICheckServiceQualificationItem {

  /**
   * Alternate service proposal is used when the requested service is not
   * available with characteristic and date asked for. An alternate proposal could
   * be a distinct service Spec close to requested one or same as requested but
   * with a different availability date.
   */
  @JsonProperty("alternateServiceProposal")
  private List<@Valid AlternateServiceProposal> alternateServiceProposals;

  /**
   * A list of eligibility unavailability reasons (EligibilityUnavailabilityReason
   * [*]). Reason for eligibility result if the serviceQualification result is no
   * (meaning the service is not available).
   */
  @JsonProperty("eligibilityUnavailabilityReason")
  private List<@Valid ServiceEligibilityUnavailabilityReason> eligibilityUnavailabilityReasons;

  /**
   * A list of qualification item relationships used to describe relationship
   * between serviceQualification item from the same serviceQualification.
   */
  @JsonProperty("qualificationItemRelationship")
  private List<@Valid ServiceQualificationItemRelationship> qualificationItemRelationships;

  /**
   * Structure used to describe relationship between serviceQualification item
   * from the same serviceQualification.
   */
  @JsonProperty("qualificationRelationship")
  private List<@Valid ServiceQualificationRelationship> qualificationRelationships;

  /**
   * Qualification result for serviceQualification item. It could be: - qualified
   * (request service are available), - unqualified (requested not available and
   * not alternate available), - alternate (requested not available but proposal
   * available).
   */
  private @SafeText String qualificationResult;

  /**
   * State of the serviceQualification item (acknowledged, inProgress,
   * terminatedWithError, done).
   */
  private @SafeText String state;

  /**
   * If qualificationItem has not been done properly this lists the error(s) that
   * caused termination of the qualification.
   */
  @JsonProperty("terminationError")
  private List<@Valid TerminationError> terminationErrors;
}