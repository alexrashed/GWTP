package com.philbeaudoin.gwtp.mvp.client;

import com.google.gwt.user.client.ui.Widget;
import com.philbeaudoin.gwtp.mvp.client.proxy.Place;
import com.philbeaudoin.gwtp.mvp.client.proxy.RevealContentEvent;

/**
 * A presenter that does not have to be a singleton. Single pages
 * from your application will usually implement the singleton
 * {@link Presenter} interface. Use the {@link PresenterWidget}
 * interface for complex widget that need to interact with 
 * model objects, but that can be instantiated in many different
 * places in your application.
 * <p />
 * {@link PresenterWidget}s and {@link Presenter}s are organized in a
 * hierarchy. Parent presenters have links to their child presenters.
 * To reveal a presenter, you call its {@link Presenter#reveal()} method,
 * or you invoke its corresponding {@link Place}. The presenter's 
 * {@link Proxy} then asks the presenter to reveal itself by calling
 * {@link Presenter#forceReveal()}, triggering the following sequence 
 * of operations:
 * <ul>
 * <li> The presenter that wants to reveal itself asks to be set in one of its 
 * parent slot by firing a {@link RevealContentEvent} ;
 * <li> If a presenter already occupies this slot it is removed. If the parent is 
 * currently visible, then {@link PresenterWidgetImpl#onHide()} is called on the removed presenter and, 
 * recursively, on its children (bottom up: first the child, then the parent) ;
 * <li> If the parent is not visible, it asks to be set in one of its parent slot
 * by firing a {@link RevealContentEvent} too, this continue recursively until
 * the top-level or until a visible presenter is reached ;
 * <li> When a visible presenter is reached, it calls {@link PresenterWidgetImpl#onReveal()} on 
 * the presenter it just added to a slot and, recursively, on that presenter's children 
 * (top down: first the parent, then the children);</li>
 * <li> Finally {@link PresenterWidgetImpl#onReset()} is called on all the currently visible presenters</li>
 *     starting from the top-level presenter and going down to the leaf presenters
 *     (top down: first the parent, then the children).</li>
 * </ul>
 * 
 * @author Philippe Beaudoin
 */
public interface PresenterWidget extends HandlerContainer {

  /**
   * Returns the {@link View} for the current presenter.
   *
   * @return The view.
   */
  public View getView();

  /**
   * Verifies if the presenter is currently visible on the screen. A
   * presenter should be visible if it successfully revealed itself
   * and was not hidden later.
   * 
   * @return {@code true} if the presenter is visible, {@code false} otherwise.
   */
  public boolean isVisible();

  /**
   * Makes it possible to access the {@link Widget} object associated with that presenter.
   * 
   * @return The Widget associated with that presenter.
   */
  public Widget getWidget();

}