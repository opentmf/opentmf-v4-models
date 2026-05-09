package org.opentmf.partner.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;

/**
 * Definition of the nature of a Shipment. For example, could be a standard
 * ground delivery, overnight express with signature required by an adult, etc.
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> name<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
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
    defaultImpl = ShipmentSpecificationCreate.class
)
@Required(fields = {"name"})
public class ShipmentSpecificationCreate extends ShipmentSpecificationUpdate implements IShipmentSpecificationCreate {

  /**
   * Date and time of the last update of this REST resource.
   */
  private OffsetDateTime lastUpdate;
}