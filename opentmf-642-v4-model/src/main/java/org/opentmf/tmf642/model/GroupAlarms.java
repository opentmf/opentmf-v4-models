package org.opentmf.tmf642.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * Task resource for group alarms operation.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-642: Alarm Management API</li>
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
    defaultImpl = GroupAlarms.class
)
public class GroupAlarms extends GroupAlarmsCreate implements IGroupAlarms {

  /**
   * A reference to the task.
   */
  private URI href;

  /**
   * The identifier of the task.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}