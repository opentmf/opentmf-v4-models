package org.opentmf.tmf908.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.EntityRef;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Party role reference. A party role represents the part played by a party in a
 * given context.
 *
 * <p><br/>
 * <strong>Required:</strong> id<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-908: IoT Agent and Device Management API</li>
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
    defaultImpl = PartyRoleRef.class
)
@Required(fields = {"id"})
public class PartyRoleRef extends EntityRef implements IPartyRoleRef {

  /**
   * The identifier of the engaged party that is linked to the PartyRole object.
   */
  @SafeId
  @Size(max = 100)
  private String partyId;

  /**
   * The name of the engaged party that is linked to the PartyRole object.
   */
  private @SafeText String partyName;
}