package org.opentmf.tmf658.model;

import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * A person or group that opts in to a loyalty program.
 *
 * <p><br/>
 * <strong>Required:</strong> name, roleType<br/>
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
@Required(fields = {"name", "roleType"})
public class LoyaltyProgramMember extends LoyaltyProgramMemberUpdate implements ILoyaltyProgramMember {

  /**
   * A reference to the loyalty program member.
   */
  private URI href;

  /**
   * Unique identifier for the loyalty program member.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}