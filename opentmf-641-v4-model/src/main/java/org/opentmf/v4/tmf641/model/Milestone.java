package org.opentmf.v4.tmf641.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.Extensible;

/**
 * Milestone represents an action or event marking a significant change or stage
 * in a process like an order process.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-641: Service Ordering Management API</li>
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
    defaultImpl = Milestone.class
)
public class Milestone extends Extensible {

  /**
   * identifier of the Milestone.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * free-text description of the Milestone.
   */
  private @SafeText String description;

  /**
   * A string represents the message of the milestone.
   */
  private @SafeText String message;

  /**
   * A date time( DateTime). The date that the milestone happens.
   */
  private OffsetDateTime milestoneDate;

  /**
   * A string used to give a name to the milestone.
   */
  private @SafeText String name;

  /**
   * The milestone status.
   */
  private @SafeText String status;
}