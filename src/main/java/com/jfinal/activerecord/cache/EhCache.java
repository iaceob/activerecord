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

package com.jfinal.activerecord.cache;


import com.jfinal.ehcache.CacheKit;

/**
 * EhCache.
 */
public class EhCache implements ICache {

  @SuppressWarnings("unchecked")
  public <T> T get(String cacheName, Object key) {
    return (T) CacheKit.get(cacheName, key);
  }

  public void put(String cacheName, Object key, Object value) {
    CacheKit.put(cacheName, key, value);
  }

  public void remove(String cacheName, Object key) {
    CacheKit.remove(cacheName, key);
  }

  public void removeAll(String cacheName) {
    CacheKit.removeAll(cacheName);
  }
}


