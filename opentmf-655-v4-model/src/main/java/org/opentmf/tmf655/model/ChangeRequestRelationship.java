package org.opentmf.tmf655.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Characteristic;
import org.opentmf.common.model.CharacteristicRelationship;
import org.opentmf.commons.validation.constraints.Required;

/**
 *
 * <p><br/>
 * <strong>Required:</strong> relationshipType<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-655: Change Management API</li>
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
    defaultImpl = ChangeRequestRelationship.class
)
@Required(fields = {"relationshipType"})
public class ChangeRequestRelationship extends CharacteristicRelationship implements IChangeRequestRelationship {

  /**
   * A Service to be created defined by value or existing defined by reference.
   * The polymorphic attributes {@literal @}type, {@literal @}schemaLocation & {@literal @}referredType are related
   * to the Service entity and not the RelatedServiceRefOrValue class itself.
   */
  private @Valid ChangeRequestRefOrValue changeRequest;

  /**
   * List of: Describes a given characteristic of an object or entity through a
   * name/value pair.
   */
  @JsonProperty("changeRequestRelationshipCharacteristic")
  private List<@Valid Characteristic> changeRequestRelationshipCharacteristics;
}