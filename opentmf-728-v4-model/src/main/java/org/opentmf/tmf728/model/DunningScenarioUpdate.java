package org.opentmf.tmf728.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.DunningRuleRef;
import org.opentmf.common.model.Extensible;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A dunning scenario describes a company’s dunning strategy. It must be easily
 * configurable to describe the dunning rules to apply to a case, the order in
 * which applying them, the events that trigger dunning rules evaluation and the
 * actions that must be done
 * <br/>Skipped properties: id,href.
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
    defaultImpl = DunningScenarioUpdate.class
)
public class DunningScenarioUpdate extends Extensible implements IDunningScenarioUpdate {

  /**
   * A categorization of an entry in the list of dunning scenarios such as
   * residentials or low risk.
   */
  private @SafeText String category;

  /**
   * A detailed description of the dunning scenario.
   */
  private @SafeText String description;

  /**
   * List of: Dunning rule reference.
   */
  @JsonProperty("dunningRule")
  private List<@Valid DunningRuleRef> dunningRules;

  /**
   * If true, indicates that the DunningScenario is the one to use by default if
   * no specific DunningScenario is specified for the CustomerAccount.
   */
  private Boolean isDefault;

  /**
   * A word or phrase by which a dunning scenario is known and distinguished from
   * other dunning scenarios.
   */
  private @SafeText String name;
}