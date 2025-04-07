package org.opentmf.v4.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 *
 * <p><br/>
 * <strong>Required:</strong> id, relationshipType<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-674: Geographic Site Management API</li>
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
    defaultImpl = GeographicSiteRelationship.class
)
@Required(fields = {"relationshipType", "id"})
public class GeographicSiteRelationship extends CharacteristicRelationship {

  /**
   * Role of the related site in the relationship.
   */
  private @SafeText String role;

  /**
   * Validity for the relationship.
   */
  private @Valid TimePeriod validFor;
}