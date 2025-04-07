package org.opentmf.v4.tmf634.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * This is an example of a derived class of ResourceSpecification, and is used
 * to define the invariant characteristics and behavior (attributes, methods,
 * constraints, and relationships) of a PhysicalResource.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-634: Resource Catalog Management API</li>
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
    defaultImpl = PhysicalResourceSpecification.class
)
public class PhysicalResourceSpecification extends LogicalResourceSpecification {

  /**
   * This is a string that represents a manufacturer-allocated number used to
   * identify the general type and/or category of the hardware item. This, in
   * combination with the Part and the Vendor, identify different types of
   * hardware items. The SerialNumber can then be used to differentiate between
   * different instances of the same type of hardware item. This is an optional
   * attribute.
   */
  private @SafeText String model;

  /**
   * This is a string that defines a manufacturer-allocated part number assigned
   * by the organization that manufactures the hardware item. This, in combination
   * with the Model and the Vendor, identify different types of hardware items.
   * The SerialNumber can then be used to differentiate between different
   * instances of the same type of hardware item. This is a REQUIRED attribute.
   */
  private @SafeText String part;

  /**
   * This is a string that defines the manufacturer-allocated Stock Keeping Unit
   * (SKU) number of the hardware item. This is an optional attribute.
   */
  private @SafeText String sku;

  /**
   * This is a string that defines the name of the manufacturer. This, in
   * combination with the Model and the Part, identify different types of hardware
   * items. The SerialNumber can then be used to differentiate between different
   * instances of the same type of hardware item. This is a REQUIRED attribute for
   * a physical resource.
   */
  private @SafeText String vendor;
}