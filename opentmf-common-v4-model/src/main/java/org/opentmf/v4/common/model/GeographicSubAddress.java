package org.opentmf.v4.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Representation of a GeographicSubAddress 
 * <br/>It is used for addressing within a property in an urban area (country
 * properties are often defined differently). It may refer to a building, a
 * building cluster, or a floor of a multistory building.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-673: Geographic Address Management API</li>
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
    defaultImpl = GeographicSubAddress.class
)
public class GeographicSubAddress extends Entity {

  /**
   * allows for buildings that have well-known names.
   */
  private @SafeText String buildingName;

  /**
   * used where a level type may be repeated e.g. BASEMENT 1, BASEMENT 2.
   */
  private @SafeText String levelNumber;

  /**
   * describes level types within a building.
   */
  private @SafeText String levelType;

  /**
   * Name of the subAddress to identify it with a meaningful identification.
   */
  private @SafeText String name;

  /**
   * private streets internal to a property (e.g. a university) may have internal
   * names that are not recorded by the land title office.
   */
  private @SafeText String privateStreetName;

  /**
   * private streets numbers internal to a private street.
   */
  private @SafeText String privateStreetNumber;

  /**
   * Type of subAddress : it can be a subunit or a private street.
   */
  private @SafeText String subAddressType;

  /**
   * the discriminator used for the subunit
   * <br/>often just a simple number e.g. FLAT 5, may also be a range.
   */
  private @SafeText String subUnitNumber;

  /**
   * the type of subunit
   * <br/>e.g.BERTH, FLAT, PIER, SUITE, SHOP, TOWER, UNIT, WHARF.
   */
  private @SafeText String subUnitType;
}