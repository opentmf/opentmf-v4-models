package org.opentmf.tmf676.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * The Refund resource represents a performed Refund. It contains both
 * information about the refund and the payment method used to perform it.
 *
 * <p><br/>
 * <strong>Required:</strong> account, paymentMethod<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-676: Payment Management API</li>
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
    defaultImpl = Refund.class
)
@Required(fields = {"paymentMethod", "account"})
public class Refund extends RefundCreate implements IRefund {

  /**
   * Hypertext Reference of the refund.
   */
  private URI href;

  /**
   * Unique identifier of Refund.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * Status of the refund.
   */
  private @SafeText String status;

  /**
   * Date when the status was recorded.
   */
  private OffsetDateTime statusDate;
}