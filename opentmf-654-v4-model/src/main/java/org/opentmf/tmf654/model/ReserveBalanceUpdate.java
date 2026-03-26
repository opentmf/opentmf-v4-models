package org.opentmf.tmf654.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * The ReserveBalance resource allows adjustments to be made to the original
 * BalanceTopup eg increment the amount, alter the recharge periodicity
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> reason, status<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-654: Prepay Balance Management API</li>
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
    defaultImpl = ReserveBalanceUpdate.class
)
@Required(fields = {"reason", "status"})
public class ReserveBalanceUpdate extends ReserveBalanceCreate implements IReserveBalanceUpdate {

  /**
   * Date when the deduction was confirmed in the server.
   */
  private OffsetDateTime confirmationDate;

  /**
   * Used to provide information about any other entity with relation to the
   * operation.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * Date when the deduction request was received in the server.
   */
  private OffsetDateTime requestedDate;

  /**
   * Valid values for the Action Status Type
   * <br/><p>Recommended values: created, failed, cancelled, completed.
   *
   * @see org.opentmf.tmf654.model.ActionStatusType
   */
  private @SafeText String status;
}