package org.opentmf.tmf662.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.EntityCatalogUpdateBase;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.general.model.EntityCategoryRef;

/**
 * The (entity) category resource is used to group entity catalog items in
 * logical containers. Categories can contain other categories.
 * <br/>Resource IDs for categories are strings and are defined by the catalog
 * application.
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
    defaultImpl = EntityCategoryUpdate.class
)
public class EntityCategoryUpdate extends EntityCatalogUpdateBase implements IEntityCategoryUpdate {

  /**
   * The child category(ies) if any, contained in this category.
   */
  @JsonProperty("childCategory")
  private List<@Valid EntityCategoryRef> childCategories;

  /**
   * The catalog items referred to by this category.
   */
  @JsonProperty("entityCatalogItem")
  private List<@Valid EntityCatalogItemRef> entityCatalogItems;

  /**
   * If true, this Boolean indicates that the category is a root of categories.
   */
  private Boolean isRoot;

  /**
   * Unique identifier of the parent category.
   */
  @SafeId
  @Size(max = 100)
  private String parentId;
}