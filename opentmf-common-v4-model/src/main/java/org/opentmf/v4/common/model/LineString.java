package org.opentmf.v4.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;

/**
 * GeoJSON: A collection of Points forming a connected line.
 *
 * <p><br/>
 * <strong>Required:</strong> coordinates<br/>
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
    defaultImpl = LineString.class
)
@Required(fields = {"coordinates"})
public class LineString extends Extensible {

  /**
   * List of: GeoJSON: An array of two or more positions.
   */
  private @Size(min = 2) List<@Size(min = 2, max = 2) List<BigDecimal>> coordinates;
}