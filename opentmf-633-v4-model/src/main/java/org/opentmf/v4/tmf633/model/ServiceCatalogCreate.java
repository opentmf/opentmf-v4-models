package org.opentmf.v4.tmf633.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;

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
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> name<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-633: Service Catalog Management API</li>
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
    defaultImpl = ServiceCatalogCreate.class
)
@Required(fields = {"name"})
public class ServiceCatalogCreate extends ServiceCatalogUpdate {

  /**
   * Date and time of the last update.
   */
  private OffsetDateTime lastUpdate;
}