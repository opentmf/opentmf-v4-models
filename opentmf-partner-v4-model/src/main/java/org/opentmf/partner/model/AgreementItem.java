package org.opentmf.partner.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Entity;
import org.opentmf.common.model.ProductOfferingRef;
import org.opentmf.common.model.ProductRef;

/**
 * A part of the agreement expressed in terms of a product offering and possibly
 * including specific terms and conditions.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-644: Privacy Management API</li>
 *   <li>TMF-651: Agreement Management API</li>
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
    defaultImpl = AgreementItem.class
)
public class AgreementItem extends Entity implements IAgreementItem {

  /**
   * The list of products indirectly referred by this agreement item (since an
   * agreement item refers primarily to product offerings).
   */
  @JsonProperty("product")
  private List<@Valid ProductRef> products;

  /**
   * The list of product offerings referred by this agreement item.
   */
  @JsonProperty("productOffering")
  private List<@Valid ProductOfferingRef> productOfferings;

  /**
   * List of: Aspects of the agreement not formally specified elsewhere in the
   * agreement and that cannot be captured elsewhere in a formal notation, or
   * automatically monitored and require a more human level of management.
   */
  @JsonProperty("termOrCondition")
  private List<@Valid AgreementTermOrCondition> termOrConditions;
}