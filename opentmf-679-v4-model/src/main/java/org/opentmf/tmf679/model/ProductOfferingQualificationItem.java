package org.opentmf.tmf679.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.EligibilityUnavailabilityReason;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.Note;
import org.opentmf.common.model.ProductOfferingRef;
import org.opentmf.common.model.ProductRefOrValue;
import org.opentmf.common.model.TerminationError;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 *
 * <p><br/>
 * <strong>Required:</strong> id<br/>
 * </p>
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
    defaultImpl = ProductOfferingQualificationItem.class
)
@Required(fields = {"id"})
public class ProductOfferingQualificationItem extends Extensible implements IProductOfferingQualificationItem {

  /**
   * action to be performed on the product
   * <br/><p>Recommended values: add, modify, delete, noChange.
   *
   * @see org.opentmf.tmf679.model.ProductActionType
   */
  private @SafeText String action;

  /**
   * List of: Alternate product Offering proposal is used when the requested
   * product offering is not available with characteristic and date asked for. An
   * alternate proposal could be a distinct product offering or product Spec close
   * to requested one or same as requested but with a different activation date.
   */
  @JsonProperty("alternateProductOfferingProposal")
  private List<@Valid AlternateProductOfferingProposal> alternateProductOfferingProposals;

  /**
   * List of: Reason for eligibility result if the productOfferingQualification
   * result is no (meaning the productOffering or productSpec is not available).
   */
  @JsonProperty("eligibilityUnavailabilityReason")
  private List<@Valid EligibilityUnavailabilityReason> eligibilityUnavailabilityReasons;

  /**
   * Date when the requester look for productOfferingQualification activation.
   */
  private OffsetDateTime expectedActivationDate;

  /**
   * Id of the productOfferingQualification item.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * List of: Extra information about a given entity.
   */
  @JsonProperty("note")
  private List<@Valid Note> notes;

  /**
   * A product to be created defined by value or existing defined by reference.
   * The polymorphic attributes {@literal @}type, {@literal @}schemaLocation & {@literal @}referredType are related
   * to the product entity and not the RelatedProductRefOrValue class itself.
   */
  private @Valid ProductRefOrValue product;

  /**
   * ProductOffering reference. A product offering represents entities that are
   * orderable from the provider of the catalog, this resource includes pricing
   * information.
   */
  private @Valid ProductOfferingRef productOffering;

  /**
   * List of: Structure used to describe relationship between
   * productOfferingQualification item from the same ProductOfferingQualification.
   */
  @JsonProperty("qualificationItemRelationship")
  private List<@Valid QualificationItemRelationship> qualificationItemRelationships;

  /**
   * Qualification result for this productOfferingQualification item. It could be:
   * <br/>
   * <br/> qualified (request productOffering or productSpecification are
   * available), 
   * <br/> unqualified (requested not available and not alternate available),
   * <br/> alternate (requested not available but proposal available).
   */
  private @SafeText String qualificationItemResult;

  /**
   * Possible values for the state of a task
   * <br/><p>Recommended values: acknowledged, terminatedWithError, inProgress,
   * done.
   *
   * @see org.opentmf.common.model.TaskStateType
   */
  private @SafeText String state;

  /**
   * List of: This indicates an error that caused a qualificationItem to be
   * terminated.
   */
  @JsonProperty("terminationError")
  private List<@Valid TerminationError> terminationErrors;
}