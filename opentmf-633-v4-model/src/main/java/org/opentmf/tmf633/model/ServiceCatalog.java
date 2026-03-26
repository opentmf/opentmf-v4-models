package org.opentmf.tmf633.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * The root entity for service catalog management.
 * <br/>A service catalog is a group of service specifications made available
 * through service candidates that an organization provides to the consumers
 * (internal consumers like its employees or B2B customers or B2C customers). 
 * <br/>A service catalog typically includes name, description and time period
 * that is valid for. It will have a list of ServiceCandidate catalog items. A
 * ServiceCandidate is an entity that makes a ServiceSpecification available to
 * a catalog.
 * <br/>A ServiceCandidate and its associated ServiceSpecification may be
 * "published" - made visible -in any number of ServiceCatalogs, or in none.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-633: Service Catalog Management API</li>
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
    defaultImpl = ServiceCatalog.class
)
public class ServiceCatalog extends ServiceCatalogCreate implements IServiceCatalog {

  /**
   * Hyperlink reference.
   */
  private URI href;

  /**
   * unique identifier.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}