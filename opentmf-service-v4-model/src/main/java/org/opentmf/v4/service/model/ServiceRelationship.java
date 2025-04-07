package org.opentmf.v4.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.v4.common.model.Characteristic;
import org.opentmf.v4.common.model.CharacteristicRelationship;

/**
 *
 * <p><br/>
 * <strong>Required:</strong> relationshipType, service<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-638: Service Inventory Management API</li>
 *   <li>TMF-641: Service Ordering Management API</li>
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
    defaultImpl = ServiceRelationship.class
)
@Required(fields = {"relationshipType", "service"})
public class ServiceRelationship extends CharacteristicRelationship {

  private @Valid ServiceRefOrValue service;

  /**
   * List of: Describes a given characteristic of an object or entity through a
   * name/value pair.
   */
  @JsonProperty("serviceRelationshipCharacteristic")
  private List<@Valid Characteristic> serviceRelationshipCharacteristics;
}