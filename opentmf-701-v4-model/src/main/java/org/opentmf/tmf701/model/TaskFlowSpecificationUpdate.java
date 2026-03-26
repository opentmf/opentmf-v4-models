package org.opentmf.tmf701.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AttachmentRefOrValue;
import org.opentmf.common.model.ChannelRef;
import org.opentmf.common.model.CharacteristicSpecification;
import org.opentmf.common.model.IntentUpdateBase;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * TaskFlowSpecification is a class that allow to describe a TaskFlow
 * specification design. A TaskFlow instance as used in TMF701 will use a
 * TaskFlowSpecification as reference.
 * <br/>Skipped properties: id,href,{@literal @}baseType,{@literal @}schemaLocation,{@literal @}type,lastUpdate.
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
public class TaskFlowSpecificationUpdate extends IntentUpdateBase implements ITaskFlowSpecificationUpdate {

  /**
   * Attachments that may be of relevance to this TaskFlowSpecification, such as
   * picture, document, media. This could be for example a how-to or a faq to
   * explain this TaskFlowSpecification.
   */
  @JsonProperty("attachment")
  private List<@Valid AttachmentRefOrValue> attachments;

  /**
   * A list of channel(s) where this TaskFlowSpecification instance could be
   * executed.
   */
  @JsonProperty("channel")
  private List<@Valid ChannelRef> channels;

  /**
   * A list of entity specification that will be managed by this
   * TaskFlowSpecification.
   */
  @JsonProperty("relatedEntitySpecification")
  private List<@Valid RelatedEntitySpecification> relatedEntitySpecifications;

  /**
   * Parties who manage or otherwise have an interest in this
   * TaskFlowSpecification.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * A related ProcessFlowSpecification (for example when the
   * taskFlowSpecification completion required another ProcessFLowSpecification to
   * be triggered & completed).
   */
  @JsonProperty("relatedProcessFlowSpecification")
  private List<@Valid RelatedEntitySpecification> relatedProcessFlowSpecifications;

  /**
   * Relationship to sub-TaskFlowSpecification.
   */
  @JsonProperty("taskFlowSpecification")
  private List<@Valid TaskFlowSpecification> taskFlowSpecifications;

  /**
   * List of characteristics that the TaskFlowSpecification can take.
   */
  @JsonProperty("taskFlowSpecificationCharacteristic")
  private List<@Valid CharacteristicSpecification> taskFlowSpecificationCharacteristics;

  /**
   * Relationship to another TaskFlowSpecification from a same
   * ProcessFlowSpecification.
   */
  @JsonProperty("taskFlowSpecificationRelationship")
  private List<@Valid TaskFlowSpecificationRelationship> taskFlowSpecificationRelationships;

  /**
   * Type of the TaskFlowSpecification like send task, receive task, user task,
   * manual task, script task, business rule task.
   */
  private @SafeText String taskFlowSpecificationType;
}