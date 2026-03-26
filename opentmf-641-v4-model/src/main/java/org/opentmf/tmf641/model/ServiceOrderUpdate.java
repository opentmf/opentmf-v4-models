package org.opentmf.tmf641.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.ExternalReference;
import org.opentmf.common.model.Note;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Skipped properties:
 * id,href,orderDate,jeopardyAlert,errorMessage,milestone,{@literal @}baseType,{@literal @}schemaLocation,{@literal @}type,cancellationDate,cancellationReason,category,completionDate,startDate.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-641: Service Ordering Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class ServiceOrderUpdate implements IServiceOrderUpdate {

  /**
   * A free-text description of the service order.
   */
  private @SafeText String description;

  /**
   * Expected delivery date amended by the provider.
   */
  private OffsetDateTime expectedCompletionDate;

  /**
   * ID given by the consumer to facilitate searches.
   */
  @SafeId
  @Size(max = 100)
  private String externalId;

  /**
   * List of: External reference of the individual or reference in other system.
   */
  @JsonProperty("externalReference")
  private List<@Valid ExternalReference> externalReferences;

  /**
   * Extra-information about the order; e.g. useful to add extra delivery
   * information that could be useful for a human process.
   */
  @JsonProperty("note")
  private List<@Valid Note> notes;

  /**
   * Contact attached to the order to send back information regarding this order.
   */
  private @SafeText String notificationContact;

  /**
   * A list of service orders related to this order (e.g. prerequisite, dependent
   * on).
   */
  @JsonProperty("orderRelationship")
  private List<@Valid ServiceOrderRelationship> orderRelationships;

  /**
   * Can be used by consumers to prioritize orders in a Service Order Management
   * system.
   */
  private @SafeText String priority;

  /**
   * A list of parties which are involved in this order and the role they are
   * playing.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * Requested delivery date from the requesters perspective.
   */
  private OffsetDateTime requestedCompletionDate;

  /**
   * Order start date wished by the requester.
   */
  private OffsetDateTime requestedStartDate;

  /**
   * A list of service order items to be processed by this order.
   */
  @JsonProperty("serviceOrderItem")
  private List<@Valid ServiceOrderItem> serviceOrderItems;

  /**
   * Possible values for the state of the order
   * <br/><p>Recommended values: acknowledged, rejected, pending, held,
   * inProgress, cancelled, completed, failed, partial, assessingCancellation,
   * pendingCancellation.
   *
   * @see org.opentmf.tmf641.model.ServiceOrderStateType
   */
  private @SafeText String state;
}