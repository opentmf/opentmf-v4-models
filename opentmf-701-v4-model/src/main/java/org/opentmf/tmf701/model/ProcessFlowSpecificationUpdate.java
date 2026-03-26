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

/**
 * ProcessFlowSpecification is a class that allow to describe a processFlow
 * design. A ProcessFlow instance as used in TMF701 will use a
 * ProcessFlowSpecification as reference.
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
public class ProcessFlowSpecificationUpdate extends IntentUpdateBase implements IProcessFlowSpecificationUpdate {

  /**
   * Attachments that may be of relevance to this processFlowSpecification, such
   * as picture, document, media. This could be for example a how-to o a faq to
   * explain this processFlowSpecification.
   */
  @JsonProperty("attachment")
  private List<@Valid AttachmentRefOrValue> attachments;

  /**
   * A list of channel(s) where this processFlowSpecification instance could be
   * executed.
   */
  @JsonProperty("channel")
  private List<@Valid ChannelRef> channels;

  /**
   * List of characteristics that the processFlowSpecification can take.
   */
  @JsonProperty("processFlowSpecificationCharacteristic")
  private List<@Valid CharacteristicSpecification> processFlowSpecificationCharacteristics;

  /**
   * Relationship to another processFlowSpecification.
   */
  @JsonProperty("processFlowSpecificationRelationship")
  private List<@Valid ProcessFlowSpecificationRelationship> processFlowSpecificationRelationships;

  /**
   * A list of entity specification that will be managed by this
   * processFlowSpecification.
   */
  @JsonProperty("relatedEntitySpecification")
  private List<@Valid RelatedEntitySpecification> relatedEntitySpecifications;

  /**
   * Parties who manage or otherwise have an interest in this
   * processFlowSpecification.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * A list of taskFlowSpecification that will be managed by this
   * processFlowSpecification.
   */
  @JsonProperty("taskFlowSpecification")
  private List<@Valid TaskFlowSpecificationRef> taskFlowSpecifications;
}