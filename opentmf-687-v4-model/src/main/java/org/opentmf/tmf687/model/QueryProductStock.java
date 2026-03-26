package org.opentmf.tmf687.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * QueryProductStock is used to query product stock availability.
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
    defaultImpl = QueryProductStock.class
)
public class QueryProductStock extends QueryProductStockCreate implements IQueryProductStock {

  /**
   * Reference of the QueryProductStock.
   */
  private URI href;

  /**
   * Unique identifier of the QueryProductStock.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}