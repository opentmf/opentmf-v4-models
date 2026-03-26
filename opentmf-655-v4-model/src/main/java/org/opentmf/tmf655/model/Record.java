package org.opentmf.tmf655.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Entity;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A record in a worklog.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-655: Change Management API</li>
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
    defaultImpl = Record.class
)
public class Record extends Entity implements IRecord {

  /**
   * The date time that a record is generated.
   */
  private OffsetDateTime dateTime;

  /**
   * The detail description in a record.
   */
  private @SafeText String description;

  /**
   * The person who logged that record.
   */
  private @SafeText String supportPerson;
}