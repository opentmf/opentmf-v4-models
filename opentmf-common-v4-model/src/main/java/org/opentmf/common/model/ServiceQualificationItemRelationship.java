package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Structure used to describe relationship between serviceQualification items
 * from the same serviceQualification.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-645: Service Qualification Management API</li>
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
    defaultImpl = ServiceQualificationItemRelationship.class
)
public class ServiceQualificationItemRelationship extends Extensible implements IServiceQualificationItemRelationship {

  /**
   * Id of the serviceQualificationItem (from the same serviceQualificationItem).
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * Type of relationship (ex: reliesOn, connectedTo, etc...).
   */
  private @SafeText String relationshipType;
}