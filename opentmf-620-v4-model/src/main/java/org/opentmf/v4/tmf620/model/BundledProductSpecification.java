package org.opentmf.v4.tmf620.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.NamedEntity;

/**
 * A type of ProductSpecification that belongs to a grouping of
 * ProductSpecifications made available to the market. It inherits of all
 * attributes of ProductSpecification.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-620: Product Catalog Management API</li>
 * </ul>
 * </p>
 *
 * @author Gokhan Demir
 */
@Getter
@Setter
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = BundledProductSpecification.class
)
public class BundledProductSpecification extends NamedEntity {

  /**
   * Used to indicate the current lifecycle status.
   */
  private @SafeText String lifecycleStatus;
}