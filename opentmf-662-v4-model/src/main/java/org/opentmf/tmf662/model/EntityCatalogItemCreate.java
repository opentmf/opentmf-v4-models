package org.opentmf.tmf662.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;

/**
 * An EntityCatalogItem is an entity that allows any ProductOffering,
 * ServiceCandidate, ResourceCandidate, or even any object inheriting from
 * RootEntity, to be available to a catalog. The CatalogSpecification and Policy
 * of the catalog governs the content of the EntityCatalogItem. This API
 * addresses only EntitySpecification items extended from RootEntity as
 * EntityCatalogItem.
 * <br/>The EntityCatalogItem resource (JSON format) represents a set of
 * characteristics that define the values given by the EntityCatalogItem.
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> name, specification<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-662: Entity Catalog Management API</li>
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
    defaultImpl = EntityCatalogItemCreate.class
)
@Required(fields = {"name", "specification"})
public class EntityCatalogItemCreate extends EntityCatalogItemUpdate implements IEntityCatalogItemCreate {

  /**
   * Date and time of the last update of this REST resource.
   */
  private OffsetDateTime lastUpdate;
}