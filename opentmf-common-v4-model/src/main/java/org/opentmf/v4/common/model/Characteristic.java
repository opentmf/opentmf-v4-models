package org.opentmf.v4.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Describes a given characteristic of an object or entity through a name/value
 * pair.
 *
 * <p><br/>
 * <strong>Required:</strong> name, value<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-622: Product Ordering Management API</li>
 *   <li>TMF-629: Customer Management API</li>
 *   <li>TMF-632: Party Management API</li>
 *   <li>TMF-637: Product Inventory Management API</li>
 *   <li>TMF-638: Service Inventory Management API</li>
 *   <li>TMF-639: Resource Inventory Management API</li>
 *   <li>TMF-641: Service Ordering Management API</li>
 *   <li>TMF-648: Quote Management API</li>
 *   <li>TMF-651: Agreement</li>
 *   <li>TMF-652: Resource Order Management API</li>
 *   <li>TMF-663: Shopping Cart Management API</li>
 *   <li>TMF-669: Party Role Management API</li>
 *   <li>TMF-681: Communication Management API</li>
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
    defaultImpl = Characteristic.class
)
@Required(fields = {"name", "value"})
public class Characteristic extends Extensible {

  /**
   * Unique identifier of the characteristic.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * Name of the characteristic.
   */
  private @SafeText String name;

  /**
   * Data type of the value of the characteristic.
   */
  private @SafeText String valueType;

  /**
   * List of: Another Characteristic that is related to the current
   * Characteristic;.
   */
  @JsonProperty("characteristicRelationship")
  private List<@Valid CharacteristicRelationship> characteristicRelationships;

  /**
   * The value of the characteristic.
   */
  private Object value;

  public static Characteristic of(String name, Object value) {
    Characteristic c = new Characteristic();
    c.name = name;
    c.value = value;
    return c;
  }

  public static Characteristic of(String name, String valueType, Object value) {
    Characteristic c = new Characteristic();
    c.name = name;
    c.valueType = valueType;
    c.value = value;
    return c;
  }
}