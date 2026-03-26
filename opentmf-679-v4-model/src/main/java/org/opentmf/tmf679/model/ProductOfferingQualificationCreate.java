package org.opentmf.tmf679.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.CategoryRef;
import org.opentmf.common.model.ChannelRef;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.Note;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.common.model.RelatedPlaceRefOrValue;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * ProductOfferingQualification is used to perform a commercial eligibility. It
 * allows to retrieve a list of productOffering that are commercially available
 * in the context of the interaction (defined be place, channel, party,
 * product).
 * <br/>Skipped properties:
 * id,href,state,expectedPOQCompletionDate,effectiveQualificationDate,expirationDate,productOfferingQualificationDate,qualificationResult,productOfferingQualificationItem.state,productOfferingQualificationItem.qualificationItemResult,productOfferingQualificationItem.alternateProductOfferingProposal.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-679: Product Offering Qualification Management API</li>
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
    defaultImpl = ProductOfferingQualificationCreate.class
)
public class ProductOfferingQualificationCreate extends Extensible implements IProductOfferingQualificationCreate {

  /**
   * The category for grouping recommendations.
   */
  private @Valid CategoryRef category;

  /**
   * The channel to which the resource reference to. e.g. channel for selling
   * product offerings, channel for opening a trouble ticket etc..
   */
  private @Valid ChannelRef channel;

  /**
   * Description of the productOfferingQualification.
   */
  private @SafeText String description;

  /**
   * An indicator which when the value is "true" means that requester expects to
   * get qualifcation result immediately in the response. If the indicator is true
   * then the response code of 200 indicates the operation is successful otherwise
   * a task is created with a response 201.
   */
  private Boolean instantSyncQualification;

  /**
   * Free form text associated with the qualification request.
   */
  @JsonProperty("note")
  private List<@Valid Note> notes;

  /**
   * List of: Related Entity reference. A related place defines a place described
   * by reference or by value linked to a specific entity. The polymorphic
   * attributes {@literal @}type, {@literal @}schemaLocation & {@literal @}referredType are related to the place
   * entity and not the RelatedPlaceRefOrValue class itself.
   */
  @JsonProperty("place")
  private List<@Valid RelatedPlaceRefOrValue> places;

  /**
   * Qualification item for a product or a category.
   */
  @JsonProperty("productOfferingQualificationItem")
  private List<@Valid ProductOfferingQualificationItem> productOfferingQualificationItems;

  /**
   * An indicator which when the value is "true" means that alternative solutions
   * should be provided.
   */
  private Boolean provideAlternative;

  /**
   * An indicator which when the value is "true" means that only available product
   * offering must be listed in the response.
   */
  private Boolean provideOnlyAvailable;

  /**
   * An indicator which when the value is "true" means that unavailability reason
   * are expected for non available product offering.
   */
  private Boolean provideUnavailabilityReason;

  /**
   * Party playing a role for this qualification (as requester for example).
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * Deadline date when the requester expected a qualification answer.
   */
  private OffsetDateTime requestedPOQCompletionDate;
}