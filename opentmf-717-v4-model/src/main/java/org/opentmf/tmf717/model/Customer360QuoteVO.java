package org.opentmf.tmf717.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Entity;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Quote can be used to negotiate service and product acquisition or
 * modification between a customer and a service provider. Quote contain list of
 * quote items, a reference to customer (partyRole), a list of productOffering
 * and attached prices and conditions.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-717: Customer360 Management API</li>
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
    defaultImpl = Customer360QuoteVO.class
)
public class Customer360QuoteVO extends Entity implements ICustomer360QuoteVO {

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
   * searches afterwards).
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
   * Date and time when the quote was created.
   */
  private OffsetDateTime quoteDate;

  /**
   * This is requested date - from quote requester - to get a complete response
   * for this quote.
   */
  private OffsetDateTime requestedQuoteCompletionDate;

  /**
   * Possible values for the state of the quote
   * <br/><p>Recommended values: rejected, pending, inProgress, cancelled,
   * approved, accepted.
   *
   * @see org.opentmf.customer.model.QuoteStateType
   */
  private @SafeText String state;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;

  /**
   * Quote version - if the customer rejected the quote but negotiations still
   * open a new version of the quote is managed.
   */
  private @SafeText String version;
}