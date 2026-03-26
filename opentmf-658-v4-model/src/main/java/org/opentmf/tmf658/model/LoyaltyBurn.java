package org.opentmf.tmf658.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * A specialised event to process direct loyalty points redemption for
 * purchases.
 *
 * <p><br/>
 * <strong>Required:</strong> account, description, loyaltyProgramMember, loyaltyProgramProduct, paymentMethod, quantity<br/>
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
    defaultImpl = LoyaltyBurn.class
)
@Required(fields = {"quantity", "loyaltyProgramProduct", "loyaltyProgramMember", "description", "paymentMethod", "account"})
public class LoyaltyBurn extends LoyaltyBurnCreate implements ILoyaltyBurn {

  /**
   * Hyperlink reference.
   */
  private URI href;

  /**
   * unique identifier.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}