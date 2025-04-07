package org.opentmf.v4.tmf648.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.AgreementRef;
import org.opentmf.v4.common.model.ContactMedium;
import org.opentmf.v4.common.model.Extensible;
import org.opentmf.v4.common.model.Note;
import org.opentmf.v4.common.model.RelatedParty;
import org.opentmf.v4.common.model.TimePeriod;
import org.opentmf.v4.product.model.BillingAccountRef;
import org.opentmf.v4.product.model.ProductOfferingQualificationRef;

/**
 * Quote can be used to negotiate service and product acquisition or
 * modification between a customer and a service provider. Quote contain list of
 * quote items, a reference to customer (partyRole), a list of productOffering
 * and attached prices and conditions.
 * <br/>Skipped properties: id,href,quoteDate.
 *
 * <p><br/>
 * <strong>Required:</strong> quoteItem<br/>
 * </p>
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
    defaultImpl = QuoteUpdate.class
)
@Required(fields = {"quoteItem"})
public class QuoteUpdate extends Extensible {

  /**
   * Used to categorize the quote from a business perspective that can be useful
   * for the CRM system (e.g. "enterprise", "residential", ...).
   */
  private @SafeText String category;

  /**
   * Description of the quote.
   */
  private @SafeText String description;

  /**
   * Date when the quote has been completed.
   */
  private OffsetDateTime effectiveQuoteCompletionDate;

  /**
   * this is the date wished by the requester to have the requested quote item
   * delivered.
   */
  private OffsetDateTime expectedFulfillmentStartDate;

  /**
   * This is expected date - from quote supplier - to be able to send back a
   * response for this quote.
   */
  private OffsetDateTime expectedQuoteCompletionDate;

  /**
   * ID given by the consumer and only understandable by him (to facilitate his
   * searches afterward).
   */
  @SafeId
  @Size(max = 100)
  private String externalId;

  /**
   * An indicator which when the value is "true" means that requester expects to
   * get quoting result immediately in the response. If the indicator is true then
   * the response code of 200 indicates the operation is successful otherwise a
   * task is created with a response 201.
   */
  private Boolean instantSyncQuote;

  /**
   * This is requested date - from quote requester - to get a complete response
   * for this quote.
   */
  private OffsetDateTime requestedQuoteCompletionDate;

  /**
   * Quote version - if the customer rejected the quote but negotiations still
   * open a new version of the quote is managed.
   */
  private @SafeText String version;

  /**
   * A reference to an agreement defining the context of the quote.
   */
  @JsonProperty("agreement")
  private List<@Valid AgreementRef> agreements;

  /**
   * An authorization provided for the quote.
   */
  @JsonProperty("authorization")
  private List<@Valid Authorization> authorizations;

  /**
   * A reference to a billing account to provide quote context information.
   */
  @JsonProperty("billingAccount")
  private List<@Valid BillingAccountRef> billingAccounts;

  /**
   * Information contact related to the quote requester.
   */
  @JsonProperty("contactMedium")
  private List<@Valid ContactMedium> contactMediums;

  /**
   * Free form text associated with the quote.
   */
  @JsonProperty("note")
  private List<@Valid Note> notes;

  /**
   * A reference to a previously done product offering qualification.
   */
  @JsonProperty("productOfferingQualification")
  private List<@Valid ProductOfferingQualificationRef> productOfferingQualifications;

  /**
   * An item of the quote - it is used to descirbe an operation on a product to be
   * quoted.
   */
  @JsonProperty("quoteItem")
  private @Size(min = 1) List<@Valid QuoteItem> quoteItems;

  /**
   * Quote total price.
   */
  @JsonProperty("quoteTotalPrice")
  private List<@Valid QuotePrice> quoteTotalPrices;

  /**
   * A reference to a party playing a role in this quote (customer, seller,
   * requester, etc.).
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * State of the quote : described in the state-machine diagram.
   *
   * @see org.opentmf.v4.tmf648.model.QuoteStateType
   */
  private @SafeText String state;

  /**
   * Quote validity period.
   */
  private @Valid TimePeriod validFor;
}