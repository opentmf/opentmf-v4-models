package org.opentmf.tmf671.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Contains the conditions and benefits of the promotion toan eligible party.
 *
 * <p><br/>
 * <strong>Required:</strong> action, criteriaGroup<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-671: Promotion Management API</li>
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
    defaultImpl = PromotionPattern.class
)
@Required(fields = {"criteriaGroup", "action"})
public class PromotionPattern extends Extensible implements IPromotionPattern {

  /**
   * List of: Action of the promotion. When the customer meets the conditions in
   * the promotion pattern, the customer can be given the benefits in the action.
   */
  @JsonProperty("action")
  private @Size(min = 1) List<@Valid PromotionAction> actions;

  /**
   * List of: Set of group criteria to promotion. Fulfilling these criteria,
   * parties will receice benefits.
   */
  @JsonProperty("criteriaGroup")
  private @Size(min = 1) List<@Valid PromotionCriteriaGroup> criteriaGroups;

  /**
   * Logical relation followed by the criteria group.
   */
  private @SafeText String criteriaGroupLogicalRelationship;

  /**
   * Small description to clarify the pattern details.
   */
  private @SafeText String description;

  /**
   * Unique identifier of promotion pattern.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * Alias to promotion pattern. This way is easily mentioned.
   */
  private @SafeText String name;

  /**
   * Priority. Smaller number means high.
   */
  private Integer priority;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;
}