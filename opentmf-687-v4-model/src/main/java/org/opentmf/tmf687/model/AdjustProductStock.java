package org.opentmf.tmf687.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * AdjustProductStock is used to log and execute on or several Product Stock
 * level change.
 *
 * <p><br/>
 * <strong>Required:</strong> adjustProductStockItem<br/>
 * </p>
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
    defaultImpl = AdjustProductStock.class
)
@Required(fields = {"adjustProductStockItem"})
public class AdjustProductStock extends AdjustProductStockCreate implements IAdjustProductStock {

  /**
   * Reference of the AdjustProductStock.
   */
  private URI href;

  /**
   * Unique identifier of the AdjustProductStock.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}