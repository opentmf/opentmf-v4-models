package org.opentmf.tmf658.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * An instance of a loyalty program specification, linked to a specified loyalty
 * member.
 *
 * <p><br/>
 * <strong>Required:</strong> loyaltyAccount, loyaltyProgramMember, loyaltyProgramProductSpec, name, validFor<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
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
    defaultImpl = LoyaltyProgramProduct.class
)
@Required(fields = {"loyaltyProgramProductSpec", "validFor", "loyaltyProgramMember", "name", "loyaltyAccount"})
public class LoyaltyProgramProduct extends LoyaltyProgramProductUpdate implements ILoyaltyProgramProduct {

  /**
   * A reference to the loyalty member product.
   */
  private URI href;

  /**
   * Unique identifier for the loyalty program product.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}