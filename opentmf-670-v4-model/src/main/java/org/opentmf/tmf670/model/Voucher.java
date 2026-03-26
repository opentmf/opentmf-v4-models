package org.opentmf.tmf670.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.PaymentMethod;
import org.opentmf.common.model.Quantity;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A voucher method of payment.
 *
 * <p><br/>
 * <strong>Required:</strong> @type, code, expirationDate, name, value<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-670: Payment Method Management API</li>
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
    defaultImpl = Voucher.class
)
@Required(fields = {"code", "atType", "name", "value", "expirationDate"})
public class Voucher extends PaymentMethod implements IVoucher {

  /**
   * Campaign this voucher belongs to.
   */
  private @SafeText String campaign;

  /**
   * Code that identifies the voucher.
   */
  private @SafeText String code;

  /**
   * The discount that the voucher applies when it's a discount voucher.
   */
  private @SafeText String discount;

  /**
   * The voucher's expiration date.
   */
  private OffsetDateTime expirationDate;

  /**
   * An amount in a given unit.
   */
  private @Valid Quantity value;
}