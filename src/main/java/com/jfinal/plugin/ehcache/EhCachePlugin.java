/**
 * Copyright (c) 2011-2017, James Zhan 詹波 (jfinal@126.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jfinal.plugin.ehcache;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.config.Configuration;

import java.io.InputStream;
import java.net.URL;

/**
 * EhCachePlugin.
 */
public class EhCachePlugin {

  private static CacheManager cacheManager;
  private String configurationFileName;
  private URL configurationFileURL;
  private InputStream inputStream;
  private Configuration configuration;

  public EhCachePlugin() {

  }

  public EhCachePlugin(CacheManager cacheManager) {
    EhCachePlugin.cacheManager = cacheManager;
  }

  public EhCachePlugin(String configurationFileName) {
    this.configurationFileName = configurationFileName;
  }

  public EhCachePlugin(URL configurationFileURL) {
    this.configurationFileURL = configurationFileURL;
  }

  public EhCachePlugin(InputStream inputStream) {
    this.inputStream = inputStream;
  }

  public EhCachePlugin(Configuration configuration) {
    this.configuration = configuration;
  }

  public boolean start() {
    createCacheManager();
    CacheKit.init(cacheManager);
    return true;
  }

  private void createCacheManager() {
    if (cacheManager != null)
      return;

    if (configurationFileName != null) {
      cacheManager = CacheManager.create(configurationFileName);
      return;
    }

    if (configurationFileURL != null) {
      cacheManager = CacheManager.create(configurationFileURL);
      return;
    }

    if (inputStream != null) {
      cacheManager = CacheManager.create(inputStream);
      return;
    }

    if (configuration != null) {
      cacheManager = CacheManager.create(configuration);
      return;
    }

    cacheManager = CacheManager.create();
  }

  public boolean stop() {
    cacheManager.shutdown();
    return true;
  }
}




