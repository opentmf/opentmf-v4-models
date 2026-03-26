package org.opentmf.product.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.NamedEntity;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A type of ProductSpecification that belongs to a grouping of
 * ProductSpecifications made available to the market. It inherits of all
 * attributes of ProductSpecification.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-620: Product Catalog Management API</li>
 *   <li>TMF-658: Loyalty</li>
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
    defaultImpl = BundledProductSpecification.class
)
public class BundledProductSpecification extends NamedEntity implements IBundledProductSpecification {

  /**
   * Used to indicate the current lifecycle status.
   */
  private @SafeText String lifecycleStatus;
}