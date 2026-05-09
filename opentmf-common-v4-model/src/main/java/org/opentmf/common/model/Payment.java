package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.net.URI;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * The Payment resource represents a performed payment. It contains both
 * information about the payment and the payment method used to perform it.
 *
 * <p><br/>
 * <strong>Required:</strong> account, paymentMethod<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-658: Loyalty</li>
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
    defaultImpl = Payment.class
)
@Required(fields = {"paymentMethod", "account"})
public class Payment extends PaymentCreate implements IPayment {

  /**
   * Hypertext Reference of the Payment.
   */
  private URI href;

  /**
   * Unique identifier of Payment.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * Date when the payment was performed.
   */
  private OffsetDateTime paymentDate;

  /**
   * POI consists of hardware and software which enables a Cardholder and/or an
   * Acceptor to perform a Local Card transaction. This is also referred to as a
   * Physical/EMV Terminal. It may be Attended or Unattended.
   */
  private @Valid PointOfInteraction pointOfInteraction;

  /**
   * List of: Related Party reference. A related party defines party or party role
   * linked to a specific entity.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * Status of the payment.
   */
  private @SafeText String status;

  /**
   * Date when the status was recorded.
   */
  private OffsetDateTime statusDate;
}