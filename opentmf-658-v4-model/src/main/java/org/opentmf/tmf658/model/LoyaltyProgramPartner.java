package org.opentmf.tmf658.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.CategoryRef;
import org.opentmf.common.model.Partner;
import org.opentmf.commons.validation.constraints.Required;

/**
 * A partner engaged in the Loyalty Program.
 *
 * <p><br/>
 * <strong>Required:</strong> engagedParty, name<br/>
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
    defaultImpl = LoyaltyProgramPartner.class
)
@Required(fields = {"name", "engagedParty"})
public class LoyaltyProgramPartner extends Partner implements ILoyaltyProgramPartner {

  /**
   * The partner catalog category reference maps to a category containing the
   * partner product offerings.
   */
  @JsonProperty("partnerCatalog")
  private List<@Valid CategoryRef> partnerCatalogs;
}