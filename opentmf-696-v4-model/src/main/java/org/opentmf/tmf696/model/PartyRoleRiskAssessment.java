package org.opentmf.tmf696.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.RelatedPartyRef;
import org.opentmf.commons.validation.constraints.Required;

/**
 * This is a task resource allowing assessment of the risks associated with a
 * party role.
 *
 * <p><br/>
 * <strong>Required:</strong> partyRole<br/>
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
    defaultImpl = PartyRoleRiskAssessment.class
)
@Required(fields = {"partyRole"})
public class PartyRoleRiskAssessment extends Extensible implements IPartyRoleRiskAssessment {

  /**
   * RelatedParty reference. A related party defines party or party role linked to
   * a specific entity.
   */
  private @Valid RelatedPartyRef partyRole;
}