package io.kranberry.ui

import androidx.test.uiautomator.By
import androidx.test.uiautomator.Until
import io.kranberry.log.Log

/**
 * Implicitly waits for the element until the default timeout given in the kranberry.properties file.
 *
 * @param id of the element you want to fetch,
 * it is not necessary to include the full path with the appPackage, Kranberry does this automatically.
 * @return This method returns a boolean, which lets you decide what
 * to do with the result of it (fail the test or try again, for example)
 */
fun BaseUi.waitUntilElementIsPresentById(id: String): Boolean {
    Log.message("Waiting until id '$id' is present")
    device.wait(Until.hasObject(By.res(appPackage, id)), timeout)
    waitForDevice()
    return elementIsPresentById(id)
}


/**
 * Implicitly waits for the element until the default timeout given in the kranberry.properties file.
 *
 * @param id of the element you want to fetch,
 * it is not necessary to include the full path with the appPackage, Kranberry does this automatically.
 * @return This method returns a boolean, which lets you decide what
 * to do with the result of it (fail the test or try again, for example)
 */
fun BaseUi.waitUntilElementIsClickableById(id: String): Boolean {
    device.wait(Until.hasObject(By.res(appPackage, id).clickable(true)), timeout)
    waitForDevice()
    return elementIsPresentById(id)
}

/**
 * Implicitly waits for the element until the default timeout given in the kranberry.properties file.
 *
 * @param visibleText of the element you want to fetch,
 * it is not necessary to include the full path with the appPackage, Kranberry does this automatically.
 * @return This method returns a boolean, which lets you decide what
 * to do with the result of it (fail the test or try again, for example)
 */
fun BaseUi.waitUntilElementIsClickableByText(visibleText: String): Boolean {
    device.wait(Until.hasObject(By.text(visibleText).clickable(true)), timeout)
    waitForDevice()
    return elementIsPresentById(visibleText)
}

/**
 * Implicitly waits for the element until the default timeout given in the kranberry.properties file.
 *
 * @param visibleText of the element you want to fetch,
 * it is not necessary to include the full path with the appPackage, Kranberry does this automatically.
 * @return This method returns a boolean, which lets you decide what
 * to do with the result of it (fail the test or try again, for example)
 */
fun BaseUi.waitUntilElementIsPresentByText(visibleText: String): Boolean {
    Log.message("Waiting until visibleText '$visibleText' is present")
    device.wait(Until.hasObject(By.text(visibleText)), timeout)
    waitForDevice()
    return elementIsPresentByText(visibleText)
}

/**
 * Implicitly waits for the device idle until the default timeout given in the kranberry.properties file.
 *
 */

fun BaseUi.waitForDevice() {
    device.waitForIdle(timeout)
}

/**
 * Implicit wait until the progressbar_class element provided in the
 * kranberry.properties file goes away from the screen.
 * The wait timeout is also given in the kranberry.properties file via the parameter page_load_timeout.
 * For more information, visit the link:
 * https://github.com/kranberry-io/kranberry#kranberry-properties-file
 * @return This method returns a boolean, which lets you decide what
 * to do with the result of it (fail the test or try again, for example)
 */

fun BaseUi.pageLoadingCompleted(): Boolean {
    Log.message("Waiting until '$progressbarClass' is gone")
    device.wait(Until.gone(By.clazz(progressbarClass)), progressBarTimeout)
    return !elementIsPresentByClass(progressbarClass)
}

/**
 * Implicit wait until the progressbar_class element provided in the
 * kranberry.properties file goes away from the screen.
 * @param timeout Desired implicit timeout if you need to use one that
 * is different from the provided in the kranberry.properties file via the parameter page_load_timeout.
 */

fun BaseUi.pageLoadingCompleted(timeout: Long): Boolean {
    Log.message("Waiting until '$progressbarClass' is gone")
    device.wait(Until.gone(By.clazz(progressbarClass)), progressBarTimeout)
    return !elementIsPresentByClass(progressbarClass)
}

/**
 * Implicit wait until the progressbar_class element provided in the
 * kranberry.properties file goes away from the screen.
 * The wait timeout is also given in the kranberry.properties file via the parameter page_load_timeout.
 * For more information, visit the link:
 * https://github.com/kranberry-io/kranberry#kranberry-properties-file
 * @return This method returns a failure if the progressbar_class element does not leave
 * the screen within the time limit stipulated in the kranberry.properties file
 */
fun BaseUi.waitForPageLoad() {
    assertTrue(pageLoadingCompleted())
}

/**
 * Implicitly waits for the element goes away from the screen until the default timeout given
 * in the kranberry.properties file.
 *
 * @param visibleText of the element you want to fetch.
 * @return This method returns a boolean, which lets you decide what
 * to do with the result of it (fail the test or try again, for example)
 */
fun BaseUi.waitUntilElementIsGoneByText(visibleText: String): Boolean {
    Log.message("Waiting until '$visibleText' gone")
    device.wait(Until.gone(By.textContains(visibleText)), timeout)
    waitForDevice()
    return !elementIsPresentByTextContains(visibleText)
}

@Deprecated(
    "Only to maintain backwards compatibility and will be removed soon.",
    ReplaceWith("waitUntilElementIsGoneByText(visibleText)"), DeprecationLevel.WARNING
)
fun BaseUi.elementIsGoneByText(visibleText: String): Boolean {
    return waitUntilElementIsGoneByText(visibleText)
}

/**
 * Implicitly waits for the element goes away from the screen until the default timeout given
 * in the kranberry.properties file.
 *
 * @param id of the element you want to fetch,
 * it is not necessary to include the full path with the appPackage, Kranberry does this automatically.
 * @return This method returns a boolean, which lets you decide what
 * to do with the result of it (fail the test or try again, for example)
 */
fun BaseUi.waitUntilElementIsGoneById(id: String): Boolean {
    Log.message("Waiting until '$id' gone")
    device.wait(Until.gone(By.res(appPackage, id)), timeout)
    waitForDevice()
    return !elementIsPresentById(id)
}

@Deprecated(
    "Only to maintain backwards compatibility and will be removed soon.",
    ReplaceWith("waitUntilElementIsGoneById(id)"), DeprecationLevel.WARNING
)
fun BaseUi.elementIsGoneById(id: String): Boolean {
    return waitUntilElementIsGoneById(id)
}