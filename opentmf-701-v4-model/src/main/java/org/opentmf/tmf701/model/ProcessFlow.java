package org.opentmf.tmf701.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.net.URI;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
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
    defaultImpl = ProcessFlow.class
)
public class ProcessFlow extends ProcessFlowCreate implements IProcessFlow {

  /**
   * Reference of the ProcessFlow.
   */
  private URI href;

  /**
   * Identifier of the Process flow.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * Is the date when the processFlow was created in basse (timestamp).
   */
  private OffsetDateTime processFlowDate;

  /**
   * Valid values for the lifecycle state of the processFlow
   * <br/><p>Recommended values: active, cancelled, hold, completed.
   *
   * @see org.opentmf.tmf701.model.ProcessFlowStateType
   */
  private @SafeText String state;

  /**
   * A list of taskflow related to this processFlow.
   */
  @JsonProperty("taskFlow")
  private List<@Valid TaskFlowRef> taskFlows;
}