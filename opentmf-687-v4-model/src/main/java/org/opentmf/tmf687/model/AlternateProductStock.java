package org.opentmf.tmf687.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.PlaceRefOrValue;
import org.opentmf.common.model.ProductRefOrValue;
import org.opentmf.common.model.ProductStockRef;
import org.opentmf.common.model.Quantity;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * AlternateProductStock is used to log and execute Alternate about product
 * stock availability.
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
    defaultImpl = AlternateProductStock.class
)
public class AlternateProductStock extends Extensible implements IAlternateProductStock {

  /**
   * Alternate date when the product stock is available.
   */
  private OffsetDateTime alternateAvailabilityDate;

  /**
   * A place described by reference or by value linked to a specific entity. The
   * polymorphic attributes {@literal @}type, {@literal @}schemaLocation & {@literal @}referredType are related to
   * the place entity and not the PlaceRefOrValue class itself.
   */
  private @Valid PlaceRefOrValue alternatePlace;

  /**
   * A product to be created defined by value or existing defined by reference.
   * The polymorphic attributes {@literal @}type, {@literal @}schemaLocation & {@literal @}referredType are related
   * to the product entity and not the RelatedProductRefOrValue class itself.
   */
  private @Valid ProductRefOrValue alternateProduct;

  /**
   * An amount in a given unit.
   */
  private @Valid Quantity alternateQuantity;

  /**
   * ProductStockRef is a reference to a product stock.
   */
  private @Valid ProductStockRef alternateStock;

  /**
   * identifier of the Alternate product stock.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}