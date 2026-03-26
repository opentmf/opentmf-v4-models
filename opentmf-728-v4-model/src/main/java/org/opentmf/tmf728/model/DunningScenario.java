package org.opentmf.tmf728.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * A dunning scenario describes a company’s dunning strategy. It must be easily
 * configurable to describe the dunning rules to apply to a case, the order in
 * which applying them, the events that trigger dunning rules evaluation and the
 * actions that must be done.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-728: Dunning Case Management</li>
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
    defaultImpl = DunningScenario.class
)
public class DunningScenario extends DunningScenarioUpdate implements IDunningScenario {

  /**
   * Hyperlink, a reference to the dunning scenario.
   */
  private URI href;

  /**
   * Unique identifier for the dunning scenario.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}