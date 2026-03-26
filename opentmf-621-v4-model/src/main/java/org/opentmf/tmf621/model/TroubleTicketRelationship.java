package org.opentmf.tmf621.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.NamedEntity;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Represents a relationship between trouble Trouble Tickets.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-621: Trouble Ticket Management API</li>
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
    defaultImpl = TroubleTicketRelationship.class
)
public class TroubleTicketRelationship extends NamedEntity implements ITroubleTicketRelationship {

  /**
   * Type of the Trouble Ticket relationship can be isChiled, dependent etc...
   */
  private @SafeText String relationshipType;
}