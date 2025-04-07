package org.opentmf.v4.tmf648.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.AppointmentRef;
import org.opentmf.v4.common.model.AttachmentRefOrValue;
import org.opentmf.v4.common.model.Extensible;
import org.opentmf.v4.common.model.Note;
import org.opentmf.v4.common.model.ProductOfferingRef;
import org.opentmf.v4.common.model.RelatedParty;
import org.opentmf.v4.product.model.ProductOfferingQualificationItemRef;
import org.opentmf.v4.product.model.ProductRefOrValue;

/**
 * A quote items describe an action to be performed on a productOffering or a
 * product in order to get pricing elements and condition.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-648: Quote Management API</li>
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
    defaultImpl = QuoteItem.class
)
public class QuoteItem extends Extensible {

  /**
   * Identifier of the quote item (generally it is a sequence number 01, 02, 03,
   * ...).
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * Action to be performed on this quote item (add, modify, remove, etc.).
   */
  private @SafeText String action;

  /**
   * Quantity asked for this quote item.
   */
  private Integer quantity;

  /**
   * State of the quote item : described in the state machine diagram.
   */
  private @SafeText String state;

  /**
   * A reference to appointment(s) associated with this quote item.
   */
  @JsonProperty("appointment")
  private List<@Valid AppointmentRef> appointments;

  /**
   * A reference to attachment(s) associated with this quote item.
   */
  @JsonProperty("attachment")
  private List<@Valid AttachmentRefOrValue> attachments;

  /**
   * Free form text associated with the quote item.
   */
  @JsonProperty("note")
  private List<@Valid Note> notes;

  private @Valid ProductRefOrValue product;

  private @Valid ProductOfferingRef productOffering;

  /**
   * A reference to a previously done POQ with item specified.
   */
  private @Valid ProductOfferingQualificationItemRef productOfferingQualificationItem;

  /**
   * A structure to embedded quote item within quote item.
   */
  @JsonProperty("quoteItem")
  private List<@Valid QuoteItem> quoteItems;

  /**
   * Authorization related to this quote item.
   */
  @JsonProperty("quoteItemAuthorization")
  private List<@Valid Authorization> quoteItemAuthorizations;

  /**
   * Price for this quote item.
   */
  @JsonProperty("quoteItemPrice")
  private List<@Valid QuotePrice> quoteItemPrices;

  /**
   * A relationship from item within a quote.
   */
  @JsonProperty("quoteItemRelationship")
  private List<@Valid QuoteItemRelationship> quoteItemRelationships;

  /**
   * A reference to a party playing a role in this quote item.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;
}