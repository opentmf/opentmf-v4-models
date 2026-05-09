package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-713: Work Management</li>
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
    defaultImpl = WorkUpdate.class
)
public class WorkUpdate extends Extensible implements IWorkUpdate {

  /**
   * An amount in a given unit.
   */
  private @Valid Quantity actualDuration;

  /**
   * List of: Agreement reference. An agreement represents a contract or
   * arrangement, either written or verbal and sometimes enforceable by law, such
   * as a service level agreement or a customer price agreement. An agreement
   * involves a number of other business entities, such as products, services, and
   * resources and/or their specifications.
   */
  @JsonProperty("agreement")
  private List<@Valid AgreementRef> agreements;

  /**
   * Refers an appointment, such as a Customer presentation or internal meeting or
   * site visit.
   */
  private @Valid AppointmentRef appointment;

  /**
   * Date when the order was completed.
   */
  private OffsetDateTime completionDate;

  /**
   * An amount in a given unit.
   */
  private @Valid Quantity currentDuration;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod deliveryTimeSlot;

  /**
   * Is the description of the work unit. It could be the same as the description
   * of the work specification.
   */
  private @SafeText String description;

  /**
   * Date when the requester expects the work to be completed.
   */
  private OffsetDateTime expectedCompletionDate;

  /**
   * Name of the work unit. It could be the same as the name of the work
   * specification.
   */
  private @SafeText String name;

  /**
   * Extra information about a given entity.
   */
  private @Valid Note note;

  /**
   * Date at which the work order which triggered this unit of work's
   * creation/change/termination was created.
   */
  private OffsetDateTime orderDate;

  private BigDecimal percentageComplete;

  /**
   * List of: Related Entity reference. A related place defines a place described
   * by reference or by value linked to a specific entity. The polymorphic
   * attributes {@literal @}type, {@literal @}schemaLocation & {@literal @}referredType are related to the place
   * entity and not the RelatedPlaceRefOrValue class itself.
   */
  @JsonProperty("place")
  private List<@Valid RelatedPlaceRefOrValue> places;

  /**
   * An amount in a given unit.
   */
  private @Valid Quantity plannedDuration;

  /**
   * An amount in a given unit.
   */
  private @Valid Quantity quantity;

  /**
   * List of: Related Party reference. A related party defines party or party role
   * linked to a specific entity.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * An amount in a given unit.
   */
  private @Valid Quantity scheduledDuration;

  /**
   * <p>Recommended values: acknowledged, rejected, pending, held, inProgress,
   * cancelled, completed, failed, partial.
   *
   * @see org.opentmf.common.model.WorkStateType
   */
  private @SafeText String state;

  /**
   * List of: A Unit of Work defined by value or existing defined by reference.
   * The polymorphic attributes {@literal @}type, {@literal @}schemaLocation &amp; {@literal @}referredType are
   * related to the work entity and not the related WorkRefOrValue class itself.
   */
  @JsonProperty("work")
  private List<@Valid WorkRefOrValue> works;

  /**
   * List of: Describes a given characteristic of an object or entity through a
   * name/value pair.
   */
  @JsonProperty("workCharacteristic")
  private List<@Valid Characteristic> workCharacteristics;

  /**
   * List of: RelatedWorkOrderItem (WorkOrder item). The work order item which
   * triggered this unit of work's creation/change/termination.
   */
  @JsonProperty("workOrderItem")
  private List<@Valid RelatedWorkOrderItem> workOrderItems;

  /**
   * List of: An amount, usually of money, that represents the actual price paid
   * by the Customer for this item or this order.
   */
  @JsonProperty("workPrice")
  private List<@Valid WorkPrice> workPrices;

  private @SafeText String workPriority;

  @JsonProperty("workRelationship")
  private List<@Valid WorkRelationship> workRelationships;

  /**
   * Work specification reference.
   */
  private @Valid WorkSpecificationRef workSpecification;

  private @SafeText String workType;

  /**
   * List of: Represents an assignment of a particular WorforceEmployeeRole for a
   * particular unit of work in a specific timeframe. For example, assignment of a
   * person in a network engineer role to a trouble shooting unit of work for at
   * least 2 hours. The assignment is associated with a TimeSlot.
   */
  @JsonProperty("workforceEmployeeAssignment")
  private List<@Valid WorkforceEmployeeAssignment> workforceEmployeeAssignments;
}