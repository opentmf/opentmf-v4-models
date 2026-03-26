package org.opentmf.tmf728.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.Money;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * The DunningWriteOff corresponds, in a dunning context, to a credit to
 * definitively balance the CustomerAccount before being able to close it.
 *
 * <p><br/>
 * <strong>Required:</strong> id<br/>
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
    defaultImpl = DunningWriteOff.class
)
@Required(fields = {"id"})
public class DunningWriteOff extends Extensible implements IDunningWriteOff {

  /**
   * A base / value business entity used to represent money.
   */
  private @Valid Money amount;

  /**
   * The date on which the write off was created.
   */
  private OffsetDateTime creationDate;

  /**
   * Unique identifier for the write off.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * Reason for the write off. Can be Total or Partial.
   */
  private @SafeText String reason;

  /**
   * The current status of the write off.
   */
  private @SafeText String status;
}