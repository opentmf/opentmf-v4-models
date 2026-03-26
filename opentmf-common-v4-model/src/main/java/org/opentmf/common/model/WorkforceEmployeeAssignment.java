package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Represents an assignment of a particular WorforceEmployeeRole for a
 * particular unit of work in a specific timeframe. For example, assignment of a
 * person in a network engineer role to a trouble shooting unit of work for at
 * least 2 hours. The assignment is associated with a TimeSlot.
 *
 * <p><br/>
 * <strong>Required:</strong> description, id, skillType, workforceEmployee<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-713: Work Management</li>
 *   <li>TMF-714: Work Qualification Management</li>
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
    defaultImpl = WorkforceEmployeeAssignment.class
)
@Required(fields = {"skillType", "description", "id", "workforceEmployee"})
public class WorkforceEmployeeAssignment extends Extensible implements IWorkforceEmployeeAssignment {

  private @SafeText String description;

  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * Ex: primarySkill, secondarySkill.
   */
  private @SafeText String skillType;

  /**
   * <p>Recommended values: acknowledged, rejected, pending, held, inProgress,
   * cancelled, completed, failed, partial.
   *
   * @see org.opentmf.common.model.WorkforceEmployeeAssignmentStateType
   */
  private @SafeText String state;

  @JsonProperty("timeSlot")
  private List<@Valid TimeSlot> timeSlots;

  private @Valid PartyRefOrValue workforceEmployee;
}