package org.opentmf.v4.tmf669.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * The part played by a party in a given context.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-669: Party Role Management API</li>
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
    defaultImpl = PartyRole.class
)
public class PartyRole extends PartyRoleCreate {

  /**
   * Unique identifier for PartyRoles.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * Url used to reference the party role.
   */
  private URI href;
}