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
 * A JeopardyAlert represents a predicted exception during a process that may
 * cause a risk to complete successfully the process.
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
    defaultImpl = JeopardyAlert.class
)
public class JeopardyAlert extends Extensible {

  /**
   * identifier of the JeopardyAlert.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * A date time( DateTime). The date that the alert issued.
   */
  private OffsetDateTime alertDate;

  /**
   * The exception associated with this jeopardy alert.
   */
  private @SafeText String exception;

  /**
   * A string represents the type of jeopardy/risk like Normal, Hazard, Critical,
   * ...
   */
  private @SafeText String jeopardyType;

  /**
   * A string represents the message of the alert.
   */
  private @SafeText String message;

  /**
   * A string used to give a name to the jeopardy alert.
   */
  private @SafeText String name;
}