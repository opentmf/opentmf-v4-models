package org.opentmf.v4.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * An array of linear rings.
 *
 * <p><br/>
 * <strong>Required:</strong> coordinates, type<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-673: Geographic Address Management API</li>
 *   <li>TMF-675: Geographic Location API</li>
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
    defaultImpl = Polygon.class
)
@Required(fields = {"coordinates", "type"})
public class Polygon extends Extensible {

  private @SafeText String type;

  /**
   * List of: GeoJSON: An array of linear rings.
   */
  private List<@Size(min = 4) List<@Size(min = 2, max = 2) List<BigDecimal>>> coordinates;
}