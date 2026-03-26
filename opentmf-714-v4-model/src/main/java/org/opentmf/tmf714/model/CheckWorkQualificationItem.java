package org.opentmf.tmf714.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.TerminationError;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A WorkQualificationItem relates to a specific unit of work being checked in a
 * qualification operation.
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
    defaultImpl = CheckWorkQualificationItem.class
)
public class CheckWorkQualificationItem extends WorkQualificationItem implements ICheckWorkQualificationItem {

  /**
   * List of: Alternate work proposal is used when the requested unit of work is
   * not valid as specified in the request. An alternate proposal could be a
   * distinct workSpecification close to the requested one or the same
   * specification as requested but with a different parameters.
   */
  @JsonProperty("alternateWorkProposal")
  private List<@Valid AlternateWorkProposal> alternateWorkProposals;

  /**
   * List of: Structure used to describe relationship between WorkQualification
   * items from the same WorkQualification .
   */
  @JsonProperty("qualificationItemRelationship")
  private List<@Valid WorkQualificationItemRelationship> qualificationItemRelationships;

  /**
   * List of: Structure used to describe relationship between WorkQualification
   * item from the same WorkQualification.
   */
  @JsonProperty("qualificationRelationship")
  private List<@Valid WorkQualificationRelationship> qualificationRelationships;

  /**
   * Qualification result for workQualification item. It could be: - qualified
   * (requested unit of work is valid), - unqualified (requested unit of work not
   * valid and not alternative available), - alternate (requested unit of work not
   * valid but alternate proposal available).
   */
  private @SafeText String qualificationResult;

  /**
   * State of the qualification item (acknowledged, inProgress,
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