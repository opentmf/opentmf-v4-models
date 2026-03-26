package org.opentmf.tmf683.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-683: Party Interaction Management API</li>
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
    defaultImpl = PartyInteraction.class
)
public class PartyInteraction extends PartyInteractionCreate implements IPartyInteraction {

  /**
   * Hyperlink to access the party interaction.
   */
  private URI href;

  /**
   * Unique identifier of the party interaction.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}