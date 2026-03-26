package org.opentmf.tmf658.model;

import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Addressable;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A record of a loyalty action that was applied.
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
public class LoyaltyExecutionPoint extends Addressable implements ILoyaltyExecutionPoint {

  /**
   * The HTTP operation to be used when calling the endpoint.
   */
  private @SafeText String action;

  private Object actionAttributes;

  private Object body;

  /**
   * A user-friendly identifier of the loyalty execution point.
   */
  private @SafeText String commonName;

  /**
   * The timestamp that the action was applied.
   */
  private OffsetDateTime datetime;

  /**
   * A free-form description of the loyalty execution point.
   */
  private @SafeText String description;

  /**
   * The endpoint called to trigger the Loyalty Program reward.
   */
  private @SafeText String endpoint;

  private Object headers;

  /**
   * A person or group that opts in to a loyalty program.
   */
  private @Valid LoyaltyProgramMember loyaltyProgramMember;

  /**
   * An instance of a loyalty program specification, linked to a specified loyalty
   * member.
   */
  private @Valid LoyaltyProgramProduct loyaltyProgramProduct;

  /**
   * The type of loyalty action.
   */
  private @SafeText String type;

  /**
   * A string that identifies the version of the loyalty action.
   */
  private @SafeText String version;
}