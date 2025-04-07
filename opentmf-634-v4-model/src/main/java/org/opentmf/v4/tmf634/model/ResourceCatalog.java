package org.opentmf.v4.tmf634.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * The root entity for resource catalog management.
 * <br/>A resource catalog is a group of resource specifications made available
 * through resource candidates that an organization provides to the consumers
 * (internal consumers like its employees or B2B customers or B2C customers).
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
    defaultImpl = ResourceCatalog.class
)
public class ResourceCatalog extends ResourceCatalogCreate {

  /**
   * Unique identifier of the Catalog.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * Unique reference of the catalog.
   */
  private URI href;
}