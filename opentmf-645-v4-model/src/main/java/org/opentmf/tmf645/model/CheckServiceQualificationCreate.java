package org.opentmf.tmf645.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.QualificationCreateBase;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.commons.validation.constraints.Required;

/**
 * CheckServiceQualification is used to perform a technical eligibility on
 * service configuration(s). It allows to retrieve services that are technically
 * available in the context of the interaction (place, party, service
 * characteristics, ...).
 * <br/>Skipped properties:
 * id,href,state,effectiveQualificationDate,qualificationResult,expirationDate,checkServiceQualificationDate,estimatedResponseDate,serviceQualificationItem.alternateServiceProposal,serviceQualificationItem.state,serviceQualificationItem.qualificationResult.
 *
 * <p><br/>
 * <strong>Required:</strong> serviceQualificationItem<br/>
 * </p>
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
    defaultImpl = CheckServiceQualificationCreate.class
)
@Required(fields = {"serviceQualificationItem"})
public class CheckServiceQualificationCreate extends QualificationCreateBase implements ICheckServiceQualificationCreate {

  /**
   * When the value is TRUE means that alternative solutions should be provided.
   */
  private Boolean provideAlternative;

  /**
   * When the value is TRUE means that unavailability reason are expected for non
   * available service.
   */
  private Boolean provideUnavailabilityReason;

  /**
   * A list of related party references, defines party or party role linked to
   * this request.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * A list of service qualification items.
   */
  @JsonProperty("serviceQualificationItem")
  private @Size(min = 1) List<@Valid CheckServiceQualificationItem> serviceQualificationItems;
}