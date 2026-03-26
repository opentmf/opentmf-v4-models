package org.opentmf.tmf691.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IndividualIdentification;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.general.model.GeographicAddress;

/**
 *
 * <p><br/>
 * <strong>Required:</strong> name, sub<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-691: Federated ID Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
@Required(fields = {"sub", "name"})
public class Userinfo implements IUserinfo {

  /**
   * Structured textual way of describing how to find a Property in an urban area
   * (country properties are often defined differently).
   * <br/>Note : Address corresponds to SID UrbanPropertyAddress.
   */
  private @Valid GeographicAddress address;

  /**
   * End-User's birthday, represented as an [ISO8601-2004] YYYY-MM-DD format. The
   * year MAY be 0000, indicating that it is omitted. To represent only the year,
   * YYYY format is allowed. Note that depending on the underlying platform's date
   * related function, providing just year can result in varying month and day, so
   * the implementers need to take this factor into account to correctly process
   * the dates.
   */
  private @SafeText String birthdate;

  /**
   * End-User's preferred e-mail address. Its value MUST conform to the [RFC5322]
   * addr-spec syntax.
   */
  private @SafeText String email;

  /**
   * True if the user's email has been verified.
   */
  @JsonProperty("email_verified")
  private Boolean emailverified;

  /**
   * Surname(s) or last name(s) of the End-User. Note that in some cultures,
   * people can have multiple family names or no family name; all can be present,
   * with the names being separated by space characters.
   */
  @JsonProperty("family_name")
  private @SafeText String familyname;

  /**
   * End-User's gender. Values defined by this specification are female and male.
   * Other values MAY be used when neither of the defined values are applicable.
   */
  private @SafeText String gender;

  /**
   * Given name(s) or first name(s) of the End-User. Note that in some cultures,
   * people can have multiple given names; all can be present, with the names
   * being separated by space characters.
   */
  @JsonProperty("given_name")
  private @SafeText String givenname;

  /**
   * Identification documentation of the contact.
   */
  @JsonProperty("legalId")
  private List<@Valid IndividualIdentification> legalIds;

  /**
   * End-User's locale, represented as a [RFC5646] language tag. This is typically
   * an [ISO639-1] language code in lowercase and an [ISO3166-1] country code in
   * uppercase, separated by a dash. For example, en-US or fr-CA. As a
   * compatibility note, some implementations have used an underscore as the
   * separator rather than a dash, for example, en_US.
   */
  private @SafeText String locale;

  /**
   * Middle name(s) of the End-User. Note that in some cultures, people can have
   * multiple middle names; all can be present, with the names being separated by
   * space characters. Also note that in some cultures, middle names are not used.
   */
  @JsonProperty("middle_name")
  private @SafeText String middlename;

  /**
   * End-User's full name in displayable form including all name parts, possibly
   * including titles and suffixes, ordered according to the End-User's locale and
   * preferences.
   */
  private @SafeText String name;

  /**
   * Casual name of the End-User that may or may not be the same as the
   * given_name. For instance, a nickname value of Mike might be returned
   * alongside a given_name value of Michael.
   */
  private @SafeText String nickname;

  /**
   * End-User's preferred telephone number. [E.164] is RECOMMENDED as the format
   * of this Claim, for example, +1 (425) 555-1212 or +56 82) 687 2400. If the
   * phone number contains an extension, it is RECOMMENDED that the extension be
   * represented using the [RFC3966] extension syntax, for example, +1 (604)
   * 555-1234;ext=5678.
   */
  @JsonProperty("phone_number")
  private @SafeText String phonenumber;

  /**
   * True if the user's phone number has been verified.
   */
  @JsonProperty("phone_number_verified")
  private Boolean phonenumberverified;

  /**
   * URL of the End-User's profile picture. This URL MUST refer to an image file
   * (for example, a PNG, JPEG, or GIF image file), rather than to a Web page
   * containing an image. Note that this URL SHOULD specifically reference a
   * profile photo of the End-User suitable for displaying when describing the
   * End-User, rather than an arbitrary photo taken by the End-User.
   */
  private @SafeText String picture;

  /**
   * Shorthand name by which the End-User wishes to be referred to at the RP, such
   * as janedoe or j.doe. This value MAY be any valid JSON string including
   * special characters such as {@literal @}, /, or whitespace.
   */
  @JsonProperty("preferred_username")
  private @SafeText String preferredusername;

  /**
   * URL of the End-User's profile page. The contents of this Web page SHOULD be
   * about the End-User.
   */
  private @SafeText String profile;

  /**
   * Subject - Unique Identifier for the End-User.
   */
  private @SafeText String sub;

  /**
   * List of additional profile information.
   */
  @JsonProperty("userAssets")
  private List<@Valid UserAsset> userAssetses;

  /**
   * URL of the End-User's Web page or blog. This Web page SHOULD contain
   * information published by the End-User or an organization that the End-User is
   * affiliated with.
   */
  private @SafeText String website;

  /**
   * String from zoneinfo time zone database representing the End-User's time
   * zone. For example, Europe/Paris or America/Los_Angeles.
   */
  private @SafeText String zoneinfo;
}