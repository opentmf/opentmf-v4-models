package org.opentmf.tmf633.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.EntityCatalogUpdateBase;
import org.opentmf.common.model.ServiceSpecificationRef;
import org.opentmf.service.model.ServiceCategoryRef;

/**
 * ServiceCandidate is an entity that makes a service specification available to
 * a catalog. A
 * <br/>ServiceCandidate and its associated service specification may be
 * published - made visible - in any number of service catalogs, or in none. One
 * service specification can be composed of other service specifications.
 * <br/>Skipped properties: id,href,lastUpdate.
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
    defaultImpl = ServiceCandidateUpdate.class
)
public class ServiceCandidateUpdate extends EntityCatalogUpdateBase implements IServiceCandidateUpdate {

  /**
   * List of categories for this candidate.
   */
  @JsonProperty("category")
  private List<@Valid ServiceCategoryRef> categories;

  /**
   * Service specification reference: ServiceSpecification(s) required to realize
   * a ProductSpecification.
   */
  private @Valid ServiceSpecificationRef serviceSpecification;
}