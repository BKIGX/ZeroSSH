/*
 * Copyright 2016 Robert Li.
 * Released under the MIT license
 * https://opensource.org/licenses/MIT
 */
package robertli.zero.core;

/**
 * WebConfiguration is a singleton object to storage configuration information
 * in presentation layer. This object can be use over business layer.
 *
 * @version 1.0.1 2016-09-29
 * @author Robert Li
 */
public interface WebConfiguration {

    public String getDomain();

    public String getImageActionUrl();

    public String getGoogleSigninClientId();

}
