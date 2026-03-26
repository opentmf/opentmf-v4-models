package org.opentmf.partner.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * The reference object to the schema and type of target shipment which is
 * described by shipment specification.
 *
 * <p><br/>
 * <strong>Required:</strong> @schemaLocation, @type<br/>
 * </p>
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
@Required(fields = {"atType", "atSchemaLocation"})
public class TargetShipmentSchema implements ITargetShipmentSchema {

  /**
   * This field provides a link to the schema describing the target shipment.
   */
  @JsonProperty("@schemaLocation")
  private URI atSchemaLocation;

  /**
   * Class type of the target shipment.
   */
  @JsonProperty("@type")
  private @SafeText String atType;
}