package org.opentmf.tmf658.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Party;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Entity reference. A related party defines party or party role linked to a
 * specific entity.
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
    defaultImpl = RelatedPartyRefOrValue.class
)
public class RelatedPartyRefOrValue extends Party implements IRelatedPartyRefOrValue {

  /**
   * The actual type of the target instance when needed for disambiguation.
   */
  @JsonProperty("@referredType")
  private @SafeText String atReferredType;

  /**
   * Name of the related entity.
   */
  private @SafeText String name;

  private @SafeText String role;
}