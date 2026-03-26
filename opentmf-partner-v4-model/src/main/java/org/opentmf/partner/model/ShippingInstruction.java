package org.opentmf.partner.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Characteristic;
import org.opentmf.common.model.Entity;
import org.opentmf.common.model.Money;
import org.opentmf.common.model.Note;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Instructions and details for the carrier.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-700: Shipping Order Management API</li>
 *   <li>TMF-711: Shipment Management Management API</li>
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
    defaultImpl = ShippingInstruction.class
)
public class ShippingInstruction extends Entity implements IShippingInstruction {

  /**
   * The carrier identifier.
   */
  @SafeId
  @Size(max = 100)
  private String carrierId;

  /**
   * The carrier name.
   */
  private @SafeText String carrierName;

  /**
   * The service code used by the carrier to ship the package, royal mail ground,
   * royal mail first class, etc.
   */
  private @SafeText String carrierServiceCode;

  /**
   * Shipping delivery attempts that should be performed.
   */
  private Integer deliveryAttempts;

  /**
   * Shipping delivery speed, same day, next day, next business day, etc.
   */
  private @SafeText String deliverySpeed;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod deliveryTimeSlot;

  /**
   * Additional shipping characteristics that maybe specific to one or another
   * carrier.
   */
  @JsonProperty("instructionCharacteristic")
  private List<@Valid Characteristic> instructionCharacteristics;

  /**
   * A base / value business entity used to represent money.
   */
  private @Valid Money insuredValue;

  /**
   * Shipping delivery message label.
   */
  private @SafeText String labelMessage;

  /**
   * A list of notes made on this shipment item.
   */
  @JsonProperty("note")
  private List<@Valid Note> notes;

  /**
   * The type of packaging.
   */
  private @SafeText String packageType;

  /**
   * Delivery confirmation required for the shipment (none, signature,
   * over18Signature).
   */
  private @SafeText String receiptConfirmation;

  /**
   * The shipping type, e.g. thick_envelope, small_flat_rate_box, large_package,
   * etc.
   */
  private @SafeText String shippingType;

  private Boolean signatureRequired;

  /**
   * Possible values for the signature requirement upon receiving the shipment
   * <br/><p>Recommended values: adult, receiver.
   *
   * @see org.opentmf.partner.model.SignatureRequiredByType
   */
  private @SafeText String signatureRequiredBy;

  /**
   * The identification of the warehouse that the shipment is being shipped from.
   */
  @SafeId
  @Size(max = 100)
  private String warehouseId;
}