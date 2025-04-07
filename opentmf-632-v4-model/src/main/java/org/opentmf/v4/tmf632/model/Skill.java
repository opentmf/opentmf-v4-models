package org.opentmf.v4.tmf632.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.Extensible;
import org.opentmf.v4.common.model.TimePeriod;

/**
 * Skills evaluated for an individual with a level and possibly with a limited
 * validity when an obsolescence is defined (Ex: the first-aid certificate first
 * level is limited to one year and an update training is required each year to
 * keep the level).
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-632: Party Management API</li>
 * </ul>
 * </p>
 *
 * @author Gokhan Demir
 */
@Getter
@Setter
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = Skill.class
)
public class Skill extends Extensible {

  /**
   * A free text comment linked to the evaluation done.
   */
  private @SafeText String comment;

  /**
   * Level of expertise in a skill evaluated for an individual.
   */
  private @SafeText String evaluatedLevel;

  /**
   * Code of the skill.
   */
  private @SafeText String skillCode;

  /**
   * Name of the skill such as Java language,….
   */
  private @SafeText String skillName;

  private @Valid TimePeriod validFor;
}