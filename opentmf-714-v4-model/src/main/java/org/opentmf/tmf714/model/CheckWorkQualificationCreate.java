package org.opentmf.tmf714.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.PlaceRefOrValue;
import org.opentmf.common.model.QualificationCreateBase;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.commons.validation.constraints.Required;

/**
 * CheckWorkQualification is used to validate specific units of work
 * <br/>Skipped properties:
 * id,href,state,effectiveQualificationDate,qualificationResult,expirationDate,checkWorkQualificationDate,estimatedResponseDate,workQualificationItem.alternateWorkProposal,workQualificationItem.state,workQualificationItem.qualificationResult.
 *
 * <p><br/>
 * <strong>Required:</strong> workQualificationItem<br/>
 * </p>
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
    defaultImpl = CheckWorkQualificationCreate.class
)
@Required(fields = {"workQualificationItem"})
public class CheckWorkQualificationCreate extends QualificationCreateBase implements ICheckWorkQualificationCreate {

  /**
   * A place described by reference or by value linked to a specific entity. The
   * polymorphic attributes {@literal @}type, {@literal @}schemaLocation & {@literal @}referredType are related to
   * the place entity and not the PlaceRefOrValue class itself.
   */
  private @Valid PlaceRefOrValue place;

  /**
   * When the value is TRUE means that alternative solutions should be provided.
   */
  private Boolean provideAlternative;

  /**
   * When the value is TRUE means that unavailability reason are expected for non
   * available units of work.
   */
  private Boolean provideUnavailabilityReason;

  /**
   * A list of related party references, defines party or party role linked to
   * this request.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * List of: A WorkQualificationItem relates to a specific unit of work being
   * checked in a qualification operation.
   */
  @JsonProperty("workQualificationItem")
  private @Size(min = 1) List<@Valid CheckWorkQualificationItem> workQualificationItems;
}