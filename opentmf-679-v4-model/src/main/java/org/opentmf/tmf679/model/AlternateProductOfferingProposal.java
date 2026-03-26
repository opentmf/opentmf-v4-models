package org.opentmf.tmf679.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.ProductOfferingRef;
import org.opentmf.common.model.ProductRefOrValue;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * Alternate product Offering proposal is used when the requested product
 * offering is not available with characteristic and date asked for. An
 * alternate proposal could be a distinct product offering or product Spec close
 * to requested one or same as requested but with a different activation date.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-679: Product Offering Qualification Management API</li>
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
    defaultImpl = AlternateProductOfferingProposal.class
)
public class AlternateProductOfferingProposal extends Extensible implements IAlternateProductOfferingProposal {

  /**
   * Alternate activation date in case seller is not able to meet requested
   * expected activation date.
   */
  private OffsetDateTime alternateActivationDate;

  /**
   * A product to be created defined by value or existing defined by reference.
   * The polymorphic attributes {@literal @}type, {@literal @}schemaLocation & {@literal @}referredType are related
   * to the product entity and not the RelatedProductRefOrValue class itself.
   */
  private @Valid ProductRefOrValue alternateProduct;

  /**
   * ProductOffering reference. A product offering represents entities that are
   * orderable from the provider of the catalog, this resource includes pricing
   * information.
   */
  private @Valid ProductOfferingRef alternateProductOffering;

  /**
   * Identifier of a alternate product offering proposal.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}