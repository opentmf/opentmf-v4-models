package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Indicates the comments entered on the alarm.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-642: Alarm Management API</li>
 *   <li>TMF-908: IoT Agent and Device Management API</li>
 *   <li>TMF-915: AI Management API</li>
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
    defaultImpl = Comment.class
)
public class Comment extends Extensible implements IComment {

  /**
   * Indicates the text of the comment.
   */
  private @SafeText String comment;

  /**
   * Indicates the system identifier on which the client set the comment.
   */
  @SafeId
  @Size(max = 100)
  private String systemId;

  /**
   * Indicates the time commenting the alarm.
   */
  private OffsetDateTime time;

  /**
   * Indicates the user commenting the alarm.
   */
  @SafeId
  @Size(max = 100)
  private String userId;
}