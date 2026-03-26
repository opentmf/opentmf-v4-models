package org.opentmf.tmf728.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Characteristic;
import org.opentmf.common.model.Extensible;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Represents rules to apply to create a dunning case: the events that trigger
 * dunning rules evaluation, the conditions to evaluate and the actions that
 * must be done
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> dunningAction, dunningEvent<br/>
 * </p>
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
    defaultImpl = DunningRuleCreate.class
)
@Required(fields = {"dunningEvent", "dunningAction"})
public class DunningRuleCreate extends Extensible implements IDunningRuleCreate {

  /**
   * The action to be executed when the dunningEvent occurs if the dunning
   * condition evaluates to true. Can be either "DunningNotification",
   * "AppliedCustomerFeeCharge", "ProductOrder", "CustomerBill" or
   * "DunningWriteOff".
   */
  private @SafeText String dunningAction;

  /**
   * A condition to check on the customer account or the customer bill, after a
   * dunning event has been fired, before dunning action is executed. Format is
   * the same as the predicate used for querying resources with attribute
   * filtering. Format for the values and variables of the expression is
   * implementation dependent.
   */
  private @SafeText String dunningCondition;

  /**
   * A string describing the name of the fields of an event that should be
   * monitored for changes. It should be in the same format as the query string
   * used to subscribe to events from an API following hub/notification pattern.
   */
  private @SafeText String dunningEvent;

  /**
   * List of: Describes a given characteristic of an object or entity through a
   * name/value pair.
   */
  @JsonProperty("dunningRuleCharacteristic")
  private List<@Valid Characteristic> dunningRuleCharacteristics;

  /**
   * Name of the dunning rule.
   */
  private @SafeText String name;
}