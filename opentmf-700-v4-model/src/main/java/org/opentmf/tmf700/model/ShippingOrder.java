package org.opentmf.tmf700.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * A Shipping Order is a document used by a business to specify what items are
 * to be transferred from a storage location or warehouse to which person and to
 * which new location. A Shipping Order can typically be sent along with a
 * shipment of goods so that the person receiving them can verify that the
 * document correctly reflects the items that they actually received.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-700: Shipping Order Management API</li>
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
    defaultImpl = ShippingOrder.class
)
public class ShippingOrder extends ShippingOrderUpdate implements IShippingOrder {

  /**
   * Date of the Shipping Order.
   */
  private OffsetDateTime creationDate;

  /**
   * Shipping Order unique reference.
   */
  private URI href;

  /**
   * Identifier of the Shipping Order.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * Date of the Shipping Order.
   */
  private OffsetDateTime lastUpdateDate;
}