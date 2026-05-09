package org.opentmf.tmf701.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.ChannelRef;
import org.opentmf.common.model.Characteristic;
import org.opentmf.common.model.RelatedEntity;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.common.model.TaskFlowSpecificationRef;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Skipped properties:
 * id,href,taskFlowSpecification,{@literal @}baseType,{@literal @}schemaLocation,{@literal @}type,startDate,completionDate.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-701: Process Flow Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class TaskFlowUpdate implements ITaskFlowUpdate {

  /**
   * A list of channel(s) where this taskFlow is executed.
   */
  @JsonProperty("channel")
  private List<@Valid ChannelRef> channels;

  /**
   * A list of characteristic(s) associated to this taskFlow.
   */
  @JsonProperty("characteristic")
  private List<@Valid Characteristic> characteristics;

  /**
   * TaskFlow completion method.
   */
  private @SafeText String completionMethod;

  /**
   * Indicate mandatory TaskFlow.
   */
  private Boolean isMandatory;

  /**
   * TaskFlow priority.
   */
  private Integer priority;

  /**
   * A list of related entity(ies) to this taskFlow.
   */
  @JsonProperty("relatedEntity")
  private List<@Valid RelatedEntity> relatedEntities;

  /**
   * A list of related party(ies) to this task.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * Requested completion date for this task.
   */
  private OffsetDateTime requestedCompletionDate;

  /**
   * Requested start date for this task.
   */
  private OffsetDateTime requestedStartDate;

  /**
   * Valid values for the lifecycle state of the taskFlow
   * <br/><p>Recommended values: new, active, hold, cancelled, completed.
   *
   * @see org.opentmf.tmf701.model.TaskFlowStateType
   */
  private @SafeText String state;

  /**
   * A list of taskFlows related to this taskFlow.
   */
  @JsonProperty("taskFlowRelationship")
  private List<@Valid TaskFlowRelationship> taskFlowRelationships;

  /**
   * A reference to a TaskFlowSpecification defined design-time.
   */
  private @Valid TaskFlowSpecificationRef taskFlowSpecificationRef;
}