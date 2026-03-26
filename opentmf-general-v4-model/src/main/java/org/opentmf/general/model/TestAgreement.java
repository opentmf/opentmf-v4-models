package org.opentmf.general.model;

import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-704: Test Case Management API</li>
 *   <li>TMF-705: Test Environment Management API</li>
 *   <li>TMF-706: Test Data Management API</li>
 *   <li>TMF-709: Test Scenario Management API</li>
 *   <li>TMF-710: General Test Artifact Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class TestAgreement implements ITestAgreement {

  /**
   * The agreement name.
   */
  private @SafeText String name;

  /**
   * The terms of the agreement.
   */
  private @SafeText String terms;

  /**
   * The agreement URL.
   */
  private URI url;
}