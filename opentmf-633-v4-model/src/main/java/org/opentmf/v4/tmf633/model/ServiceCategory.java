package org.opentmf.v4.tmf633.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * The (service) category resource is used to group service candidates in
 * logical containers. Categories can contain other categories.
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
    defaultImpl = ServiceCategory.class
)
public class ServiceCategory extends ServiceCategoryCreate {

  /**
   * unique identifier.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * Hyperlink reference.
   */
  private URI href;
}