package org.opentmf.tmf662.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.EntityCatalogUpdateBase;
import org.opentmf.general.model.EntityCategoryRef;
import org.opentmf.general.model.EntitySpecificationRef;

/**
 * An EntityCatalogItem is an entity that allows any ProductOffering,
 * ServiceCandidate, ResourceCandidate, or even any object inheriting from
 * RootEntity, to be available to a catalog. The CatalogSpecification and Policy
 * of the catalog governs the content of the EntityCatalogItem. This API
 * addresses only EntitySpecification items extended from RootEntity as
 * EntityCatalogItem.
 * <br/>The EntityCatalogItem resource (JSON format) represents a set of
 * characteristics that define the values given by the EntityCatalogItem.
 * <br/>Skipped properties: id,href,lastUpdate.
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
    defaultImpl = EntityCatalogItemUpdate.class
)
public class EntityCatalogItemUpdate extends EntityCatalogUpdateBase implements IEntityCatalogItemUpdate {

  /**
   * List of: Reference to Entity Category object. The (entity) category resource
   * is used to group entity catalog items in logical containers. Categories can
   * contain other categories.
   * <br/>Resource IDs for categories are strings and are defined by the catalog
   * application.
   */
  @JsonProperty("category")
  private List<@Valid EntityCategoryRef> categories;

  /**
   * reference to an EntitySpecification object.
   */
  private @Valid EntitySpecificationRef specification;
}