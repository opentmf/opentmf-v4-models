package org.opentmf.tmf701.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.ChannelRef;
import org.opentmf.common.model.Characteristic;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.RelatedEntity;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.common.model.TaskFlowSpecificationRef;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Skipped properties: id,href,state,priority,isMandatory,completionMethod,url.
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
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = TaskFlowCreate.class
)
public class TaskFlowCreate extends Extensible implements ITaskFlowCreate {

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
   * Effective completion date for this task.
   */
  private OffsetDateTime completionDate;

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
   * Effective start date for this task.
   */
  private OffsetDateTime startDate;

  /**
   * A list of taskFlows related to this taskFlow.
   */
  @JsonProperty("taskFlowRelationship")
  private List<@Valid TaskFlowRelationship> taskFlowRelationships;

  /**
   * Reference of the TaskFlowSpecification.
   */
  private @SafeText String taskFlowSpecification;

  /**
   * A reference to a TaskFlowSpecification defined design-time.
   */
  private @Valid TaskFlowSpecificationRef taskFlowSpecificationRef;
}