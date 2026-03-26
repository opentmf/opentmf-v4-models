package org.opentmf.tmf700.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
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
public class ShippingOrderInformationRequiredEventPayload implements IShippingOrderInformationRequiredEventPayload {

  /**
   * A Shipping Order is a document used by a business to specify what items are
   * to be transferred from a storage location or warehouse to which person and to
   * which new location. A Shipping Order can typically be sent along with a
   * shipment of goods so that the person receiving them can verify that the
   * document correctly reflects the items that they actually received.
   */
  private @Valid ShippingOrder shippingOrder;
}