package org.opentmf.v4.tmf648.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * Quote can be used to negotiate service and product acquisition or
 * modification between a customer and a service provider. Quote contain list of
 * quote items, a reference to customer (partyRole), a list of productOffering
 * and attached prices and conditions.
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
    defaultImpl = Quote.class
)
@Required(fields = {"quoteItem"})
public class Quote extends QuoteUpdate {

  /**
   * Unique identifier - attributed by quoting system.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * Hyperlink to access the quote.
   */
  private URI href;

  /**
   * Date and time when the quote was created.
   */
  private OffsetDateTime quoteDate;
}