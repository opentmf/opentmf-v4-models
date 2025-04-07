package org.opentmf.v4.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Resources are physical or non-physical components (or some combination of
 * these) within an enterprise's infrastructure or inventory. They are typically
 * consumed or used by services (for example a physical port assigned to a
 * service) or contribute to the realization of a Product (for example, a SIM
 * card). They can be drawn from the Application, Computing and Network domains,
 * and include, for example, Network Elements, software, IT systems, content and
 * information, and technology components.
 * <br/>A ResourceSpecification is an abstract base class for representing a
 * generic means for implementing a particular type of Resource. In essence, a
 * ResourceSpecification defines the common attributes and relationships of a
 * set of related Resources, while Resource defines a specific instance that is
 * based on a particular ResourceSpecification.
 *
 * <p><br/>
 * <strong>Required:</strong> id<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-620: Product Catalog Management API</li>
 *   <li>TMF-633: Service Catalog Management API</li>
 *   <li>TMF-634: Resource Catalog Management API</li>
 *   <li>TMF-639: Resource Inventory Management API</li>
 *   <li>TMF-652: Resource Order Management API</li>
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
    defaultImpl = ResourceSpecificationRef.class
)
@Required(fields = {"id"})
public class ResourceSpecificationRef extends EntityRef {

  /**
   * Resource Specification version.
   */
  private @SafeText String version;
}