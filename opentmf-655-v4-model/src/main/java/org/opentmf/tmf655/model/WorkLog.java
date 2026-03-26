package org.opentmf.tmf655.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Entity;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A record of the work performed on the change request during the investigation
 * and resolution process.
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
    defaultImpl = WorkLog.class
)
public class WorkLog extends Entity implements IWorkLog {

  /**
   * Date and time of worklog generated.
   */
  private OffsetDateTime createDateTime;

  /**
   * The description of the worklog.
   */
  private @SafeText String description;

  /**
   * Date and time when the worklog updated.
   */
  private @SafeText String lastUpdateDateTime;

  /**
   * List of: A record in a worklog.
   */
  @JsonProperty("record")
  private List<@Valid Record> records;
}