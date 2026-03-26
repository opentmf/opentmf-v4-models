package org.opentmf.tmf687.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * ReserveProductStock is used to request a product stock reservation.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-687: Stock Management API</li>
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
    defaultImpl = ReserveProductStock.class
)
public class ReserveProductStock extends ReserveProductStockCreate implements IReserveProductStock {

  /**
   * Reference of the ReserveProductStock.
   */
  private URI href;

  /**
   * Unique identifier of the ReserveProductStock.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}