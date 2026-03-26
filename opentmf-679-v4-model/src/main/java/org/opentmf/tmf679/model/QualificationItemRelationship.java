package org.opentmf.tmf679.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Structure used to describe relationship between productOfferingQualification
 * item from the same ProductOfferingQualification.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-679: Product Offering Qualification Management API</li>
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
    defaultImpl = QualificationItemRelationship.class
)
public class QualificationItemRelationship extends Extensible implements IQualificationItemRelationship {

  /**
   * Id of the ProductOfferingQualificationItem (from the same
   * ProductOfferingQualificationItem).
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * Type of relationship (ex: reliesOn, connectedTo, etc...).
   */
  private @SafeText String relationshipType;
}