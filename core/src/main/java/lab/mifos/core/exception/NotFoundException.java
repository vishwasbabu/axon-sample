/**
 * Copyright 2014 Markus Geiss
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package lab.mifos.core.exception;

public class NotFoundException extends Exception {

    private final String resourceKey;
    private final String entityName;
    private final String entityId;

    public NotFoundException(String resourceKey, String entityName, String entityId) {
        super();
        this.resourceKey = resourceKey;
        this.entityName = entityName;
        this.entityId = entityId;
    }

    public String getResourceKey() {
        return resourceKey;
    }

    public String getEntityName() {
        return entityName;
    }

    public String getEntityId() {
        return entityId;
    }
}
