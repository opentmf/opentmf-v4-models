package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Structure used to describe relationship between WorkQualification items from
 * the same WorkQualification .
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-714: Work Qualification Management</li>
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
    defaultImpl = WorkQualificationItemRelationship.class
)
public class WorkQualificationItemRelationship extends Extensible implements IWorkQualificationItemRelationship {

  /**
   * Id of the workQualificationItem (from the same workQualification).
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * Type of relationship (ex: reliesOn, connectedTo, etc...).
   */
  private @SafeText String relationshipType;
}