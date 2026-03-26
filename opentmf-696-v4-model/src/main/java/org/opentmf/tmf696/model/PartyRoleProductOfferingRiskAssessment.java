package org.opentmf.tmf696.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.ProductOfferingRef;
import org.opentmf.common.model.RelatedPartyRef;
import org.opentmf.commons.validation.constraints.Required;

/**
 * This is a task resource allowing assessment of the risks associated with a
 * party or party role that considers acquiring a specific product offering.
 *
 * <p><br/>
 * <strong>Required:</strong> partyRole, productOffering<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-696: Risk Management API</li>
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
    defaultImpl = PartyRoleProductOfferingRiskAssessment.class
)
@Required(fields = {"productOffering", "partyRole"})
public class PartyRoleProductOfferingRiskAssessment extends RiskAssessment implements IPartyRoleProductOfferingRiskAssessment {

  /**
   * RelatedParty reference. A related party defines party or party role linked to
   * a specific entity.
   */
  private @Valid RelatedPartyRef partyRole;

  /**
   * ProductOffering reference. A product offering represents entities that are
   * orderable from the provider of the catalog, this resource includes pricing
   * information.
   */
  private @Valid ProductOfferingRef productOffering;
}