package org.opentmf.tmf728.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * Represents rules to apply to create a dunning case: the events that trigger
 * dunning rules evaluation, the conditions to evaluate and the actions that
 * must be done.
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
    defaultImpl = DunningRule.class
)
public class DunningRule extends DunningRuleUpdate implements IDunningRule {

  /**
   * Hyperlink, a reference to the dunning rule.
   */
  private URI href;

  /**
   * Unique identifier for the dunning rule.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}