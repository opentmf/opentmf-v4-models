package org.opentmf.tmf701.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.ChannelRef;
import org.opentmf.common.model.Characteristic;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.ProcessFlowSpecificationRef;
import org.opentmf.common.model.RelatedEntity;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Skipped properties: id,href,state,taskFlow,processFlowDate.
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
    defaultImpl = ProcessFlowCreate.class
)
public class ProcessFlowCreate extends Extensible implements IProcessFlowCreate {

  /**
   * A list of channel(s) where this processFlow is executed.
   */
  @JsonProperty("channel")
  private List<@Valid ChannelRef> channels;

  /**
   * A list of characteristic(s) associated to this processFlow.
   */
  @JsonProperty("characteristic")
  private List<@Valid Characteristic> characteristics;

  /**
   * Identifier of the Process flow specification.
   */
  private @SafeText String processFlowSpecification;

  /**
   * A reference to a ProcessFlowSpecification defined design-time.
   */
  private @Valid ProcessFlowSpecificationRef processFlowSpecificationRef;

  /**
   * A list of related entity(ies) to this processFlow.
   */
  @JsonProperty("relatedEntity")
  private List<@Valid RelatedEntity> relatedEntities;

  /**
   * A list of related party(ies) to this processFlow.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;
}