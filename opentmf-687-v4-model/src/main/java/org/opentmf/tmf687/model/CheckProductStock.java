package org.opentmf.tmf687.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * CheckProductStock is used to log and execute check about product stock
 * availability.
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
    defaultImpl = CheckProductStock.class
)
public class CheckProductStock extends CheckProductStockCreate implements ICheckProductStock {

  /**
   * Reference of the CheckProductStock.
   */
  private URI href;

  /**
   * Unique identifier of the CheckProductStock.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}